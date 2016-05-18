package lt.edukuokis.beans;

import javax.ejb.Stateless;
import javax.inject.Named;
import lt.edukuokis.entities.Event;

/**
 *
 * @author Aurimas Dainius
 */
@Named
@Stateless
public class RegisterToEvent {

    private Event event;
    private String message;

    public String register() {

        message = "Jūs buvote sėkmingai užregistruotas į renginį '" + event.getTitle() + "'";

        return null;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
