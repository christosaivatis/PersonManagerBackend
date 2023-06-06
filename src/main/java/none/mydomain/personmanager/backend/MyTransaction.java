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
 * @author Chris A.
 */
public class MyTransaction<T> {

    private SessionFactory factory;

    /**
     * Der Konstruktor.
     *
     * @param factory
     * @author Chris A.
     */
    public MyTransaction(SessionFactory factory) {

        this.factory = factory;
    }

    /**
     * Besonderer Dank an Macit Kandemir für diese ausgezeichnete Implementierung!
     *
     * @param function
     * @return
     * @author
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
