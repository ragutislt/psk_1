package lt.edukuokis.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import lt.edukuokis.entities.Category;
import lt.edukuokis.entities.Event;
import lt.edukuokis.services.CategoryService;

/**
 *
 * @author Aurimas Dainius
 */
@Named
@Stateless
public class CreateEvent {

    private Event event;
    private String eventName;
    private String category;

    List<Category> categories;

    @Inject
    private CategoryService categoryService;

    @PostConstruct
    private void init() {
        categories = categoryService.getCategories();
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
