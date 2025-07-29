package com.learning.triggers.event;


import com.learning.triggers.processor.MongoEntityEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronization;

import java.util.List;

@Component
public class MongoTransactionSynchronization implements TransactionSynchronization {

    private static MongoEntityEventHandler handler;
    private final List<MongoEntityEvent<?>> events;

    public MongoTransactionSynchronization(List<MongoEntityEvent<?>> events) {
        this.events = events;
    }

    @Autowired
    public void setHandler(MongoEntityEventHandler handler) {
        MongoTransactionSynchronization.handler = handler;
    }

    @Override
    public void afterCommit() {
        for (MongoEntityEvent<?> event : events) {
            handler.handleAsync(event); // async processing
        }
    }

    @Override
    public void afterCompletion(int status) {
        MongoEntityEventPublisher.clearEvents(); // cleanup
    }

    public static void processEventImmediately(MongoEntityEvent<?> event) {
        if (handler != null) {
            handler.handleAsync(event);
        }
    }
}
