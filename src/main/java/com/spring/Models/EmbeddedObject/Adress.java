package com.spring.Models.EmbeddedObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adress {

    @Column(name = "pin_code")
    private String pinCode;


    private String street;


    private String country;

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
