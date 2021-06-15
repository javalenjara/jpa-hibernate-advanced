package com.jpa.hibernate.demojpaadvanced.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String addressLine1;
    private String addressLine2;
    private String city;

    protected Address() {
    }

    public Address(String addressLine1, String addressLine2, String city) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
    }
}
