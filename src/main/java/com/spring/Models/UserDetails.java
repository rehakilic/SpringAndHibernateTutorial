package com.spring.Models;

import com.spring.Models.EmbeddedObject.Adress;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity (name = "USER_DETAILS")
public class UserDetails {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "user_name")
    private String userName;

    @Embedded
    private Adress address;

    @ElementCollection
    private Set<Adress> listOfOtherAddresses = new HashSet<Adress>();

    @Lob
    private String bio;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;



    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }


    public Adress getAddress() {
        return address;
    }
    public void setAddress(Adress address) {
        this.address = address;
    }


    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }


    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public Set<Adress> getListOfOtherAddresses() {
        return listOfOtherAddresses;
    }

    public void setListOfOtherAddresses(Set<Adress> listOfOtherAddresses) {
        this.listOfOtherAddresses = listOfOtherAddresses;
    }
}
