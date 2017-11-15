package edu.wctc.jpa.web.servlet.basics.ejb;

import edu.wctc.jpa.web.servlet.basics.model.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * This class is an imlementation of the AbstractFacade, typed to handle
 * Product entities. It is also a Stateless EJB Session Bean. EJBs have
 * many sophisticated features, but for this demo it's the ability to
 * auto handle JTA transactions (the EJB container does this).
 * 
 * @author jlombardo
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> {
    @PersistenceContext(unitName = "sample_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }
    
     public int deleteProductByID(String id){
        try{
            String jpql = "DELETE p FROM Product p WHERE p.PRODUCT_ID = :PRODUCT_ID";
            Query query = getEntityManager().createQuery(jpql);
            query.setParameter("PRODUCT_ID", Integer.parseInt(id));
            return query.executeUpdate();    
        }catch(NumberFormatException ex){
            return -1;
        }
    }
    public List getProductsGreaterThan(double price){
        try{
            String jpql = "SELECT p FROM Product p WHERE p.PURCHASE_COST > :price";
            Query query = getEntityManager().createQuery(jpql);
            query.setParameter("price", price);
            query.setMaxResults(10);
            return query.getResultList();   
        }catch(NumberFormatException ex){
            return null;
        }
    }
    
}
