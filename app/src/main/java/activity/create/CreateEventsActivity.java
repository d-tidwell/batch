package activity.create;

import activity.requests.create.CreateProfileRequest;
import activity.results.create.CreateProfileResult;
import converters.ModelConverter;
import dynamodb.ProfileDao;
import dynamodb.model.Events;
import dynamodb.model.Profile;
import exceptions.InvalidAttributeException;
import models.EventsModel;
import models.ProfileModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

public class CreateEventsActivity {
    private final Logger log = LogManager.getLogger();
    private final EventsDao eventsDao;

    /**
     * Instantiates a new CreateEventsActivity object.
     *
     * @param EventsDao EventsDao to access the Eventss table.
     */
    @Inject
    public CreateEventsActivity(EventsDao eventsDao) {
        this.eventsDao = eventsDao;
    }

    public CreateEventsResult handleRequest(final CreateEventsRequest createEventsRequest)
            throws InvalidAttributeException {
        log.info("Received CreateEventsRequest {}", createEventsRequest);

        //handle creating a Events sparse
        Events Events = eventsDao.saveEvents(createEventsRequest);

        EventsModel EventsModel = new ModelConverter().toEventsModel(Events);

        return CreateEventsResult.builder()
                .withEvents(EventsModel)
                .build();

    }
}
