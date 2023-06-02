package none.mydomain.personmanager.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Das POJO.
 *
 * @author Chris A.
 */
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String street;
    private String houseNumber;
    private String zipCode;
    private String city;
    private String mobileNumber;
    private String email;

    /**
     * Default Konstruktor auch notwendig!
     *
     * @author Chris A.
     */
    public Person() {
    }

    /**
     * Der Konstruktor.
     *
     * @param title
     * @param firstName
     * @param lastName
     * @param dateOfBirth
     * @param street
     * @param houseNumber
     * @param zipCode
     * @param city
     * @param mobileNumber
     * @param email
     * @author Chris A.
     */
    public Person(String title, String firstName, String lastName, String dateOfBirth,
                  String street, String houseNumber, String zipCode, String city,
                  String mobileNumber, String email) {

        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    /*****************************************
           Getter- und Setter- Methoden
     *****************************************/

    public int getId() {

        return this.id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getTitle() {

        return this.title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getFirstName() {

        return this.firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return this.lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getDateOfBirth() {

        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
    }

    public String getStreet() {

        return this.street;
    }

    public void setStreet(String street) {

        this.street = street;
    }

    public String getHouseNumber() {

        return this.houseNumber;
    }

    public void setHouseNumber(String houseNumber) {

        this.houseNumber = houseNumber;
    }

    public String getZipCode() {

        return this.zipCode;
    }

    public void setZipCode(String zipCode) {

        this.zipCode = zipCode;
    }

    public String getCity() {

        return this.city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public String getMobileNumber() {

        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {

        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {

        return this.email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    /**
     *
     *
     * @return
     * @author Chris A.
     */
    @Override
    public String toString() {

        return String.format("""
                        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                        ID: %s %n%s %s %s (%s) %n%s %s, %s %s %n%s | %s
                        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                        """,
                this.id,
                this.title, this.firstName, this.lastName, this.dateOfBirth,
                this.street, this.houseNumber, this.zipCode, this.city,
                this.mobileNumber, this.email);
    }
}
