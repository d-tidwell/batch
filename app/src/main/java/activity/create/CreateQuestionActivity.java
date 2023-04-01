package activity.create;

import activity.requests.create.CreateQuestionRequest;
import activity.results.create.CreateQuestionResult;
import converters.ModelConverter;
import dynamodb.QuestionaireDao;
import dynamodb.model.Question;
import exceptions.InvalidAttributeException;
import models.QuestionModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class CreateQuestionActivity {
    private final Logger log = LogManager.getLogger();
    private final QuestionaireDao questionDao;

    /**
     * Instantiates a new CreateQuestionActivity object.
     *
     * @param QuestionDao QuestionDao to access the Questions table.
     */
    @Inject
    public CreateQuestionActivity(QuestionaireDao questionDao) {
        this.questionDao = questionDao;
    }

    public CreateQuestionResult handleRequest(final CreateQuestionRequest createQuestionRequest)
            throws InvalidAttributeException {
        log.info("Received CreateQuestionRequest {}", createQuestionRequest);

        //handle creating a Question sparse
        Question Question = questionDao.saveQuestion();

        QuestionModel QuestionModel = new ModelConverter().toQuestionModel(question);

        return CreateQuestionResult.builder()
                .withQuestion(questionModel)
                .build();

    }
}
