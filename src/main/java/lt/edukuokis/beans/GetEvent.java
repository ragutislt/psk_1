package lt.edukuokis.beans;

import lt.edukuokis.entities.*;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Named
//@RequestScoped // @SessionScoped
@Stateless
public class GetEvent {
    @PersistenceContext
    private EntityManager em;
    
    private List<Event> events = new ArrayList<>();

    public List<Event> getEvents() {
        Query allEvents = em.createNamedQuery("Event.findAll");
        events = allEvents.getResultList();
        return events;
    }
    
}
