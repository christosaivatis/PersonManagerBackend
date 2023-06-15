package none.mydomain.personmanager.backend;

import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void testCreatePerson() {

        Person testPerson = new Person("Herr", "Josua", "Erl", "31.12.1911",
                "Kiebitzpohl", "194", "75245", "Neulingen",
                "0156/2031182" , "josua_11@company.none");

        System.out.println(testPerson);
    }
}
