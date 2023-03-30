package dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import metrics.MetricsPublisher;
import models.AnswerModel;
import models.QuestionModel;

public class QuestionaireDao {

    private final DynamoDBMapper dynamoDBMapper;
    private final MetricsPublisher metricsPublisher;

    public QuestionaireDao(DynamoDBMapper dynamoDBMapper, MetricsPublisher metricsPublisher) {
        this.dynamoDBMapper = dynamoDBMapper;
        this.metricsPublisher = metricsPublisher;
    }

    public QuestionModel getQuestion(String id){
        QuestionModel question = this.dynamoDBMapper.load(QuestionModel.class, id);
        return question;
    }
    public AnswerModel getAnswer(String id){
        AnswerModel answer = this.dynamoDBMapper.load(AnswerModel.class, id);
        return answer;
    }

    public QuestionModel saveQuestion(String questionCopy) {
        QuestionModel question = new QuestionModel();
        this.dynamoDBMapper.save(question);
        return question;
    }

    public AnswerModel saveAnswer(String answerCopy, String profileId, boolean showHide) {
        AnswerModel answer = new AnswerModel();
        this.dynamoDBMapper.save(answer);
        return answer;
    }
}
