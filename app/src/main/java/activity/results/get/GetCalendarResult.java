package activity.results.get;

import dynamodb.model.Calendar;
import models.AnswerModel;
import models.CalendarModel;
import models.ProfileModel;

public class GetCalendarResult {
    private final CalendarModel calendar;

    private GetCalendarResult(CalendarModel calendar) {
        this.calendar = calendar;
    }

    public CalendarModel getCalender() {
        return calendar;
    }

    @Override
    public String toString() {
        return "GetProfileResult{" +
                "Profile=" + calendar +
                '}';
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

        public GetCalendarResult build() {
            return new GetCalendarResult(calendar);
        }
    }
}
