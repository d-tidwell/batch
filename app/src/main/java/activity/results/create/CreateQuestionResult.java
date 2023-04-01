package activity.results.create;

import models.EventsModel;
import models.QuestionModel;

public class CreateQuestionResult {
    private final QuestionModel Question;

    private CreateQuestionResult(QuestionModel Question){
        this.Question = Question;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private QuestionModel Question;

        public Builder withQuestion(QuestionModel Question) {
            this.Question = Question;
            return this;
        }

        public CreateQuestionResult build() {
            return new CreateQuestionResult(Question);
        }
    }
}
