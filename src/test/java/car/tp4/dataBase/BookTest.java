package car.tp4.dataBase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void GetAttributeTest(){
        String author = "author";
        String title = "title";
        String year= "9999";
        int quantite = 1;

        Book book = new Book(author,title,year,quantite);

        assertEquals(author, book.getAuthor());
        assertEquals(title, book.getTitle());
        assertEquals(year, book.getYear());
        assertEquals(quantite, book.getQuantity());
    }

    @Test
    public void SetAttributeTest(){
        String author = "Mr X";
        String title = "Livre 1";
        String year= "1994";
        int quantite = 1;

        Book book = new Book(null,null,null,0);

        book.setAuthor(author);
        book.setTitle(title);
        book.setQuantity(quantite);
        book.setYear(year);

        assertEquals(author, book.getAuthor());
        assertEquals(title, book.getTitle());
        assertEquals(year, book.getYear());
        assertEquals(quantite, book.getQuantity());
    }


    @Test
    public void testHashCode() {
        Book b1 = new Book("", "", "0", 1);
        assertEquals(0, b1.hashCode());
        Book b2 = new Book("", "", "1", 1);
        assertEquals(0, b2.hashCode());

    }

    @Test
    public void testAttributeNotEquals() {
        Book b1 = new Book("Mr X", "Book X", "1550", 42);
        Book b2 = new Book("Mr Y", "Book X", "1665", 41);

        assertFalse(b1.equals(b2));
    }

}