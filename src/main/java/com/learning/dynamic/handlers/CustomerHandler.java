package com.learning.dynamic.handlers;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component("customer")
public class CustomerHandler implements  CollectionHandler{

    @OperationMapping(operation = "insert")
    public void insert(Map<String, Object> data) {
        System.out.println("Inside customer Insert");
    }

    @OperationMapping(operation = "update")
    public void update(Map<String, Object> data) {
        System.out.println("Inside customer Update");

    }
}
