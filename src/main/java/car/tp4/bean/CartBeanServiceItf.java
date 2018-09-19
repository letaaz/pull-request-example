package car.tp4.bean;

import car.tp4.dataBase.Book;
import car.tp4.dataBase.Commande;

import javax.ejb.Local;
import java.util.List;

/**
 * Interface of Cart
 */
@Local
public interface CartBeanServiceItf {

    void init(String sessionID);

    void addCommande(Commande commande);

    List<Commande> getAllCommades();
}
