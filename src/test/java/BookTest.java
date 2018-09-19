import car.tp4.dataBase.Book;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.Assert.assertNotNull;

public class BookTest {
//    private static EntityManager em;
//
//    private static EntityManagerFactory emf;
//
//    @BeforeClass
//    public static void setUpBeforeClass() throws Exception {
//        emf = Persistence.createEntityManagerFactory("sample");
//        em = emf.createEntityManager();
//    }
//
//    @AfterClass
//    public static void tearDownAfterClass() throws Exception {
//        em.close();
//        emf.close();
//    }
//
//    @Test(timeout=1000)
//
//    public void testMinimumAdresse() {
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//
//
//        Book book = new Book("Auteur", "Titre", "2018", 5);
//        em.persist(book);
//        tx.commit();
//        long monId = book.getId();
//        assertNotNull("Id not null", monId);


//        Adresse monAdresseRetrouve = em.find(Adresse.class, monId);
//        assertNotNull("Adresse from database", monAdresseRetrouve);
//        assertEquals("getPays", "FRANCE", monAdresseRetrouve.getPays());
//        assertNull("Code Postal Null", monAdresseRetrouve.getCodePostal());
//        assertNull("Commune Null", monAdresseRetrouve.getCommune());
//        assertNull("MentionSpecial Null", monAdresseRetrouve.getMentionSpecial());
//    }

}
