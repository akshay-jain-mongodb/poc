package com.learning.triggers.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.mapping.event.*;
import org.springframework.stereotype.Component;

@Component
public class MongoEntityEventListener extends AbstractMongoEventListener<Object> {

    private static final Logger logger = LoggerFactory.getLogger(MongoEntityEventListener.class);

    private final MongoEntityEventPublisher publisher;

    public MongoEntityEventListener(MongoEntityEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void onBeforeSave(BeforeSaveEvent<Object> event) {
        logger.info("Event onBeforeSave: collectionName {}",event.getCollectionName());
        publisher.publishEvent(new MongoEntityEvent<>(event.getSource(), MongoEntityEventType.BEFORE_SAVE));
    }

    @Override
    public void onAfterSave(AfterSaveEvent<Object> event) {
        logger.info("Event onAfterSave: collectionName {}",event.getCollectionName());
        publisher.publishEvent(new MongoEntityEvent<>(event.getSource(), MongoEntityEventType.AFTER_SAVE));
    }

    @Override
    public void onBeforeDelete(BeforeDeleteEvent<Object> event) {
        logger.info("Event onBeforeDelete: collectionName {}",event.getCollectionName());
        publisher.publishEvent(new MongoEntityEvent<>(event.getSource(), MongoEntityEventType.BEFORE_DELETE));
    }

    @Override
    public void onAfterDelete(AfterDeleteEvent<Object> event) {
        logger.info("Event onAfterDelete: collectionName {}",event.getCollectionName());
        publisher.publishEvent(new MongoEntityEvent<>(event.getSource(), MongoEntityEventType.AFTER_DELETE));
    }

//    onBeforeConvert
//    onAfterConvert
//    onAfterLoad

}
