package dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dynamodb.model.Events;
import exceptions.EventsNotFoundException;
import metrics.MetricsConstants;
import metrics.MetricsPublisher;
import models.EventsModel;

import java.util.UUID;

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

    public void deleteEvent(String id){
        //confirm authorization to delete version just show perm or hibernate
        Events deleteEvent = new Events();
        deleteEvent.setEventId(id);
        this.dynamoDBMapper.delete(deleteEvent);
    }

    public Events saveEvent(boolean isNew, String newId, String name, String location, String date, String startTime,
                            String endTime, String description, String category, String price_range) {
        Events newEvent = new Events();
        newEvent.setEventId(newId);
        newEvent.setDate(date);

        if (isNew) {
            newEvent.setName(name);
            newEvent.setLocation(location);
            newEvent.setStartTime(startTime);
            newEvent.setEndTime(endTime);
            newEvent.setDescription(description);
            newEvent.setCategory(category);
            newEvent.setPrice_range(price_range);
        } else {
            if (name != null) {
                newEvent.setName(name);
            }
            if (location != null) {
                newEvent.setLocation(location);
            }
            if (startTime != null) {
                newEvent.setStartTime(startTime);
            }
            if (endTime != null) {
                newEvent.setEndTime(endTime);
            }
            if (description != null) {
                newEvent.setDescription(description);
            }
            if (category != null) {
                newEvent.setCategory(category);
            }
            if (price_range != null) {
                newEvent.setPrice_range(price_range);
            }
        }
        this.dynamoDBMapper.save(newEvent);
        return newEvent;
    }
}
