package com.learning.poc.repository;

import com.learning.poc.beans.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

  public User findByUserName(String userName);
}