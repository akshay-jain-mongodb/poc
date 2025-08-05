package com.learning.dynamic.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component("user")
public class UserHandler implements CollectionHandler{

    @Autowired
    private MongoTemplate mongoTemplate;

    @OperationMapping(operation = "insert")
    public void insert(Map<String, Object> data) {
        System.out.println("Inside User Insert");
    }

    @OperationMapping(operation = "update")
    public void update(Map<String, Object> data) {
        System.out.println("Inside User Update");
    }
}
