package com.learning.poc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;

@Configuration
public class MongoConfig{


    @Bean
    MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }


//
//    private final MongoCommandListener commandListener;
//
//    public MongoConfig(MongoCommandListener commandListener) {
//        this.commandListener = commandListener;
//    }
//
//    @Bean
//    public MongoClient mongoClient(MongoCommandListener mongoCommandListener) {
//        MongoClientSettings settings = MongoClientSettings.builder()
//                .applyConnectionString(new com.mongodb.ConnectionString("mongodb+srv://admin:admin@myatlasclusteredu.wvsjx.mongodb.net/?retryWrites=true&w=majority&appName=myAtlasClusterEDU"))
//                .addCommandListener(mongoCommandListener)
//                .build();
//        return MongoClients.create(settings);
//    }
/*
    Ensuring MongoTemplate Uses Our MongoClient
    By default, MongoTemplate will use the MongoClient bean we defined. However, to ensure this explicitly, modify the MongoConfig like this:

*/


//    @Bean
//    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
//        return new MongoTemplate(mongoClient, "mygrocerylist");
//    }


}