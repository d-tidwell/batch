package activity.get;

import activity.requests.get.GetEventsRequest;
import activity.results.get.GetEventsResult;
import converters.ModelConverter;
import dynamodb.EventDao;
import dynamodb.model.Events;
import models.EventsModel;
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
