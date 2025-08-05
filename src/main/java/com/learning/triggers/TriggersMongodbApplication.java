package com.learning.triggers;

import com.learning.triggers.handlers.OperationDispatcher;
import com.learning.triggers.service.CombinedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TriggersMongodbApplication implements CommandLineRunner {

    @Autowired
    CombinedService combinedService;

    public static void main(String[] args) {
        SpringApplication.run(com.learning.triggers.TriggersMongodbApplication.class, args);
    }

    private OperationDispatcher dispatcher;

    public TriggersMongodbApplication(OperationDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Override
    public void run(String... args) throws Exception {
        dispatcher.dispatch("user", "insert", null);
        dispatcher.dispatch("customer", "insert", null);
        dispatcher.dispatch("user", "update", null);
        dispatcher.dispatch("customer", "update", null);
    }
}