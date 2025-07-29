package com.learning.poc.listener;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mongo")
public class MongoTrackingController {
//
//    @Autowired
//    CustomerRepository cr;
//
//    @Autowired
//    UserRepository ur;
//
//    @Autowired
//    MongoTemplate mongoTemplate;
//
//    @GetMapping("/impacted-operations")
//    public List<Map<String, Object>> getImpactedOperations() {
//        return MongoCommandListener.getImpactedOperations();
//    }
//
//    @GetMapping("/test")
//     public void testIt(){
//        Customer c = new Customer("test13","tetse3");
//        cr.save(c);
//        User user = new User("w334");
//        ur.save(user);
//
//    }
//
//    @GetMapping("/read")
//    public void read(){
//        //Customer c = new Customer("test13","tetse3");
//     //   cr.findAll();
//       // User user = new User("w334");
//       // ur.save(user);
//
//        Query query = new Query();
//        query.addCriteria(Criteria.where("userName").is("test")); // age > given value
//        System.out.println( mongoTemplate.find(query, User.class));
//
//    }
}