package lt.edukuokis.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lt.edukuokis.entities.Category;

/**
 *
 * @author Aurimas Dainius
 */
@Stateless
public class CategoryService {

    private Category category;

    @PersistenceContext
    private EntityManager em;

    public List<Category> getCategories() {
        Query categories = em.createNamedQuery("Category.findAll");
        return categories.getResultList();
    }
}
