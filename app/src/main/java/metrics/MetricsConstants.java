package metrics;

/**
 * Constant values for use with metrics.
 */
public class MetricsConstants {
    public static final String GETPROFILE_PROFILENOTFOUND_COUNT = "GetProfile.ProfileNotFoundException.Count";
    public static final String UPDATEPROFILE_INVALIDATTRIBUTEVALUE_COUNT =
        "UpdateProfile.InvalidAttributeValueException.Count";
    public static final String UPDATEPROFILE_INVALIDATTRIBUTECHANGE_COUNT =
        "UpdateProfile.InvalidAttributeChangeException.Count";
    public static final String GETUSER_USERNOTFOUND_COUNT = "GetUser.UserNotFoundException.Count";
    public static final String UPDATEUSER_INVALIDATTRIBUTEVALUE_COUNT =
            "UpdateUser.InvalidAttributeValueException.Count";
    public static final String UPDATEUSER_INVALIDATTRIBUTECHANGE_COUNT =
            "UpdateUser.InvalidAttributeChangeException.Count";
    public static final String GETCALENDAR_CALENDARNOTFOUND_COUNT = "GetCalendar.CalendarNotFoundException.Count";

    public static final String GETEEVENTS_EVENTSNOTFOUND_COUNT = "GetEvents.EventsNotFoundException.Count";
    public static final String SERVICE = "Service";
    public static final String SERVICE_NAME = "BatchService";
    public static final String NAMESPACE_NAME = "DT/BatchService";

}
