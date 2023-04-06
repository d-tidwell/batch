package dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamodb.model.Calendar;
import dynamodb.model.Events;
import dynamodb.model.Profile;
import exceptions.CalendarNotFoundException;
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

    private final EventDao eventDao;

    public ProfileDao(DynamoDBMapper dynamoDBMapper, MetricsPublisher metricsPublisher, EventDao eventDao) {
        this.dynamoDBMapper = dynamoDBMapper;
        this.metricsPublisher = metricsPublisher;
        this.eventDao = eventDao;
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
        //must haves to create or update a profile minimum
        newProfile.setProfileId(profileId);
        newProfile.setUsername(username);
        //is this a new creation or an update
        if ( isNew ) {
            //create a new calendar for every new profile
            Calendar calendar = new Calendar();
            calendar.setProfileId(profileId);
            calendar.setCalendar(new HashMap<>());
            this.dynamoDBMapper.save(calendar);
            //minimum criteria for a profile generated
            newProfile.setAge(age);
            newProfile.setGender(gender);
            newProfile.setLocation(location);
            newProfile.setSeeking(new ArrayList<>(seeking));
            newProfile.setDating_preferences(new ArrayList<>(datingPreferences));
        } else {
            //if this is an update non-empty fields should be updated
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
        if (calendar == null) {
            metricsPublisher.addCount(MetricsConstants.GETCALENDAR_CALENDARNOTFOUND_COUNT, 1);
            throw new CalendarNotFoundException("Could not find profile with id " + requestId);
        }
        metricsPublisher.addCount(MetricsConstants.GETCALENDAR_CALENDARNOTFOUND_COUNT, 0);
        return calendar;
    }

    //needs a route still in order to work as endpoint
    public Calendar addEventToCalendar(String eventId, String profileId){
        Calendar calendar = getCalendar(profileId);
        Map<String, String> events = calendar.getCalendar();
        Events event = eventDao.getEvents(eventId);
        events.put(event.getDate(), event.getEventId());
        this.dynamoDBMapper.save(calendar);
        return calendar;
    }
}
