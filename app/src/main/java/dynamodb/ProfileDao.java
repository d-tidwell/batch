package dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamodb.model.Calendar;
import dynamodb.model.Events;
import dynamodb.model.Profile;
import exceptions.ProfileNotFoundException;
import metrics.MetricsConstants;
import metrics.MetricsPublisher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ProfileDao {
    private final DynamoDBMapper dynamoDBMapper;
    private final MetricsPublisher metricsPublisher;

    public ProfileDao(DynamoDBMapper dynamoDBMapper, MetricsPublisher metricsPublisher) {
        this.dynamoDBMapper = dynamoDBMapper;
        this.metricsPublisher = metricsPublisher;
    }

    public Profile getProfile(String id){
        Profile profile = this.dynamoDBMapper.load(Profile.class, id);
        if (profile == null) {
            metricsPublisher.addCount(MetricsConstants.GETPROFILE_PROFILENOTFOUND_COUNT, 1);
            throw new ProfileNotFoundException("Could not find profile with id " + id);
        }
        metricsPublisher.addCount(MetricsConstants.GETPROFILE_PROFILENOTFOUND_COUNT, 0);
        return profile;
    }

    public void deleteProfile(String id, String authId){
        //confirm authorization to delete version just show perm or hibernate
        if (authId.equals("420691111Random")) {
            Profile deleteProfile = new Profile();
            deleteProfile.setProfileId(id);
            this.dynamoDBMapper.delete(deleteProfile);
        }
    }

    public Profile saveProfile(boolean isNew, String profileId, String username, Integer age, String gender, String location,
                               List<String> seeking, List<String> datingPreferences) {
        Profile newProfile = new Profile();
        newProfile.setProfileId(profileId);
        newProfile.setUsername(username);
        if ( isNew ) {
            //create a new calendar
            Calendar calendar = new Calendar();
            calendar.setProfileId(profileId);
            calendar.setCalendar(new HashMap<>());
            this.dynamoDBMapper.save(calendar);

            newProfile.setAge(age);
            newProfile.setGender(gender);
            newProfile.setLocation(location);
            newProfile.setSeeking(new ArrayList<>(seeking));
            newProfile.setDating_preferences(new ArrayList<>(datingPreferences));
        } else {
            if(age != null){
                newProfile.setAge(age);
            }
            if(!gender.isEmpty()){
                newProfile.setGender(gender);
            }
            if(!location.isEmpty()){
                newProfile.setLocation(location);
            }
            if(seeking.isEmpty()){
                newProfile.setSeeking(new ArrayList<>());
            } else {
                newProfile.setSeeking(new ArrayList<>(seeking));
            }
            if(datingPreferences.isEmpty()){
                newProfile.setDating_preferences(new ArrayList<>());
            } else {
                newProfile.setDating_preferences(new ArrayList<>(datingPreferences));
            }
        }
        this.dynamoDBMapper.save(newProfile);
        return newProfile;
    }

    public Calendar getCalendar(String requestId) {
        Calendar calendar = this.dynamoDBMapper.load(Calendar.class, requestId);
        return calendar;
    }

    //needs a route in order to work as endpoint
    public Calendar addEventToCalendar(Events event, String profileId){
        Calendar calendar = getCalendar(profileId);
        Map<String, String> events = calendar.getCalendar();
        events.put(event.getDate(), event.getEventId());
        this.dynamoDBMapper.save(calendar);
        return calendar;
    }
}
