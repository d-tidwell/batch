package activity;

import activity.requests.GetProfileRequest;
import activity.requests.GetUserRequest;
import activity.results.GetProfileResult;
import activity.results.GetUserResult;
import converters.ModelConverter;
import dynamodb.ProfileDao;
import dynamodb.UserDao;
import dynamodb.model.Profile;
import dynamodb.model.User;
import models.ProfileModel;
import models.UserModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetUserActivity {
    private final Logger log = LogManager.getLogger();
    private final UserDao userDao;
    @Inject
    public GetUserActivity(UserDao userDao){
        this.userDao = userDao;
    }

    public GetUserResult handleRequest(final GetUserRequest getUserRequest){
        log.info("Received GetProfileRequest {}", getUserRequest);
        String requestId = getUserRequest.getId();

        User user = userDao.getUser(requestId);
        UserModel userModel = new ModelConverter().toUserModel(user);
        return GetUserResult.builder()
                .withUser(userModel)
                .build();

    }
}
