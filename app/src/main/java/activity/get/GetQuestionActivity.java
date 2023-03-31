package activity.get;

import activity.requests.get.GetQuestionRequest;
import activity.results.get.GetQuestionResult;
import converters.ModelConverter;
import dynamodb.QuestionaireDao;
import dynamodb.model.Question;
import models.QuestionModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class GetQuestionActivity {
    private final Logger log = LogManager.getLogger();
    private final QuestionaireDao questionDao;
    @Inject
    public GetQuestionActivity(QuestionaireDao questionsDao){
        this.questionDao = questionsDao;
    }

    public GetQuestionResult handleRequest(final GetQuestionRequest getQuestionsRequest){
        log.info("Received GetQuestionsRequest {}", getQuestionsRequest);
        String requestId = getQuestionsRequest.getId();

        Question questions = questionDao.getQuestions(requestId);
        QuestionModel QuestionsModel = new ModelConverter().toQuestionModel(questions);
        return GetQuestionResult.builder()
                .withQuestion(QuestionsModel)
                .build();

    }
}
