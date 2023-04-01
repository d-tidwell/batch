package dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamodb.model.Profile;
import exceptions.ProfileNotFoundException;
import metrics.MetricsConstants;
import metrics.MetricsPublisher;

import java.util.ArrayList;
import java.util.List;

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
        Profile deleteProfile = new Profile();
        this.dynamoDBMapper.delete(deleteProfile);
    }

    public Profile saveProfile(boolean isNew, String profileId, String username, Integer age, String gender, String location,
                               List<String> seeking, List<String> datingPreferences) {
        Profile newProfile = new Profile();
        newProfile.setProfileId(profileId);
        newProfile.setUsername(username);
        if ( isNew ) {
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
}
