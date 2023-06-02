package none.mydomain.personmanager.backend;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 *
 */
public class PersonHandler {

    private SessionFactory factory;

    /**
     * Der Konstruktor.
     *
     * @author Chris A.
     */
    public PersonHandler() {

        try {
            this.factory = new Configuration().configure().addAnnotatedClass(Person.class).buildSessionFactory();
        }
        catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    /**
     * mit <code>persist()</code>
     *
     * @param person
     * @return
     *
     */
    public Integer addPerson(Person person) {

        var ta = new MyTransaction<Integer>(this.factory);

        Integer id = ta.commit(session -> {
            session.persist(person);
            return person.getId();
        });

        return id;
    }

    /**
     * mit <code>get()</code>
     *
     * @param personID
     * @return
     *
     */
    public Person getPerson(int personID) {

        var ta = new MyTransaction<Person>(this.factory);

        Person rv = ta.commit(session -> {
            Person p = session.get(Person.class, personID);
            return p;
        });

        return rv;
    }

    /**
     * mit <code>createQuery()</code>
     *
     * @return
     *
     */
    public List<Person> getAll() {

        var ta = new MyTransaction<List<Person>>(this.factory);

        return ta.commit(session -> {
            return session.createQuery("FROM Person", Person.class).list();
        });
    }
}
