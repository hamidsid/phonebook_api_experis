package Phonebook;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contact {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private long phoneNo;

    public Contact() {
    }


    /**
     * Constructs and initializes the contact with her/his details
     *
     * @param id        unique id for every contact
     * @param firstName First name of the contact
     * @param lastName  last name of the contact
     * @param email     email address of the contact
     * @param phoneNo   phone number of the contact
     */
    public Contact(Integer id, String firstName, String lastName, String email, long phoneNo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo=" + phoneNo +
                '}';
    }
}
