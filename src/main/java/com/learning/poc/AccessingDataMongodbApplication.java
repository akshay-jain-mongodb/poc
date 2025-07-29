package com.learning.poc;

import com.learning.poc.repository.CustomerRepository;
import com.learning.poc.service.CombinedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository cr;
//	@Autowired
//	private ChangeStreams cs;

	@Autowired
	private CombinedService combinedService;
	@Override
	public void run(String... args) throws Exception {
		//combinedService.performAction();
	}

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataMongodbApplication.class, args);
	}
}
//
//@Configuration
//@EnableMongoAuditing
//class Config {
//
//	@Bean
//	public AuditorAware<AuditableUser> myAuditorProvider() {
//		return new AuditorAwareImpl();
//	}
//}

//
//@Configuration
//static class Config extends AbstractMongoClientConfiguration {
//
//	@Bean
//	MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
//		return new MongoTransactionManager(dbFactory);
//	}
//
//	@Bean
//	MongoTemplate mongoTemplate(MongoDatabaseFactory dbFactory) {
//		return new MongoTemplate(dbFactory);
//	}
//
//	// ...
//}
//
//@Component
//public class StateService {
//
//	@Transactional
//	void someBusinessFunction(Step step) {
//
//		template.insert(step);
//
//		process(step);
//
//		template.update(Step.class).apply(Update.set("state", // ...
//	};
//});



/*

Controlling MongoDB-specific Transaction Options
Transactional service methods can require specific transaction options to run a transaction. Spring Data MongoDB’s transaction managers support evaluation of transaction labels such as @Transactional(label = { "mongo:readConcern=available" }).

By default, the label namespace using the mongo: prefix is evaluated by MongoTransactionOptionsResolver that is configured by default. Transaction labels are provided by TransactionAttribute and available to programmatic transaction control through TransactionTemplate and TransactionalOperator. Due to their declarative nature, @Transactional(label = …) provides a good starting point that also can serve as documentation.

		Currently, the following options are supported:

Max Commit Time
Controls the maximum execution time on the server for the commitTransaction operation. The format of the value corresponds with ISO-8601 duration format as used with Duration.parse(…).

Usage: mongo:maxCommitTime=PT1S

Read Concern
Sets the read concern for the transaction.

Usage: mongo:readConcern=LOCAL|MAJORITY|LINEARIZABLE|SNAPSHOT|AVAILABLE

Read Preference
Sets the read preference for the transaction.

Usage: mongo:readPreference=PRIMARY|SECONDARY|SECONDARY_PREFERRED|PRIMARY_PREFERRED|NEAREST

Write Concern
Sets the write concern for the transaction.

Usage: mongo:writeConcern=ACKNOWLEDGED|W1|W2|W3|UNACKNOWLEDGED|JOURNALED|MAJORITY*/
