package activity.results.create;

import models.EventsModel;
import models.ProfileModel;

public class CreateEventsResult {
    private final EventsModel events;

    private CreateEventsResult(EventsModel events){
        this.events = events;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private EventsModel events;

        public Builder withEvents(EventsModel events) {
            this.events = events;
            return this;
        }

        public CreateEventsResult build() {
            return new CreateEventsResult(events);
        }
    }
}
