package activity.requests.create;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = CreateQuestionRequest.Builder.class)
public class CreateQuestionRequest {

    private CreateQuestionRequest(String id){

    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String id;

        public Builder withId(String id){
            this.id = id;
            return this;
        }

        public CreateQuestionRequest build() {
            return new CreateQuestionRequest(id);
        }

    }
}
