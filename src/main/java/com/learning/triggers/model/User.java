package com.learning.triggers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Builder
@Document(collection = "user")
public class User {

    @JsonProperty("_id")
    private ObjectId id = null;

    public String userName;


    public User(String userName) {
        this.userName = userName;
    }
}