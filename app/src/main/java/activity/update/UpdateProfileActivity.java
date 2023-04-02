package activity.update;

import activity.requests.update.UpdateProfileRequest;
import activity.results.update.UpdateProfileResult;
import converters.ModelConverter;
import dynamodb.ProfileDao;
import dynamodb.model.Profile;
import exceptions.InvalidAttributeException;
import exceptions.ProfileNotFoundException;
import models.ProfileModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class UpdateProfileActivity {
    private final Logger log = LogManager.getLogger();
    private final ProfileDao profileDao;


    /**
     * Instantiates a new UpdateProfileActivity object.
     *
     * @param profileDao ProfileDao to access the Profile table.
     */
    @Inject
    public UpdateProfileActivity(ProfileDao profileDao) {
        this.profileDao = profileDao;

    }
    

    public UpdateProfileResult handleRequest(final UpdateProfileRequest updateProfileRequest)
            throws ProfileNotFoundException, InvalidAttributeException {
        log.info("Received UpdateProfileRequest {}", updateProfileRequest);

        Profile validProfile = profileDao.getProfile(updateProfileRequest.getUserId());

        Profile updatedProfile = profileDao.saveProfile(
                false,validProfile.getProfileId(), updateProfileRequest.getUsername(), validProfile.getAge(),
                updateProfileRequest.getGender(), updateProfileRequest.getLocation(), updateProfileRequest.getSeeking(),
                updateProfileRequest.getDatingPreferences());

        ProfileModel ProfileModel = new ModelConverter().toProfileModel(updatedProfile);

        return UpdateProfileResult.builder()
                .withProfile(ProfileModel)
                .build();





    }
}
