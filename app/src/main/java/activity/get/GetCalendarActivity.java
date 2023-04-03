package activity.get;

import activity.requests.get.GetAnswerRequest;
import activity.requests.get.GetCalendarRequest;
import activity.results.get.GetAnswerResult;
import activity.results.get.GetCalendarResult;
import converters.ModelConverter;
import dynamodb.ProfileDao;
import dynamodb.QuestionaireDao;
import dynamodb.model.Answer;
import dynamodb.model.Calendar;
import models.AnswerModel;
import models.CalendarModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class GetCalendarActivity {
    private final Logger log = LogManager.getLogger();
    private final ProfileDao profileDao;
    @Inject
    public GetCalendarActivity(ProfileDao profileDao){
        this.profileDao = profileDao;
    }

    public GetCalendarResult handleRequest(final GetCalendarRequest getCalendarsRequest){
        log.info("Received GetCalendarsRequest {}", getCalendarsRequest);
        String requestId = getCalendarsRequest.getId();

        Calendar calendar = profileDao.getCalendar(requestId);
        CalendarModel CalendarModel = new ModelConverter().toCalendarModel(calendar);
        return GetCalendarResult.builder()
                .withCalendar(CalendarModel)
                .build();

    }
}
