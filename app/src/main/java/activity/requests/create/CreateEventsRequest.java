package activity.requests.create;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = CreateEventsRequest.Builder.class)
public class CreateEventsRequest {

    private CreateEventsRequest(String id){

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

        public CreateEventsRequest build() {
            return new CreateEventsRequest(id);
        }

    }
}
