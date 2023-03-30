package activity;

import activity.requests.GetProfileRequest;
import activity.results.GetProfileResult;
import converters.ModelConverter;
import dynamodb.ProfileDao;
import dynamodb.model.Profile;
import models.ProfileModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetProfileActivity {
    private final Logger log = LogManager.getLogger();
    private final ProfileDao profileDao;

    public GetProfileActivity(ProfileDao profileDao){
        this.profileDao = profileDao;
    }

    public GetProfileResult handleRequest(final GetProfileRequest getProfileRequest){
        log.info("Received GetProfileRequest {}", getProfileRequest);
        String requestId = getProfileRequest.getId();

        Profile profile = profileDao.getProfile(requestId);
        ProfileModel profileModel = new ModelConverter().toProfileModel(profile);
        return GetProfileResult.builder()
                .withProfile(profileModel)
                .build();

    }
}
