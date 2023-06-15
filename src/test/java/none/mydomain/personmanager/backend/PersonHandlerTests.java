package none.mydomain.personmanager.backend;

import org.junit.jupiter.api.Test;

import java.util.List;

public class PersonHandlerTests {

    private final PersonHandler personHandler = new PersonHandler();

    @Test
    public void testAddPerson() {

        Person testPerson1 = new Person("Herr", "Josua", "Erl", "31.12.1911",
                "Kiebitzpohl", "194", "75245", "Neulingen",
                "0156/2031182", "josua_11@company.none");
        int id = personHandler.addDbRecord(testPerson1);

        System.out.println(id);
    }

    @Test
    public void testGetPerson() {

        Person testPerson2 = new Person("Frau", "Friederike", "Müller", "02.05.1912",
                "Kiebitzpohl", "194", "75245", "Neulingen",
                "0156/0123456789", "f.mueller@nonemail.none");
        int id = personHandler.addDbRecord(testPerson2);

        Person person = personHandler.getDbRecord(id);
        System.out.println(person);
    }

    @Test
    public void testGetAll() {

        List<Person> list = personHandler.getDbRecords("FROM Person");

        for (Person p : list) {
            System.out.println(p);
        }
    }
}
