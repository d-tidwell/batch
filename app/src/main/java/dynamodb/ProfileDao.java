package dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamodb.model.Profile;
import exceptions.ProfileNotFoundException;
import metrics.MetricsConstants;
import metrics.MetricsPublisher;

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

    // save and update function
    public Profile saveProfile(){
        Profile profile = new Profile();
        return profile;
    }

    public void deleteProfile(String id, String authId){
        //confirm authorization to delete version just show perm or hibernate
        Profile deleteProfile = new Profile();
        this.dynamoDBMapper.delete(deleteProfile);
    }
}
