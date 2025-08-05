package com.learning.dynamic;

import com.learning.dynamic.handlers.OperationDispatcher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DynamicHandlersMongodbApplication implements CommandLineRunner {

    private OperationDispatcher dispatcher;

    public DynamicHandlersMongodbApplication(OperationDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public static void main(String[] args) {
        SpringApplication.run(DynamicHandlersMongodbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        dispatcher.dispatch("user", "insert", null);
        dispatcher.dispatch("customer", "insert", null);
        dispatcher.dispatch("user", "update", null);
        dispatcher.dispatch("customer", "update", null);
    }
}