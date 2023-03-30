package converters;

import dynamodb.model.Profile;
import models.ProfileModel;

public class ModelConverter {

    public ProfileModel toProfileModel(Profile profile){
        return new ProfileModel().builder()
                .build();
    }


}
