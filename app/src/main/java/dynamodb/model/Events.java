package dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Date;
import java.util.List;
@DynamoDBTable(tableName = "Events")
public class Events {
    private String eventId;

    private String name;
    private String location;
    private String date;
    private String startTime;
    private String endTime;
    private String description;
    private String category;
    private String price_range;

    @DynamoDBHashKey(attributeName = "eventId")
    public String getEventId() {
        return eventId;
    }
    @DynamoDBAttribute(attributeName = "name")
    public String getName(String name){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
    @DynamoDBAttribute(attributeName = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    @DynamoDBRangeKey(attributeName = "dates")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    @DynamoDBAttribute(attributeName = "startTime")
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    @DynamoDBAttribute(attributeName = "endTime")
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    @DynamoDBAttribute(attributeName = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @DynamoDBAttribute(attributeName = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    @DynamoDBAttribute(attributeName = "priceRange")
    public String getPrice_range() {
        return price_range;
    }

    public void setPrice_range(String price_range) {
        this.price_range = price_range;
    }
}
