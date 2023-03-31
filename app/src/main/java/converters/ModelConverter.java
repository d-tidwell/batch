package converters;

import dynamodb.model.Answer;
import dynamodb.model.Events;
import dynamodb.model.Profile;
import dynamodb.model.Question;
import dynamodb.model.User;
import models.AnswerModel;
import models.EventsModel;
import models.ProfileModel;
import models.QuestionModel;
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

    public QuestionModel toQuestionModel(Question questions) {
        return new QuestionModel.builder()
                .build();
    }

    public AnswerModel toAnswerModel(Answer answer) {
        return new AnswerModel.builder()
                .build();
    }
}
