package dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Map;

@DynamoDBTable(tableName = "Calendars")
public class Calendar {
    private String profileId;
    private Map<String, String> calendar;

    @DynamoDBHashKey(attributeName = "profileId")
    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }
    @DynamoDBAttribute(attributeName = "calendar")
    public Map<String, String> getCalendar() {
        return calendar;
    }

    public void setCalendar(Map<String, String> calendar) {
        this.calendar = calendar;
    }
}
