package activity.requests.update;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.List;

@JsonDeserialize(builder = UpdateProfileRequest.Builder.class)
public class UpdateProfileRequest {
    private boolean isNew;
    private String userId;
    private String username;
    private Integer age;
    private String gender;
    private List<String> seeking;
    private List<String> datingPreferences;
    private String location;

    public UpdateProfileRequest(boolean isNew, String userId, String username, Integer age, String gender,
                                List<String> seeking, List<String> datingPreferences, String location) {
        this.isNew = isNew;
        this.userId = userId;
        this.username = username;
        this.age = age;
        this.gender = gender;
        this.seeking = seeking;
        this.datingPreferences = datingPreferences;
        this.location = location;
    }
    public boolean getIsNew(){
        return isNew;
    }
    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public List<String> getSeeking() {
        return seeking;
    }

    public List<String> getDatingPreferences() {
        return datingPreferences;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "UpdateProfileRequest{" +
                "profileId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", seeking=" + seeking +
                ", datingPreferences=" + datingPreferences +
                ", location='" + location + '\'' +
                '}';
    }

    public static UpdateProfileRequest.Builder builder() {
        return new UpdateProfileRequest.Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {
        private boolean isNew;
        private String userId;
        private String username;
        private Integer age;
        private String gender;
        private List<String> seeking;
        private List<String> datingPreferences;
        private String location;

        public Builder withIsNew(boolean isNew){
            this.isNew = isNew;
            return this;
        }
        public Builder withId(String id){
            this.userId = id;
            return this;
        }
        public Builder withUsername(String username){
            this.username = username;
            return this;
        }
        public Builder withAge(Integer age){
            this.age = age;
            return this;
        }
        public Builder withGender(String gender){
            this.gender = gender;
            return this;
        }
        public Builder withSeeking(List<String> seeking){
            this.seeking = seeking;
            return this;
        }
        public Builder withDatingPreference(List<String> preference){
            this.datingPreferences = preference;
            return this;
        }
        public Builder withLocation(String location){
            this.location = location;
            return this;
        }

        public UpdateProfileRequest build() {
            return new UpdateProfileRequest(isNew, userId,username, age, gender, seeking, datingPreferences, location);
        }

    }
}

