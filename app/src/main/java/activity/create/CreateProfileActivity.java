package activity.create;


import activity.requests.create.CreateProfileRequest;
import activity.results.create.CreateProfileResult;
import converters.ModelConverter;
import dynamodb.ProfileDao;
import dynamodb.model.Profile;
import exceptions.InvalidAttributeException;
import models.ProfileModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.IdGenerator;

import javax.inject.Inject;



public class CreateProfileActivity {
    private final Logger log = LogManager.getLogger();
    private final ProfileDao profileDao;

    /**
     * Instantiates a new CreateProfileActivity object.
     *
     * @param profileDao ProfileDao to access the Profiles table.
     */
    @Inject
    public CreateProfileActivity(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    public CreateProfileResult handleRequest(final CreateProfileRequest createProfileRequest)
            throws InvalidAttributeException {
        log.info("Received CreateProfileRequest {}", createProfileRequest);

        String newId = IdGenerator.idGenerator(createProfileRequest.getUserId(), createProfileRequest.getUsername());

        //handle creating a profile sparse
        Profile profile = profileDao.saveProfile(createProfileRequest.getIsNew(), newId, createProfileRequest.getUsername(),
                createProfileRequest.getAge(), createProfileRequest.getGender(), createProfileRequest.getLocation(),
                createProfileRequest.getSeeking(), createProfileRequest.getDatingPreferences());

        ProfileModel profileModel = new ModelConverter().toProfileModel(profile);

        return CreateProfileResult.builder()
                .withProfile(profileModel)
                .build();

    }
}
