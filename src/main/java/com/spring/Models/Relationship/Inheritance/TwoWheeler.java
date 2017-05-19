package com.spring.Models.Relationship.Inheritance;

import com.spring.Models.Relationship.Vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle {
    private String StreetingHandle;

    public String getStreetingHandle() {
        return StreetingHandle;
    }

    public void setStreetingHandle(String streetingHandle) {
        StreetingHandle = streetingHandle;
    }
}
