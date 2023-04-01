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
    private List<String> dating_preference;
    private String location;
    private CalendarModel calendar;
    private QuestionaireModel questionaire;
    private String profilePictureId;
    private Map<String, String> pictures;
    private LinkedList<List<String>> batchHistory;
    private List<String> friendsList;
    private List<Integer> profileVector;



    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        public ProfileModel build() {
            return new ProfileModel();
        }
    }
}