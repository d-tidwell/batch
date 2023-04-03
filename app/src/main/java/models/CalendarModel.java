package models;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class CalendarModel {

    private String calendarId;
    private Map<String, String> events;


    public static CalendarModel.Builder builder() {
        return new CalendarModel.Builder();
    }

    public static class Builder {
        public String id;

        public CalendarModel.Builder withId(String id) {
            this.id = id;
            return this;
        }

        public CalendarModel build() {
            return new CalendarModel();
        }
    }
}
