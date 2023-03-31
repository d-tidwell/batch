package activity.results;

import models.EventsModel;
import models.QuestionModel;

public class GetQuestionResult {
    private final QuestionModel question;

    private GetQuestionResult(QuestionModel question) {
        this.question = question;
    }

    public QuestionModel getEvents() {
        return question;
    }

    @Override
    public String toString() {
        return "GetProfileResult{" +
                "Profile=" + question +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private QuestionModel question;

        public Builder withQuestion(QuestionModel question) {
            this.question = question;
            return this;
        }

        public GetQuestionResult build() {
            return new GetQuestionResult(question);
        }
    }
}
