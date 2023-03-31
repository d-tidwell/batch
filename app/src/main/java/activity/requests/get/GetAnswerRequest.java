package activity.requests.get;

public class GetAnswerRequest {
    private final String id;

    public GetAnswerRequest(String id) {
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

        public GetAnswerRequest build() {
            return new GetAnswerRequest(id);
        }
    }
}
