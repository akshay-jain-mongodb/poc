package com.learning.triggers.event;


import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.ArrayList;
import java.util.List;

@Component
public class MongoEntityEventPublisher {

    private static final ThreadLocal<List<MongoEntityEvent<?>>> EVENT_HOLDER = ThreadLocal.withInitial(ArrayList::new);

    public void publishEvent(MongoEntityEvent<?> event) {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            EVENT_HOLDER.get().add(event);

            if (!TransactionSynchronizationManager.isSynchronizationActive()) {
                TransactionSynchronizationManager.initSynchronization();
            }

            TransactionSynchronizationManager.registerSynchronization(
                    new MongoTransactionSynchronization(new ArrayList<>(EVENT_HOLDER.get()))
            );
        } else {
            // No transaction — fire immediately
            MongoTransactionSynchronization.processEventImmediately(event);
        }
    }

    static void clearEvents() {
        EVENT_HOLDER.remove();
    }
}
