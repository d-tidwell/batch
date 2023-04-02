package activity.create;

import activity.requests.create.CreateEventsRequest;
import activity.results.create.CreateEventsResult;
import converters.ModelConverter;
import dynamodb.EventDao;
import dynamodb.model.Events;
import exceptions.InvalidAttributeException;
import models.EventsModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.IdGenerator;

import javax.inject.Inject;

public class CreateEventsActivity {
    private final Logger log = LogManager.getLogger();
    private final EventDao eventsDao;

    /**
     * Instantiates a new CreateEventsActivity object.
     *
     * @param eventsDao EventsDao to access the Events table.
     */
    @Inject
    public CreateEventsActivity(EventDao eventsDao) {
        this.eventsDao = eventsDao;
    }

    public CreateEventsResult handleRequest(final CreateEventsRequest createEventsRequest)
            throws InvalidAttributeException {
        log.info("Received CreateEventsRequest {}", createEventsRequest);

        String newId = IdGenerator.idGenerator(createEventsRequest.getName(), createEventsRequest.getDate());

        Events Events = eventsDao.saveEvent(createEventsRequest.getIsNew(), newId, createEventsRequest.getName(),
                                            createEventsRequest.getLocation(), createEventsRequest.getDate(),
                                            createEventsRequest.getStartTime(), createEventsRequest.getEndTime(),
                                            createEventsRequest.getDescription(), createEventsRequest.getCategory(),
                                            createEventsRequest.getPrice_range());

        EventsModel EventsModel = new ModelConverter().toEventsModel(Events);

        return CreateEventsResult.builder()
                .withEvents(EventsModel)
                .build();

    }
}
