package car.tp4.bean;

import car.tp4.dataBase.Book;
import car.tp4.dataBase.Commande;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


/**
 * CartBeanService Class implements interface CartBeanService
 */
@Stateful
public class CartBeanService implements  CartBeanServiceItf{

    @PersistenceContext(unitName = "commande-pu")
    private EntityManager entityManager;
    String sessionID;


    @Override
    public void init(String sessionID) {
        if(!sessionID.equals(sessionID)) {
            this.sessionID = sessionID;
        }
    }

    /**
     * Add a commande to cart
     * @param commande a Book
     */
    @Override
    public void addCommande(Commande commande) {
        entityManager.persist(commande);
    }


    @Override
    public List<Commande> getAllCommades() {
        Query query = entityManager.createQuery("SELECT m from Commande as m");
        return query.getResultList();
    }
}
