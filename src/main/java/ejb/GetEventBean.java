/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Named
//@RequestScoped // @SessionScoped
@Stateless
public class FirstBean {
    @PersistenceContext
    private EntityManager em;
    
    public String ShowEvents() {
        Query all = em.createQuery("SELECT e FROM Event e");
        List results = all.getResultList();
        return results.toString();
        //return "dqdqdqd";
    }
    
}
