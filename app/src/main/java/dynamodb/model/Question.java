package dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Questions")
public class Question {
    public String questionId;
    public String question;
}
