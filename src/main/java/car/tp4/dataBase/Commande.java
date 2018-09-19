package car.tp4.dataBase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity represents a Book
 */
@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private long id_livre;
    private int quantite;
    private String title;

    public Commande(long id_livre, int quantite) {
        this.id_livre = id_livre;
        this.quantite = quantite;
    }

    public Commande(String  title, int quantite) {
        this.title = title;
        this.quantite = quantite;
    }

    public Commande() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_livre() {
        return id_livre;
    }

    public void setId_livre(long id_livre) {
        this.id_livre = id_livre;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String  title) {
        this.title = title;
    }

    /**
     * Compare an object to the commande
     * @param o an object to compare
     * @return true if o is equals to this Book
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Commande commande = (Commande) o;

        if (id != commande.id) return false;
        if (id_livre != (commande.id_livre)) return false;
        return  (quantite != (commande.quantite));
    }

//    @Override
//    public int hashCode() {
//        int result = (int) (id ^ (id >>> 32));
//        result = 31 * result + id_livre;
//        result = 31 * result + quantite.hashCode();
//        return result;
//    }
//
//    /**
//     * Returns the Book to String
//     * @return informations of the book
//     */
//    @Override
//    public String toString() {
//        return "Book{" +
//                "author='" + author + '\'' +
//                ", title='" + title + '\'' +
//                ", year='" + year + '\'' +
//                '}';
//    }
}
