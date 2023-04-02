package activity.create;

import activity.requests.create.CreateAnswerRequest;
import activity.requests.create.CreateQuestionRequest;
import activity.results.create.CreateAnswerResult;
import activity.results.create.CreateQuestionResult;
import converters.ModelConverter;
import dynamodb.QuestionaireDao;
import dynamodb.model.Answer;
import dynamodb.model.Question;
import exceptions.InvalidAttributeException;
import models.AnswerModel;
import models.QuestionModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.IdGenerator;

import javax.inject.Inject;

public class CreateAnswerActivity {
    private final Logger log = LogManager.getLogger();
    private final QuestionaireDao answerDao;

    /**
     * Instantiates a new CreateAnswerActivity object.
     *
     * @param answerDao AnswerDao to access the Answers table.
     */
    @Inject
    public CreateAnswerActivity(QuestionaireDao answerDao) {
        this.answerDao = answerDao;
    }

    public CreateAnswerResult handleRequest(final CreateAnswerRequest createAnswerRequest)
            throws InvalidAttributeException {
        log.info("Received CreateAnswerRequest {}", createAnswerRequest);

        //handle creating a Answer sparse
        Answer answer = answerDao.saveAnswer(createAnswerRequest.getProfileId(), createAnswerRequest.getQuestionId(),
                                             createAnswerRequest.getAnswer(), createAnswerRequest.getShowHide());

        AnswerModel answerModel = new ModelConverter().toAnswerModel(answer);

        return CreateAnswerResult.builder()
                .withAnswer(answerModel)
                .build();

    }
}
