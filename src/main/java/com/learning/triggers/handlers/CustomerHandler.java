package com.learning.triggers.handlers;

import org.springframework.stereotype.Component;

@Component
public class CustomerHandler {

    @CollectionOperationHandler(collection = "customer", operation = "insert")
    public void insertCustomer(Object payload) {
        System.out.println("Inserting customer: " + payload);
    }

    @CollectionOperationHandler(collection = "customer", operation = "update")
    public void updateCustomer(Object payload) {
        System.out.println("Updating customer: " + payload);
    }

    @CollectionOperationHandler(collection = "customer", operation = "delete")
    public void deleteCustomer(Object payload) {
        System.out.println("Deleting customer: " + payload);
    }
}
