package com.learning.poc.repository;

import com.learning.poc.beans.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);
    @Query("lastName : ?0")
    public List<Customer> findByLastName(String lastName);

}