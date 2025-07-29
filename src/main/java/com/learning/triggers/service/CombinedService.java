package com.learning.triggers.service;


import com.learning.triggers.exception.APIException;
import com.learning.triggers.model.Customer;
import com.learning.triggers.model.User;
import com.learning.triggers.repository.CustomerRepository;
import com.learning.triggers.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CombinedService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;


    @Transactional (rollbackFor = {APIException.class, DuplicateKeyException.class})
    public void performAction() throws APIException, InterruptedException {

        userAction();
       // throwException();
        customerAction();

    }

    private void throwException() throws APIException {
        throw new APIException("Sample Exception for Transactional");
    }

    private void customerAction() throws APIException {
        customerRepository.insert(new Customer(new ObjectId(),"firstName","lastName"));
    }

    private void userAction() throws APIException {
        userRepository.save(new User("Test User 1"));
    }
}
