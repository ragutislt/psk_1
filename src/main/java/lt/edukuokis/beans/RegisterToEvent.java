package lt.edukuokis.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lt.edukuokis.entities.Customer;
import lt.edukuokis.entities.Event;
import lt.edukuokis.services.CustomerService;
import lt.edukuokis.services.EventService;

/**
 *
 * @author Aurimas Dainius
 */
@Named
@RequestScoped
public class RegisterToEvent {

    private Event event = new Event();
    private String message;

    @Inject
    private CustomerService customerService;

    @Inject
    private EventService eventService;

    public void register() {

        Customer customer = customerService.getCurrentCustomer();

        // reiktu sugalvoti dar viena dalyka, kad su duombaze interactintu
        //customerService.registerToEvent(customer, event);
        if (eventService.addCustomerToEvent(event, customer) == -1) {
            message = "Įvyko klaida registruojantis į šį renginį!";
        } else {
            message = "Jūs buvote sėkmingai užregistruotas į renginį '" + event.getTitle() + "'";
        }
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
