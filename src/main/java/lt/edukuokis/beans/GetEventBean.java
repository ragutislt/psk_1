package lt.edukuokis.beans;

import lt.edukuokis.entities.*;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@ManagedBean
//@RequestScoped // @SessionScoped
@Stateless
public class GetEventBean {
    @PersistenceContext
    private EntityManager em;
    
    private List<Event> events = new ArrayList<>();
    
    @Inject
    private CreateEventBean createEventBean;

    public List<Event> getEvents() {
        Query allEvents = em.createNamedQuery("Event.findAll");
        events = allEvents.getResultList();
        return events;
    }
    
    public String ShowEvents() {
        Query all = em.createQuery("SELECT e FROM Event e");
        List results = all.getResultList();
        return createEventBean.getClass().getName();
        //return results.toString();
        //return "dqdqdqd";
    }
    
}
