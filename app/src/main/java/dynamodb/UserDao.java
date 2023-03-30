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

    // save and update function
    public User saveUser(){
        User user = new User();
        this.dynamoDBMapper.save(user);
        return user;
    }

    public void deleteUser(String id, String authId){
        //confirm authorization to delete version just show perm or hibernate
        User deleteUser = new User();
        this.dynamoDBMapper.delete(deleteUser);
    }
}
