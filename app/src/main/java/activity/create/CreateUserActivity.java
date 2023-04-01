package activity.create;

import activity.requests.create.CreateUserRequest;
import activity.results.create.CreateUserResult;
import converters.ModelConverter;
import dynamodb.UserDao;
import dynamodb.model.User;
import exceptions.InvalidAttributeException;
import models.UserModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class CreateUserActivity {
    private final Logger log = LogManager.getLogger();
    private final dynamodb.UserDao UserDao;

    /**
     * Instantiates a new CreateUserActivity object.
     *
     * @param UserDao UserDao to access the Users table.
     */
    @Inject
    public CreateUserActivity(UserDao UserDao) {
        this.UserDao = UserDao;
    }

    public CreateUserResult handleRequest(final CreateUserRequest createUserRequest)
            throws InvalidAttributeException {
        log.info("Received CreateUserRequest {}", createUserRequest);

        //handle creating a User sparse
        User User = UserDao.saveUser(createUserRequest);

        UserModel UserModel = new ModelConverter().toUserModel(User);

        return CreateUserResult.builder()
                .withUser(UserModel)
                .build();

    }
}
