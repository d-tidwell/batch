package converters;

import dynamodb.model.Events;
import dynamodb.model.Profile;
import dynamodb.model.User;
import models.EventsModel;
import models.ProfileModel;
import models.UserModel;

public class ModelConverter {

    public ProfileModel toProfileModel(Profile profile){
        return new ProfileModel().builder()
                .build();
    }


    public UserModel toUserModel(User user) {
        return new UserModel().builder()
                .build();
    }

    public EventsModel toEventsModel(Events events) {
        return new EventsModel.builder()
                .build();
    }
}
