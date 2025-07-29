package com.learning.poc.service;

import com.learning.poc.beans.User;
import com.learning.poc.exception.APIException;
import com.learning.poc.repository.CustomerRepository;
import com.learning.poc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class CombinedService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional (rollbackFor = {APIException.class, DuplicateKeyException.class})
    public void performAction() throws APIException, InterruptedException {

        sampleUser();
        customerAction();

    }

    private void customerAction() throws APIException {
        throw new APIException("Sample Exception for Transactional");
     //   customerRepository.insert(new Customer("firstName","lastName"));

     //   System.out.println("Customer Size is +++++++++"+ customerRepository.findAll().size());

    }


    private void sampleUser() throws APIException {
        userRepository.save(new User(222121122,null,new BigDecimal("242234.5"),3434.567567567576,32.2));
    }
}
