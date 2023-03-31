package activity.results.get;

import models.EventsModel;

public class GetEventsResult {
    private final EventsModel Events;

    private GetEventsResult(EventsModel Events) {
        this.Events = Events;
    }

    public EventsModel getEvents() {
        return Events;
    }

    @Override
    public String toString() {
        return "GetProfileResult{" +
                "Profile=" + Events +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private EventsModel Events;

        public Builder withEvents(EventsModel Events) {
            this.Events = Events;
            return this;
        }

        public GetEventsResult build() {
            return new GetEventsResult(Events);
        }
    }
}
