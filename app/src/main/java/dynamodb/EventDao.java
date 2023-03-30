package dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import exceptions.EventsNotFoundException;
import metrics.MetricsConstants;
import metrics.MetricsPublisher;
import models.EventsModel;

public class EventDao {
    
    private final DynamoDBMapper dynamoDBMapper;
    private final MetricsPublisher metricsPublisher;
    
    public EventDao(DynamoDBMapper dynamoDBMapper, MetricsPublisher metricsPublisher){
        this.dynamoDBMapper = dynamoDBMapper;
        this.metricsPublisher = metricsPublisher;
    }

    public EventsModel getProfile(String id){
        EventsModel event = this.dynamoDBMapper.load(EventsModel.class, id);
        if (event== null) {
            metricsPublisher.addCount(MetricsConstants.GETEEVENTS_EVENTSNOTFOUND_COUNT, 1);
            throw new EventsNotFoundException("Could not find Events with id " + id);
        }
        metricsPublisher.addCount(MetricsConstants.GETEEVENTS_EVENTSNOTFOUND_COUNT, 0);
        return event;
    }

    // save and update function
    public EventsModel saveEvent(){
        EventsModel Event = new EventsModel();
        this.dynamoDBMapper.save(Event);
        return Event;
    }

    public void deleteEvent(String id, String authId){
        //confirm authorization to delete version just show perm or hibernate
        EventsModel deleteEvent = new EventsModel();
        this.dynamoDBMapper.delete(deleteEvent);
    }
}
