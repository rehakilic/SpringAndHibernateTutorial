package com.spring.Models.Relationship;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Vehicle {

    private int vehicleId;
    //private User user;
    private Set<User> userList = new HashSet<User>(0);
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }


    @ManyToMany(mappedBy = "vehicleList")
    public Set<User> getUserList() {
        return userList;
    }

    public void setUserList(Set<User> userList) {
        this.userList = userList;
    }
}
