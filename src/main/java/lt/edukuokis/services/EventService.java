package lt.edukuokis.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import lt.edukuokis.entities.Customer;
import lt.edukuokis.entities.Event;

/**
 *
 * @author Aurimas Dainius
 */
@Stateless
public class EventService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public int addCustomerToEvent(Event event, Customer customer) {

        try {
            System.out.println("AAA   method started");

            event.getCustomerList().add(customer);
            customer.getEventList().add(event);

            System.out.println("AAA   events and customers updated");
            em.merge(event);
            System.out.println("AAA   merged");
            //em.merge(customer);
            em.flush();
            System.out.println("AAA   flushed");
        } catch (PersistenceException e) {
            System.out.println("AAA   cleared");
            em.clear();
            return -1;
        }

        return 1;
    }
}
