package activity.results.get;

import models.AnswerModel;

public class GetAnswerResult {
    private final AnswerModel answer;

    private GetAnswerResult(AnswerModel Answer) {
        this.answer = Answer;
    }

    public AnswerModel getEvents() {
        return answer;
    }

    @Override
    public String toString() {
        return "GetProfileResult{" +
                "Profile=" + answer +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private AnswerModel answer;

        public Builder withAnswer(AnswerModel Answer) {
            this.answer = Answer;
            return this;
        }

        public GetAnswerResult build() {
            return new GetAnswerResult(answer);
        }
    }
}
