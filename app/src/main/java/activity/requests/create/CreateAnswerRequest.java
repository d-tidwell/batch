package activity.requests.create;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = CreateAnswerRequest.Builder.class)
public class CreateAnswerRequest {
    public String profileId;
    public String questionId;
    public String answer;
    public Boolean showHide;

    public CreateAnswerRequest(String profileId, String questionId, String answer, Boolean showHide) {
        this.profileId = profileId;
        this.questionId = questionId;
        this.answer = answer;
        this.showHide = showHide;
    }

    public String getProfileId() {
        return profileId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public Boolean getShowHide() {
        return showHide;
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {
        public String profileId;
        public String questionId;
        public String answer;
        public Boolean showHide;

        public Builder withId(String id){
            this.profileId = id;
            return this;
        }
        public Builder withQuestionId(String questionId){
            this.questionId = questionId;
            return this;
        }
        public Builder withAnswer(String answer){
            this.answer =answer;
            return this;
        }
        public Builder withShowHide(boolean showHide){
            this.showHide = showHide;
            return this;
        }

        public CreateAnswerRequest build() {
            return new CreateAnswerRequest(profileId, questionId, answer, showHide);
        }

    }
}
