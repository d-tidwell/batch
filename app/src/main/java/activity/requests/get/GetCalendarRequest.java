package activity.requests.get;

public class GetCalendarRequest {
    private final String id;

    public GetCalendarRequest(String id) {
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

        public GetCalendarRequest build() {
            return new GetCalendarRequest(id);
        }
    }
}
