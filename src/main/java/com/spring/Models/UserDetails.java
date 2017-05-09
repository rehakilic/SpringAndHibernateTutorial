package com.spring.Models;

import com.spring.Models.EmbeddedObject.Adress;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

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
    @JoinTable(name = "user_addresses",
        joinColumns = @JoinColumn(name = "user_id")
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment-gen", strategy = "increment")
    @CollectionId(columns = {@Column(name = "address_id")}, generator = "increment-gen", type = @Type(type = "int"))
    private Collection<Adress> listOfOtherAddresses = new ArrayList<Adress>();

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


    public Collection<Adress> getListOfOtherAddresses() {
        return listOfOtherAddresses;
    }

    public void setListOfOtherAddresses(Collection<Adress> listOfOtherAddresses) {
        this.listOfOtherAddresses = listOfOtherAddresses;
    }
}
