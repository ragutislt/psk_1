package lt.edukuokis.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lt.edukuokis.entities.Customer;
import lt.edukuokis.entities.Event;

/**
 *
 * @author Aurimas Dainius
 */
@Stateless
public class CustomerService {

    @PersistenceContext
    private EntityManager em;

    public Customer getCurrentCustomer() {
        Customer customer = (Customer) em.createNamedQuery("Customer.findByEmail")
                .setParameter("email", "aurimas.dainius@gmail.com")
                .getSingleResult();

        return customer;
    }

    public int registerToEvent(Customer customer, Event event) {

        customer.getEventList().add(event);

        return 1;
    }
}
