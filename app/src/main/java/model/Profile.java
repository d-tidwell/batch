package model;

import java.util.List;
import java.util.Objects;

public class Profile {

    public String profileId;
    private String username;
    private Integer age;
    private String gender;
    private List<String> seeking;
    private List<String> sexual_preference;
    private String location;
    private Calendar calendar;
    private Questionaire questionaire;
    private List<Integer> profileVector;

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getSeeking() {
        return seeking;
    }

    public void setSeeking(List<String> seeking) {
        this.seeking = seeking;
    }

    public List<String> getSexual_preference() {
        return sexual_preference;
    }

    public void setSexual_preference(List<String> sexual_preference) {
        this.sexual_preference = sexual_preference;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return getProfileId().equals(profile.getProfileId()) && getUsername().equals(profile.getUsername()) && getAge().equals(profile.getAge()) && getGender().equals(profile.getGender()) && getSeeking().equals(profile.getSeeking()) && getSexual_preference().equals(profile.getSexual_preference()) && getLocation().equals(profile.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProfileId(), getUsername(), getAge(), getGender(), getSeeking(), getSexual_preference(), getLocation());
    }
}