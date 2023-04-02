package dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamodb.model.User;
import exceptions.UserNotFoundException;
import metrics.MetricsConstants;
import metrics.MetricsPublisher;
import models.UserModel;

public class UserDao {
    private final DynamoDBMapper dynamoDBMapper;
    private final MetricsPublisher metricsPublisher;

    public UserDao(DynamoDBMapper dynamoDBMapper, MetricsPublisher metricsPublisher) {
        this.dynamoDBMapper = dynamoDBMapper;
        this.metricsPublisher = metricsPublisher;
    }

    public User getUser(String id){
        User user = this.dynamoDBMapper.load(User.class, id);
        if (user== null) {
            metricsPublisher.addCount(MetricsConstants.GETUSER_USERNOTFOUND_COUNT, 1);
            throw new UserNotFoundException("Could not find Userwith id " + id);
        }
        metricsPublisher.addCount(MetricsConstants.GETUSER_USERNOTFOUND_COUNT, 0);
        return user;
    }

    public void deleteUser(String id, String authId){
        //confirm authorization to delete version just show perm or hibernate
        User deleteUser = new User();
        this.dynamoDBMapper.delete(deleteUser);
    }

    public User saveUser(boolean newUser, String newId, String firstName, String lastName, String username, String phoneNumber) {

        User newUsers = new User();
        newUsers.setId(newId);
        newUsers.setLastName(lastName);

        if (newUser){
            newUsers.setFirstName(firstName);
            newUsers.setPhoneNumber(phoneNumber);

        } else {
            if (username != null){
                newUsers.setUsername(username);
            }
            if (firstName != null){
                newUsers.setFirstName(firstName);
            }
            if (lastName != null){
                newUsers.setLastName(lastName);
            }
            if (phoneNumber != null){
                newUsers.setPhoneNumber(phoneNumber);
            }
        }
        this.dynamoDBMapper.save(newUsers);
        return newUsers;

    }
}
