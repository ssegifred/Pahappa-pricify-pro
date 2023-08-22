package org.pahappa.systems.pahappapricifypro.models.client;

import org.pahappa.systems.pahappapricifypro.models.constants.Gender;
import org.sers.webutils.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name="clients")
public class Client extends BaseEntity  {
    private String firstName;
    private String lastName;
    private String companyName;
    private String contact;
    private String email;
    private String location;
    private Gender gender;
@Column(name="first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
@Column(name="last_name",nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
@Column(name="company_name",nullable = false)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
@Column(name="contact",nullable = false)
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
@Column(name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
@Column(name="location", nullable = false)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    @Enumerated(EnumType.STRING)
@Column(name="gender",nullable = false)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
