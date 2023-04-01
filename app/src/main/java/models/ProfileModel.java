package models;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ProfileModel {

    public String profileId;
    private String username;
    private Integer age;
    private String gender;
    private List<String> seeking;
    private List<String> dating_preferences;
    private String location;
    private List<String> friendsList;
    private List<Integer> profileVector;
    private String profilePictureId;
    private CalendarModel calendar;
    private Map<String, String> pictures;
    private LinkedList<List<String>> batchHistory;




    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        public ProfileModel build() {
            return new ProfileModel();
        }
    }
}