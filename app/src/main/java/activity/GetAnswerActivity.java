package activity;

import activity.requests.GetAnswerRequest;
import activity.requests.GetQuestionRequest;
import activity.results.GetAnswerResult;
import activity.results.GetQuestionResult;
import converters.ModelConverter;
import dynamodb.QuestionaireDao;
import dynamodb.model.Answer;
import dynamodb.model.Question;
import models.AnswerModel;
import models.QuestionModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class GetAnswerActivity {
    private final Logger log = LogManager.getLogger();
    private final QuestionaireDao questionDao;
    @Inject
    public GetAnswerActivity(QuestionaireDao questionsDao){
        this.questionDao = questionsDao;
    }

    public GetAnswerResult handleRequest(final GetAnswerRequest getAnswersRequest){
        log.info("Received GetAnswersRequest {}", getAnswersRequest);
        String requestId = getAnswersRequest.getId();

        Answer answer = questionDao.getAnswer(requestId);
        AnswerModel AnswerModel = new ModelConverter().toAnswerModel(answer);
        return GetAnswerResult.builder()
                .withAnswer(AnswerModel)
                .build();

    }
}
