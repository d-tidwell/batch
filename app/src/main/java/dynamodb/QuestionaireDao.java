package dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import metrics.MetricsPublisher;
import dynamodb.model.Answer;
import dynamodb.model.Question;

public class QuestionaireDao {

    private final DynamoDBMapper dynamoDBMapper;
    private final MetricsPublisher metricsPublisher;

    public QuestionaireDao(DynamoDBMapper dynamoDBMapper, MetricsPublisher metricsPublisher) {
        this.dynamoDBMapper = dynamoDBMapper;
        this.metricsPublisher = metricsPublisher;
    }

    public Question getQuestion(String id){
        Question question = this.dynamoDBMapper.load(Question.class, id);
        return question;
    }
    public Answer getAnswer(String id){
        Answer answer = this.dynamoDBMapper.load(Answer.class, id);
        return answer;
    }

    public Question saveQuestion(String questionCopy) {
        Question question = new Question();
        this.dynamoDBMapper.save(question);
        return question;
    }

    public Answer saveAnswer(String answerCopy, String profileId, boolean showHide) {
        Answer answer = new Answer();
        this.dynamoDBMapper.save(answer);
        return answer;
    }
}
