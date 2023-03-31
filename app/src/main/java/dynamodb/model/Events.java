package dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Date;
import java.util.List;
@DynamoDBTable(tableName = "Events")
public class Events {
    private String eventId;
    private String location;
    private List<Date> dates;
    private String startTime;
    private String endTime;
    private String description;
    private String category;
    private String price_range;
}
