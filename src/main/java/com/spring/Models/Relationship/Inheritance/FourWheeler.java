package com.spring.Models.Relationship.Inheritance;

import com.spring.Models.Relationship.Vehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Car")
public class FourWheeler extends Vehicle {

    private String StreetingWheeler;

    public String getStreetingWheeler() {
        return StreetingWheeler;
    }

    public void setStreetingWheeler(String streetingWheeler) {
        StreetingWheeler = streetingWheeler;
    }
}
