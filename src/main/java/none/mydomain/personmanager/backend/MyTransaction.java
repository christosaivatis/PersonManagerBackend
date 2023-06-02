package none.mydomain.personmanager.backend;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.function.Function;

/**
 *
 *
 * @param <T>
 *
 */
public class MyTransaction<T> {

    private SessionFactory factory;

    /**
     * Der Konstruktor.
     *
     * @param factory
     *
     */
    public MyTransaction(SessionFactory factory) {

        this.factory = factory;
    }

    /**
     *
     *
     * @param function
     * @return
     *
     */
    synchronized public T commit(Function<Session, T> function) {

        Transaction ta = null;

        try (Session session = factory.openSession();) {
            ta = session.beginTransaction();
            T rv = function.apply(session);
            ta.commit();
            return rv;
        }
        catch (HibernateException e) {
            if (ta != null) ta.rollback();
        }

        return null;
    }
}
