package activity.update;

import converters.ModelConverter;
import dynamodb.ProfileDao;
import dynamodb.model.Calendar;
import exceptions.CalendarNotFoundException;
import exceptions.InvalidAttributeException;
import lambda.update.AddEventToCalendarLambda;
import models.CalendarModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class AddEventToCalendarActivity {
    private final Logger log = LogManager.getLogger();
    private final ProfileDao profileDao;


    /**
     * Instantiates a new AddEventToCalendarActivity object.
     *
     * @param profileDao ProfileDao to access the Profile table.
     */
    @Inject
    public AddEventToCalendarActivity(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    public AddEventToCalendarResult handleRequest(final AddEventToCalendarRequest addEventToCalendarRequest)
            throws CalendarNotFoundException, InvalidAttributeException {
        log.info("Received AddEventToCalendarRequset {}", addEventToCalendarRequest);
        Calendar validCalendar = profileDao.getCalendar(addEventToCalendarRequest.getId());
        Calendar addedEventCalendar = profileDao.addEventToCalendar(addEventToCalendarRequest.getEventId(),
                                        addEventToCalendarRequest.getCalendarId());
        CalendarModel calendarModel = new ModelConverter().toCalendarModel(addedEventCalendar);

        return AddEventToCalendarResult.builder()
                .withCalendarId(calendarModel)
                .build();
    }
}
