package activity;

import activity.requests.GetEventsRequest;
import activity.requests.GetQuestionRequest;
import activity.results.GetEventsResult;
import activity.results.GetQuestionResult;
import converters.ModelConverter;
import dynamodb.EventDao;
import dynamodb.QuestionaireDao;
import dynamodb.model.Events;
import dynamodb.model.Question;
import models.EventsModel;
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
