package lt.edukuokis.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Named;
import lt.edukuokis.entities.Category;
import lt.edukuokis.entities.Event;

/**
 *
 * @author Aurimas Dainius
 */
@Named
@Stateless
public class CreateEventBean {

    private Event event;
    private String eventName;
    private String category;

    List<Category> categories;
    
    @PostConstruct
    private void init() {
        categories = new ArrayList<>();
        
        
    }
    
    public void createEvent() {

    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
