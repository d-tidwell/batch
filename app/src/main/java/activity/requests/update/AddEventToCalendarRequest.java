package activity.requests.update;

import activity.update.AddEventToCalendarActivity;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lambda.update.AddEventToCalendarLambda;

@JsonDeserialize(builder = AddEventToCalendarRequest.Builder.class)
public class AddEventToCalendarRequest {

    private String eventId;
    private String profileId;

    public AddEventToCalendarRequest(String eventId, String profileId) {
        this.eventId = eventId;
        this.profileId = profileId;
    }

    public String getEventId() {
        return eventId;
    }

    public String getProfileId() {
        return profileId;
    }

    @Override
    public String toString() {
        return "AddEventToCalendarRequest{" +
                "eventId='" + eventId + '\'' +
                ", profileId='" + profileId + '\'' +
                '}';
    }

    public static AddEventToCalendarRequest.Builder build(){
        return new AddEventToCalendarRequest.Builder();
    }

    @JsonPOJOBuilder
    public static class Builder {
        private String eventId;
        private String profileId;

        public Builder withEventId(String eventId){
            this.eventId = eventId;
            return this;
        }
        public Builder withCalendar(String profileId){
            this.profileId = profileId;
            return this;
        }
        public AddEventToCalendarRequest build(){
            return new AddEventToCalendarRequest(eventId, profileId);
        }
    }
}
