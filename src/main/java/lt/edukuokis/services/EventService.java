package lt.edukuokis.services;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import lt.edukuokis.entities.Category;
import lt.edukuokis.entities.Customer;
import lt.edukuokis.entities.Event;

/**
 *
 * @author Aurimas Dainius
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class EventService {

    @PersistenceContext
    private EntityManager em;

    @Resource
    private SessionContext sessionContext;

    //@Transactional
    public int addCustomerToEvent(Event event, Customer customer) {

        System.out.println("Event: title - " + event.getTitle() + ", id - "
                + event.getId() + ", category - " + event.getCategory().getName());

        System.out.println("Customer: email - " + customer.getEmail() + ", id - "
                + customer.getId() + ", first name - " + customer.getFirstName());
        //EntityTransaction tr = em.getTransaction();

        UserTransaction userTransaction = sessionContext.getUserTransaction();

        try {
            //tr.begin();
            userTransaction.begin();

            System.out.println("AAA   method started");

            event.addCustomer(customer);

            System.out.println("AAA   event persisted");

            System.out.println("AAA   events and customers updated");

            System.out.println("AAA   merged");
            em.merge(event);

            userTransaction.commit();
            System.out.println("AAA   flushed");
        } catch (Exception ex) {
            try {

                System.out.println("createEvent() exception, rollbacking: " + ex);

                userTransaction.rollback();

                System.out.println("createEvent() exception, rollback successful: " + ex);
            } catch (IllegalStateException | SecurityException | SystemException ex1) {
                System.out.println("createEvent() exception: " + ex);
                Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex1);
            }

            return -1;
        } finally {
            System.out.println("AAA   cleared");
            em.clear();
        }

        return 1;
    }

    public int createEvent(Event event) {

        UserTransaction userTransaction = sessionContext.getUserTransaction();

        try {
            userTransaction.begin();
            em.persist(event);
            userTransaction.commit();
        } catch (Exception ex) {
            try {
                userTransaction.rollback();
            } catch (IllegalStateException | SecurityException | SystemException ex1) {
                System.out.println("createEvent() rollback exception: " + ex);
                Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex1);
            }
            System.out.println("createEvent() exception: " + ex);
            return -1;
        } finally {
            em.clear();
        }

        return 1;
    }
}
