package com.learning.poc.service;

import com.learning.poc.beans.User;
import com.learning.poc.exception.APIException;
import com.learning.poc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void sampleUser() throws APIException, InterruptedException {
        double result = 3434.567567567576*32.232;
        userRepository.save(new User(222121122,null,new BigDecimal("242234.5"),3434.567567567576,result));
    }
}
