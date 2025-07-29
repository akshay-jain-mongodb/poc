package com.learning.triggers.event;

public class MongoEntityEvent<T> {
    private final T entity;
    private final MongoEntityEventType type;

    public MongoEntityEvent(T entity, MongoEntityEventType type) {
        this.entity = entity;
        this.type = type;
    }

    public T getEntity() {
        return entity;
    }

    public MongoEntityEventType getType() {
        return type;
    }
}
