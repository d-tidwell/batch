package activity.requests;

public class GetQuestionRequest {
    private final String id;

    public GetQuestionRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public GetQuestionRequest build() {
            return new GetQuestionRequest(id);
        }
    }
}
