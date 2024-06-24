package dev.drafting.event.manager.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.config.AbstractDynamoDBConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBConfig extends AbstractDynamoDBConfiguration {
    private final String awsAccessKey;
    private final String awsSecretKey;
    private final String awsRegion;
    private final String dynamoDbEndpoint;

    public DynamoDBConfig(@Value("${amazon.aws.accesskey}") String awsAccessKey,
                          @Value("${amazon.aws.secretkey}") String awsSecretKey,
                          @Value("${amazon.aws.region}") String awsRegion,
                          @Value("${amazon.dynamodb.endpoint}") String dynamoDbEndpoint) {
        this.awsAccessKey = awsAccessKey;
        this.awsSecretKey = awsSecretKey;
        this.awsRegion = awsRegion;
        this.dynamoDbEndpoint = dynamoDbEndpoint;
    }

    @Override
    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(amazonAWSCredentials()))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(dynamoDbEndpoint, awsRegion))
                .build();
    }

    @Override
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(awsAccessKey, awsSecretKey);
    }
}
