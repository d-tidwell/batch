package activity.requests.create;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = CreateEventsRequest.Builder.class)
public class CreateEventsRequest {
    boolean isNew;
    private String eventId;
    private String name;
    private String location;
    private String date;
    private String startTime;
    private String endTime;
    private String description;
    private String category;
    private String price_range;

    public CreateEventsRequest(boolean isNew, String eventId, String name, String location, String date, String startTime, String endTime,
                               String description, String category, String price_range) {
        this.isNew = isNew;
        this.eventId = eventId;
        this.name = name;
        this.location = location;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.category = category;
        this.price_range = price_range;
    }

    public boolean getIsNew(){
        return isNew;
    }
    public String getEventId() {
        return eventId;
    }

    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getPrice_range() {
        return price_range;
    }

    @Override
    public String toString() {
        return "CreateEventsRequest{" +
                "eventId='" + eventId + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", price_range='" + price_range + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {
        private boolean isNew;
        private String eventId;
        private String name;
        private String location;
        private String date;
        private String startTime;
        private String endTime;
        private String description;
        private String category;
        private String price_range;

        public Builder withIsNew(boolean isNew){
            this.isNew = isNew;
            return this;
        }
        public Builder withId(String id){
            this.eventId = id;
            return this;
        }
        public Builder withName(String name){
            this.name = name;
            return this;
        }
        public Builder withLocation(String location){
            this.location = location;
            return this;
        }
        public Builder withDate(String date){
            this.date = date;
            return this;
        }

        public Builder withStartTime(String startTime){
            this.startTime = startTime;
            return this;
        }

        public Builder withEndTime(String endTime){
            this.endTime = endTime;
            return this;
        }

        public Builder withDescription(String description){
            this.description = description;
            return this;
        }

        public Builder withCategory(String category){
            this.category = category;
            return this;
        }

        public Builder withPriceRange(String price_range){
            this.price_range = price_range;
            return this;
        }

        public CreateEventsRequest build() {
            return new CreateEventsRequest(eventId,name, location, date, startTime,
                    endTime, description, category, price_range);
        }

    }
}
