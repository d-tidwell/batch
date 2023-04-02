package activity.requests.create;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = CreateQuestionRequest.Builder.class)
public class CreateQuestionRequest {
    public String questionId;
    public String question;

    public CreateQuestionRequest(String questionId, String question) {
        this.questionId = questionId;
        this.question = question;
    }

    public String getQuestionId() {
        return questionId;
    }

    public String getQuestion() {
        return question;
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {
        public String questionId;
        public String question;

        public Builder withId(String id){
            this.questionId = id;
            return this;
        }
        public Builder withQuestion(String question){
            this.question = question;
            return this;
        }
        public CreateQuestionRequest build() {
            return new CreateQuestionRequest(questionId, question);
        }

    }
}
