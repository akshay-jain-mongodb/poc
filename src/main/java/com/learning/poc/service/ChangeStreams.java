package com.learning.poc.service;

import org.springframework.stereotype.Service;


@Service
public class ChangeStreams {

    public static void main(String[] args) {


        String uri = ""; // Update with your MongoDB URI

/*
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("mygrocerylist");
            MongoCollection<Document> collection = database.getCollection("customer");

            // If  FullDocumentBeforeChange.REQUIRED then if
            // we have not enabled preSnapshot we will get MongoQueryException
            // if FullDocumentBeforeChange.WHEN_AVAILABLE if the pres
            MongoCursor<ChangeStreamDocument<Document>> cursor = collection.watch()
                    .fullDocumentBeforeChange(FullDocumentBeforeChange.REQUIRED) // Ensure document is stored
                    .iterator();

            System.out.println("Watching for delete operations...");

            while (cursor.hasNext()) {
                ChangeStreamDocument<Document> change = cursor.next();

                if ("delete".equals(change.getOperationType().getValue())) {
                    Document fullDocumentBeforeChange = change.getFullDocumentBeforeChange();

                    if (fullDocumentBeforeChange != null) {
                        System.out.println("Document deleted: " + fullDocumentBeforeChange.toJson());
                    } else {
                        System.out.println("Deleted document snapshot not available!");
                    }
                }
            }
        }
*/
    }
}




//        ConnectionString connectionString = new ConnectionString("mongodb+srv://admin:admin@myatlasclusteredu.wvsjx.mongodb.net/mygrocerylist");
//        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
//        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
//        MongoClientSettings clientSettings = MongoClientSettings.builder()
//                .applyConnectionString(connectionString)
//                .codecRegistry(codecRegistry)
//                .build();
//
//        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
//            MongoDatabase db = mongoClient.getDatabase("mygrocerylist");
//            MongoCollection<Customer> customers = db.getCollection("customer", Customer.class);
//            List<Bson> pipeline;
//
//            // Only uncomment one example at a time. Follow instructions for each individually then kill all remaining processes.
//
//            /** => Example 1: print all the write operations.
//             *  => Start "ChangeStreams" then "MappingPOJOs" to see some change events.
//             */
//            //customers.watch().forEach(printEvent());
//
//            /** => Example 2: print only insert and delete operations.
//             *  => Start "ChangeStreams" then "MappingPOJOs" to see some change events.
//             */
////             pipeline = List.of(match(in("operationType", List.of("insert", "delete"))));
////             grades.watch(̈).forEach(̈());
//
//            /** => Example 3: print only updates without fullDocument.
//             *  => Start "ChangeStreams" then "Update" to see some change events (start "Create" before if not done earlier).
//             */
////             pipeline = List.of(match(eq("operationType", "update")));
////             grades.watch(pipeline).forEach(printEvent());
//
//            /** => Example 4: print only updates with fullDocument.
//             *  => Start "ChangeStreams" then "Update" to see some change events.
//             */
////             pipeline = List.of(match(eq("operationType", "update")));
////             grades.watch(pipeline).fullDocument(UPDATE_LOOKUP).forEach(printEvent());
//
//            /**
//             * => Example 5: iterating using a cursor and a while loop + remembering a resumeToken then restart the Change Streams.
//             * => Start "ChangeStreams" then "Update" to see some change events.
//             */
////             exampleWithResumeToken(grades);
//        }
//   }


//
//    private static void exampleWithResumeToken(MongoCollection<Customer> customers) {
//        List<Bson> pipeline = List.of(match(eq("operationType", "update")));
//        ChangeStreamIterable<Customer> changeStream = customers.watch(pipeline);
//        MongoChangeStreamCursor<ChangeStreamDocument<Customer>> cursor = changeStream.cursor();
//        System.out.println("==> Going through the stream a first time & record a resumeToken");
//        int indexOfOperationToRestartFrom = 5;
//        int indexOfIncident = 8;
//        int counter = 0;
//        BsonDocument resumeToken = null;
//        while (cursor.hasNext() && counter != indexOfIncident) {
//            ChangeStreamDocument<Customer> event = cursor.next();
//            if (indexOfOperationToRestartFrom == counter) {
//                resumeToken = event.getResumeToken();
//            }
//            System.out.println(event);
//            counter++;
//        }
//        System.out.println("==> Let's imagine something wrong happened and I need to restart my Change Stream.");
//        System.out.println("==> Starting from resumeToken=" + resumeToken);
//        assert resumeToken != null;
//        customers.watch(pipeline).resumeAfter(resumeToken).forEach(printEvent());
//    }

//    private static Consumer<ChangeStreamDocument<Customer>> printEvent() {
//        return System.out::println;
//    }