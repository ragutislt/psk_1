package beans;

import javax.ejb.Stateless;
import lt.edukuokis.entities.Event;

/**
 *
 * @author Aurimas Dainius
 */
@Stateless
public class CreateEventBean {
    private Event event;
    private String eventName;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    
    public void createEvent() {
        
    }
    
    
}
