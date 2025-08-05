package com.learning.triggers.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class OperationDispatcher {

    private final HandlerRegistry handlerRegistry;
    private final Map<String, Method> methodCache = new ConcurrentHashMap<>();

    @Autowired
    public OperationDispatcher(HandlerRegistry handlerRegistry) {
        this.handlerRegistry = handlerRegistry;
    }

    public void dispatch(String collection, String operation, Map<String, Object> data) {
        CollectionHandler handler = handlerRegistry.getHandler(collection);

        String key = handler.getClass().getName() + "#" + operation.toLowerCase();
        Method method = methodCache.computeIfAbsent(key, k -> resolveHandlerMethod(handler, operation));

        try {
            method.invoke(handler, data);
        } catch (Exception e) {
            throw new RuntimeException("Error invoking handler method", e);
        }
    }

    private Method resolveHandlerMethod(CollectionHandler handler, String operation) {
        for (Method method : handler.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(OperationMapping.class)) {
                OperationMapping op = method.getAnnotation(OperationMapping.class);
                if (op.operation().equalsIgnoreCase(operation)) {
                    method.setAccessible(true);
                    return method;
                }
            }
        }
        throw new IllegalArgumentException("No method found for operation: " + operation);
    }
}
