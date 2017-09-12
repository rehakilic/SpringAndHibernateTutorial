package com.spring.Models.Relationship;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity (name = "USER")

public class User {

    private int userId;
    private Set<Vehicle> vehicleList = new HashSet<Vehicle>(0);
    private String userName;

    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }


    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    //@ManyToMany
    public Set<Vehicle> getVehicleList() {
        return vehicleList;
    }
    public void setVehicleList(Set<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @Id
    @Column(name = "user_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
