package dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.List;

@DynamoDBTable(tableName = "Profiles")
public class Profile {
    public String profileId;
    private String username;
    private Integer age;
    private String gender;
    private List<String> seeking;
    private List<String> datingPreferences;
    private String location;
    private List<String> friendsList;
    private List<Integer> profileVector;
    private String profilePictureId;

    @DynamoDBHashKey(attributeName = "profileId")
    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }
    @DynamoDBAttribute(attributeName = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @DynamoDBRangeKey(attributeName = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    @DynamoDBAttribute(attributeName = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    @DynamoDBAttribute(attributeName= "seeking")
    public List<String> getSeeking() {
        return seeking;
    }

    public void setSeeking(List<String> seeking) {
        this.seeking = seeking;
    }
    @DynamoDBAttribute(attributeName = "datingPreference")
    public List<String> getDating_preferences() {
        return datingPreferences;
    }

    public void setDating_preferences(List<String> dating_preferences) {
        this.datingPreferences = dating_preferences;
    }
    @DynamoDBAttribute(attributeName = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    @DynamoDBAttribute(attributeName = "friendsList")
    public List<String> getFriendsList() {
        return friendsList;
    }

    public void setFriendsList(List<String> friendsList) {
        this.friendsList = friendsList;
    }
    @DynamoDBAttribute(attributeName = "profileVector")
    public List<Integer> getProfileVector() {
        return profileVector;
    }

    public void setProfileVector(List<Integer> profileVector) {
        this.profileVector = profileVector;
    }
    @DynamoDBAttribute(attributeName = "profilePictureId")
    public String getProfilePictureId() {
        return profilePictureId;
    }

    public void setProfilePictureId(String profilePictureId) {
        this.profilePictureId = profilePictureId;
    }


}
