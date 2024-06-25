package dev.drafting.event.manager;

import dev.drafting.event.manager.repository.dynamo.MessageRepository;
import dev.drafting.event.manager.repository.jpa.UserRepository;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDynamoDBRepositories(basePackageClasses = MessageRepository.class)
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class EventManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventManagerApplication.class, args);
	}

}
