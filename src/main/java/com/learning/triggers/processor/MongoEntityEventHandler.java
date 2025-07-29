package com.learning.triggers.processor;

import com.learning.triggers.event.MongoEntityEvent;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MongoEntityEventHandler {

    private static final Logger logger = LoggerFactory.getLogger(MongoEntityEventHandler.class);


    @Async("mongoEventExecutor")
    public void handleAsync(MongoEntityEvent<?> event) {
        logger.info("----Inside async thread----");
        log.info("Handled event asynchronously: type={}, entity={}", event.getType(), event.getEntity());
    }
}
