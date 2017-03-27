package edu.wctc.jpa.web.servlet.basics.ejb;

import edu.wctc.jpa.web.servlet.basics.model.Manufacturer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * This class is an imlementation of the AbstractFacade, typed to handle
 * Manufacturer entities. It is also a Stateless EJB Session Bean. EJBs have
 * many sophisticated features, but for this demo it's the ability to
 * auto handle JTA transactions (the EJB container does this).
 * 
 * @author jlombardo
 */
@Stateless
public class ManufacturerFacade extends AbstractFacade<Manufacturer> {
    @PersistenceContext(unitName = "sample_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ManufacturerFacade() {
        super(Manufacturer.class);
    }
    
    public List<Manufacturer> findByState(String state) {
        
        String jpql = "select m from Manufacturer m where m.state = :state"; //?1 (other binding parameter)
        
        TypedQuery<Manufacturer> q =
                getEntityManager().createQuery(jpql, Manufacturer.class);
        q.setParameter("state", state); 
        // q.setParameter(1, state);
        //q.setMaxResults(10);
        return q.getResultList();
    }
    
    public int deleteByID (String id){
        String jpql = "select from Manufacturer m where m.manufacturerId = ?1"; // :id
        
        Query q =
                getEntityManager().createQuery(jpql);
        q.setParameter(1, new Integer(id));
      //q.setParameter("id", new Integer(id));
        return q.executeUpdate();
        
    }
    
    public int toUpperByID(String id) {
        String jpql = "Update Manufacturer "
                + "Set manufacturerId = Upper(manufacturerId) where manufacturerId = :id";
        Query q = getEntityManager().createQuery(jpql);
        q.setParameter("manufacturerId", new Integer(id));
        
        return q.executeUpdate();
    }
    
}
