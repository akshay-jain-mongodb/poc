package com.learning.poc.beans;

import org.springframework.data.annotation.Id;

public class Customer {

//    @Id
//    public String id;

    @Id
    public String firstName;
    public String lastName;

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                firstName, lastName);
    }

}