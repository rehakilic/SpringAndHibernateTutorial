package com.spring.Models.Relationship;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Cacheable for second level caching
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //for separated tables
//@Inheritance(strategy = InheritanceType.JOINED) //for separeted tables with joined to this class
/*@DiscriminatorColumn( // for a single table vehicle with inhetited types ( bike, car etc...)
        name = "Vehicle_Type",
        discriminatorType = DiscriminatorType.STRING
)*/

@NamedQuery(name = "VEHICLE.byId",query = "from Vehicle where vehicleId = ?")
@NamedNativeQuery(name = "VEHICLE.byNativeId",query = "SELECT * FROM vehicle WHERE vehicle_id = ?", resultClass = Vehicle.class)
public class Vehicle {

    private int vehicleId;
    private User user;
    //private Set<User> userList = new HashSet<User>(0);
    private String vehicleName;

    public String getVehicleName() {
        return vehicleName;
    }
    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Id
    @Column(name = "vehicle_id",nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
