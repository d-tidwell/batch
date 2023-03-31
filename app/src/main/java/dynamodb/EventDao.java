package dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamodb.model.Events;
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
    

    public Events getEvents(String id){
        Events event = this.dynamoDBMapper.load(Events.class, id);
        if (event== null) {
            metricsPublisher.addCount(MetricsConstants.GETEEVENTS_EVENTSNOTFOUND_COUNT, 1);
            throw new EventsNotFoundException("Could not find Events with id " + id);
        }
        metricsPublisher.addCount(MetricsConstants.GETEEVENTS_EVENTSNOTFOUND_COUNT, 0);
        return event;
    }

    // save and update function
    public Events saveEvent(){
        Events event = new Events();
        this.dynamoDBMapper.save(event);
        return event;
    }

    public void deleteEvent(String id, String authId){
        //confirm authorization to delete version just show perm or hibernate
        Events deleteEvent = new Events();
        this.dynamoDBMapper.delete(deleteEvent);
    }
}