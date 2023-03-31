package models;

public class AnswerModel {
    public String profileId;
    public String questionId;
    public String answer;
    public Boolean showHide;


    public static AnswerModel.Builder builder() {
        return new AnswerModel.Builder();
    }

    public static class Builder {
        public String id;

        public AnswerModel.Builder withId(String id) {
            this.id = id;
            return this;
        }

        public AnswerModel build() {
            return new AnswerModel();
        }
    }
}
