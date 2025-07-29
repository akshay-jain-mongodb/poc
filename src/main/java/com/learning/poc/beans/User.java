package com.learning.poc.beans;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class User {

    @JsonProperty("_id")
    private ObjectId id = null;

    public String userName;

    public User(int i, Object o, BigDecimal bigDecimal, double v, double result) {
    }
}