package com.learning.triggers.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class HandlerRegistry {
    private final Map<String, CollectionHandler> handlerMap = new ConcurrentHashMap<>();

    @Autowired
    public HandlerRegistry(List<CollectionHandler> handlers) {
        for (CollectionHandler handler : handlers) {
            String beanName = handler.getClass().getSimpleName();
            String collection = beanName.replace("Handler", "").toLowerCase();
            handlerMap.put(collection, handler);
        }
    }

    public CollectionHandler getHandler(String collection) {
        CollectionHandler handler = handlerMap.get(collection.toLowerCase());
        if (handler == null) {
            throw new IllegalArgumentException("No handler found for: " + collection);
        }
        return handler;
    }
}

