package com.learning.triggers.repository;

import com.learning.triggers.model.Customer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, ObjectId> {

    public Customer findByFirstName(String firstName);
    @Query("lastName : ?0")
    public List<Customer> findByLastName(String lastName);

}