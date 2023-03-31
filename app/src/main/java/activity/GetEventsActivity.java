package activity;

import activity.requests.GetEventsRequest;
import activity.requests.GetProfileRequest;
import activity.results.GetEventsResult;
import converters.ModelConverter;
import dynamodb.EventDao;
import dynamodb.ProfileDao;
import dynamodb.model.Events;
import dynamodb.model.Profile;
import models.EventsModel;
import models.ProfileModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class GetEventsActivity {
    private final Logger log = LogManager.getLogger();
    private final EventDao eventDao;
    @Inject
    public GetEventsActivity(EventDao eventsDao){
        this.eventDao = eventsDao;
    }

    public GetEventsResult handleRequest(final GetEventsRequest getEventsRequest){
        log.info("Received GetEventsRequest {}", getEventsRequest);
        String requestId = getEventsRequest.getId();

        Events events = eventDao.getEvents(requestId);
        EventsModel EventsModel = new ModelConverter().toEventsModel(events);
        return GetEventsResult.builder()
                .withEvents(EventsModel)
                .build();

    }
}
