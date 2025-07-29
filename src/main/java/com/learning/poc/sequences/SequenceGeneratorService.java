package com.learning.poc.sequences;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class SequenceGeneratorService {

    @Autowired
    private MongoTemplate mongoTemplate;
//
//    //GET /sequence/order-sequence?blockSize=100
//    public synchronized SequenceBlock getNextSequenceBlock(String name, int blockSize) {
//        Query query = new Query(Criteria.where("_id").is(name));
//        Update update = new Update().inc("nextValue", blockSize);
//
//        FindAndModifyOptions options = new FindAndModifyOptions()
//                .returnNew(true)
//                .upsert(true);
//
//        Sequence updated = mongoTemplate.findAndModify(query, update, options, Sequence.class);
//
//        long end = updated.getNextValue();
//        long start = end - blockSize + 1;
//
//        return new SequenceBlock(start, end);
//    }
//
//    GET http://sequence-service/sequence/order-sequence?blockSize=100
//
//    SequenceBlock block = restTemplate.getForObject(
//            "http://sequence-service/sequence/order-sequence?blockSize=100",
//            SequenceBlock.class
//    );
//
//
//    @Component
//    public class SharedDataStore {
//
//        private final Map<String, String> sharedMap = new ConcurrentHashMap<>();
//
//        public void put(String key, String value) {
//            sharedMap.put(key, value);
//        }
//
//        public String get(String key) {
//            return sharedMap.get(key);
//        }
//
//        public Map<String, String> getAll() {
//            return sharedMap;
//        }
//    }
//
//    @Service
//    public class MyService {
//
//        private final SharedDataStore sharedDataStore;
//
//        public MyService(SharedDataStore sharedDataStore) {
//            this.sharedDataStore = sharedDataStore;
//        }
//
//        public void someMethod() {
//            sharedDataStore.put("key", "value");
//            String value = sharedDataStore.get("key");
//        }
//    }
}
