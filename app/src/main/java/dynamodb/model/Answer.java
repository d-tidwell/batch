package dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Answers")
public class Answer {
    public String profileId;
    public String questionId;
    public String answer;
    public Boolean showHide;
}
