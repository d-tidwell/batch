package activity.results.create;


import models.AnswerModel;


public class CreateAnswerResult {
    private final AnswerModel Answer;

    private CreateAnswerResult(AnswerModel Answer){
        this.Answer = Answer;
    }

    public static CreateAnswerResult.Builder builder() {
        return new CreateAnswerResult.Builder();
    }
    public static class Builder {
        private AnswerModel Answer;

        public CreateAnswerResult.Builder withAnswer(AnswerModel Answer) {
            this.Answer = Answer;
            return this;
        }

        public CreateAnswerResult build() {
            return new CreateAnswerResult(Answer);
        }
    }
}
