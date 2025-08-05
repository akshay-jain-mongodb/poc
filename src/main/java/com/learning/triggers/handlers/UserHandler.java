package com.learning.triggers.handlers;

import org.springframework.stereotype.Component;

@Component
public class UserHandler {

    @CollectionOperationHandler(collection = "user", operation = "insert")
    public void insertUser(Object payload) {
        System.out.println("Inserting user: " + payload);
    }

    @CollectionOperationHandler(collection = "user", operation = "update")
    public void updateUser(Object payload) {
        System.out.println("Updating user: " + payload);
    }

    @CollectionOperationHandler(collection = "user", operation = "delete")
    public void deleteUser(Object payload) {
        System.out.println("Deleting user: " + payload);
    }
}
