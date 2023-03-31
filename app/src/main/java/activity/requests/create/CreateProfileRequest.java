package activity.requests.create;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = CreateProfileRequest.Builder.class)
public class CreateProfileRequest {

    private CreateProfileRequest(String id){

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

        public CreateProfileRequest build() {
            return new CreateProfileRequest(id);
        }

    }
}
