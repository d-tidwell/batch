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
import utils.IdGenerator;

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
        String newId = IdGenerator.idGenerator(createUserRequest.getLastName(), createUserRequest.getPhoneNumber());
        //handle creating a User sparse
        User User = UserDao.saveUser(createUserRequest.getNewUser(), newId, createUserRequest.getFirstName(),
                                     createUserRequest.getLastName(), createUserRequest.getUsername(),
                                     createUserRequest.getPhoneNumber());

        UserModel UserModel = new ModelConverter().toUserModel(User);

        return CreateUserResult.builder()
                .withUser(UserModel)
                .build();

    }
}
