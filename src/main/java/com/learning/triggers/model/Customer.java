package com.learning.triggers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "customer")
public class Customer {

    @Id
    @JsonProperty("_id")
    private ObjectId id;

    private String firstName;
    private String lastName;

    public Customer(ObjectId id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
