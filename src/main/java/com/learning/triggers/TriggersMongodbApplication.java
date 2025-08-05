package com.learning.triggers;

import com.learning.triggers.registry.CollectionOperationRegistry;
import com.learning.triggers.service.CombinedService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TriggersMongodbApplication implements CommandLineRunner {

    @Autowired
    CombinedService combinedService;

   private ObjectProvider<CollectionOperationRegistry> registryProvider;


    public static void main(String[] args) {
        SpringApplication.run(com.learning.triggers.TriggersMongodbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
 //       combinedService.performAction();

        registryProvider.getObject().invokeHandler("user", "insert");
    }
}