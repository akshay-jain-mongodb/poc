package com.learning.triggers.registry;

import com.learning.triggers.handlers.CollectionOperationHandler;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
@Component
public class CollectionOperationRegistry implements ApplicationContextAware {

    private final Map<String, Method> handlerMap = new HashMap<>();
    private ApplicationContext context;

    @PostConstruct
    public void init() {
        String[] beanNames = context.getBeanDefinitionNames();
        for (String name : beanNames) {
            Object bean = context.getBean(name);
            // Skip self
            if (bean instanceof CollectionOperationRegistry) continue;

            for (Method method : bean.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(CollectionOperationHandler.class)) {
                    CollectionOperationHandler ann = method.getAnnotation(CollectionOperationHandler.class);
                    String key = buildKey(ann.collection(), ann.operation());
                    method.setAccessible(true);
                    handlerMap.put(key, method);
                }
            }
        }
    }

    public void invokeHandler(String collection, String operation, Object... args) {
        String key = buildKey(collection, operation);
        Method method = handlerMap.get(key);
        if (method == null) {
            throw new IllegalArgumentException("No handler found for: " + collection + " -> " + operation);
        }

        Object bean = context.getBean(method.getDeclaringClass());
        try {
            method.invoke(bean, args);
        } catch (Exception e) {
            throw new RuntimeException("Handler invocation failed", e);
        }
    }

    private String buildKey(String collection, String operation) {
        return collection.toLowerCase() + ":" + operation.toLowerCase();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.context = applicationContext;
    }
}
