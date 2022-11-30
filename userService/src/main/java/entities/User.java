package entities;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "user", schema = "seminarUserService")
public class User {

    private int id;
    private String email;
    private String password;

    private String city;
    private String country;

    private String firstName;

    private String lastName;


    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "user_id"
    )
    @SequenceGenerator(
            name = "user_id",
            sequenceName = "seminarUserService.seq_nutzer_id",
            allocationSize = 1
    )
    @Column(name = "user_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;

    }

    @Basic
    @Column(name = "passwort")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;

    }


    @Basic
    @Column(name = "stadt")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @Basic
    @Column(name = "land")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "vorname")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Basic
    @Column(name = "nachname")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
