package dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamodb.model.Answer;
import dynamodb.model.Question;
import metrics.MetricsPublisher;

public class QuestionaireDao {
    //manages the Q&A of a profile and for the app
    private final DynamoDBMapper dynamoDBMapper;
    private final MetricsPublisher metricsPublisher;

    public QuestionaireDao(DynamoDBMapper dynamoDBMapper, MetricsPublisher metricsPublisher) {
        this.dynamoDBMapper = dynamoDBMapper;
        this.metricsPublisher = metricsPublisher;
    }

    public Question getQuestions(String id) {
        Question question = this.dynamoDBMapper.load(Question.class, id);
        return question;
    }

    public Answer getAnswer(String id) {
        Answer answer = this.dynamoDBMapper.load(Answer.class, id);
        return answer;
    }

    public Question saveQuestion(String newId, String questionCopy) {
        Question question = new Question();
        question.setQuestionId(newId);
        question.setQuestion(questionCopy);
        this.dynamoDBMapper.save(question);
        return question;
    }

    public Answer saveAnswer(String profileId, String questionId, String answer, Boolean showHide) {
        Answer newAnswer = new Answer();
        newAnswer.setProfileId(profileId);
        newAnswer.setQuestionId(questionId);
        newAnswer.setAnswer(answer);
        newAnswer.setShowHide(showHide);
        this.dynamoDBMapper.save(newAnswer);
        return newAnswer;
    }
}
