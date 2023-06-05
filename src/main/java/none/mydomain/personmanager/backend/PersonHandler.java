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
            this.factory = new Configuration().configure().
                    addAnnotatedClass(Person.class).buildSessionFactory();
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

        // Die klassische Art.
//        Function<Session, Person> function = new Function<>() {
//            @Override
//            public Person apply(Session session) {
//                Person p = session.get(Person.class, personID);
//                return p;
//            }
//        };
//
//        Person rv = ta.commit(function);

        // Die moderne Art.
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

    /**
     * Sucht in der Datenbank nach allen Personen,
     * die den Kriterien im HQL-String entsprechen,
     * und gibt diese als eine Liste zurück.
     * (HQL = "Hibernate Query Language")
     *
     * @param hql Das HQL-String mit den erwünschten Kriterien.
     * @return Eine Liste mit allen Personen, die den Kriterien entsprechen.
     * @author Chris A.
     */
    public List<Person> getSome(String hql) {

        var ta = new MyTransaction<List<Person>>(this.factory);

        return ta.commit(session -> {
            return session.createQuery(hql, Person.class).list();
        });
    }
}
