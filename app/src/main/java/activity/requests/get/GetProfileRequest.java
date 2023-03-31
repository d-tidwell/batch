package activity.requests.get;

public class GetProfileRequest {
    private final String id;

    public GetProfileRequest(String id) {
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

        public GetProfileRequest build() {
            return new GetProfileRequest(id);
        }
    }
}
