package activity.results.update;


import models.CalendarModel;

public class AddEventToCalendarResult {
    private final CalendarModel calendar;

    private AddEventToCalendarResult(CalendarModel calendar){
        this.calendar = calendar;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private CalendarModel calendar;

        public Builder withCalendar(CalendarModel calendar) {
            this.calendar = calendar;
            return this;
        }

        public AddEventToCalendarResult build() {
            return new AddEventToCalendarResult(calendar);
        }
    }
}