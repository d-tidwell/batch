package models;

public class QuestionModel {

    public String questionId;
    public String question;


    public static QuestionModel.Builder builder() {
        return new QuestionModel.Builder();
    }

    public static class Builder {
        public String id;

        public QuestionModel.Builder withId(String id) {
            this.id = id;
            return this;
        }

        public QuestionModel build() {
            return new QuestionModel();
        }
    }
}
