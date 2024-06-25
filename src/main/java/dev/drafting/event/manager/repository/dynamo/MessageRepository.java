package dev.drafting.event.manager.repository.dynamo;

import dev.drafting.event.manager.model.MessageModel;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

@EnableScan
public interface MessageRepository extends DynamoDBCrudRepository<MessageModel, String> {
}
