package com.spring.Models.Relationship;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //for separated tables
//@Inheritance(strategy = InheritanceType.JOINED) //for separeted tables with joined to this class
/*@DiscriminatorColumn( // for a single table vehicle with inhetited types ( bike, car etc...)
        name = "Vehicle_Type",
        discriminatorType = DiscriminatorType.STRING
)*/
public class Vehicle {

    private int vehicleId;
    //private User user;
    //private Set<User> userList = new HashSet<User>(0);
    private String vehicleName;

    public String getVehicleName() {
        return vehicleName;
    }
    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }*/

    @Id
    @Column(name = "vehicle_id",nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.TABLE)
    public int getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

/*
    @ManyToMany(mappedBy = "vehicleList")
    //@NotFound(action = NotFoundAction.IGNORE)
    public Set<User> getUserList() {
        return userList;
    }

    public void setUserList(Set<User> userList) {
        this.userList = userList;
    }
*/
}
