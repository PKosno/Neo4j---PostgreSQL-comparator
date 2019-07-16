package project.app.modelRD;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "Actors")
public class Actors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String gender;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @ManyToMany
    private List<Awards> awards;

    public Actors() {
    }

    public Actors(String firstname, String lastname, String gender, Address address, List<Awards> awards) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.address = address;
        this.awards = awards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Awards> getAwards() {
        return awards;
    }

    public void setAwards(List<Awards> awards) {
        this.awards = awards;
    }
}
