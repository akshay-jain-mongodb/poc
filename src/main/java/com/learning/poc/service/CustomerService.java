package com.learning.poc.service;

import com.learning.poc.beans.Customer;
import com.learning.poc.exception.APIException;
import com.learning.poc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void customerAction() throws APIException {
        System.out.println("Customer Size before is +++++++++"+ customerRepository.count());

        customerRepository.save(new Customer("sample3","user new1"));  //sample old,user old
//        customerRepository.save(new Customer("Insetrting3","New User"));
        customerRepository.deleteById("firstName");
        System.out.println("Customer Size  after is +++++++++"+ customerRepository.count());
    }
}
