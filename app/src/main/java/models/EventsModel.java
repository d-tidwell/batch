package models;

import java.util.Date;
import java.util.List;

public class EventsModel {
    private String eventId;
    private String location;
    private String date;
    private String startTime;
    private String endTime;
    private String description;
    private String category;
    private String price_range;


    public static EventsModel.Builder builder() {
        return new EventsModel.Builder();
    }

    public static class Builder {
        public String id;

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public EventsModel build() {
            return new EventsModel();
        }
    }
}
