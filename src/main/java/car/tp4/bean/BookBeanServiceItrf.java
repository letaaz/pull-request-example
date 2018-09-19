package car.tp4.bean;


import car.tp4.dataBase.Book;

import javax.ejb.Local;
import java.util.List;

/**
 * Interface to control BookBean
 *
 * @author Djarallah.b && Lamoot.R
 */
@Local
public interface BookBeanServiceItrf {

    /**
     * init the data base
     */
    void init();


    /**
     * add a book to the base
     * @param book list of Book object
     */

    void addBooks(List<Book> book);

    /**
     * add a book to the base
     * @param book list of Book object
     */
    void addBook(Book book);

    /**
     * searche a book in the base
     *
     * @param titre title of book searched
     * @return the book target
     */
    List<Book> getBook(String titre);


    /**
     * List all the Authors
     *
     * @return all the authors
     */
    List<String> getAllAutorss();

    /**
     * List all of books by author
     * @param authorName name of the author
     * @return all of the books
     */
    List<Book> getBookByAuthor(String authorName);

    /**
     * List all the book
     *
     * @return all the books
     */
    List<Book> getAllBooks();


    /**
     * get book by id
     *
     * @return all the books
     * @param id
     */
    Book getBookById(long id);

    /**
     * List all books order by year (asc or desc)
     * @param order asc or desc
     * @return all books
     */
    List<Book> getAllBookOrderByYear(String order);

    /**
     * Update a book in database
     * @param id unique id of the book
     */
    void updatebookRetr(long id);


    /**
     * update quantite in dataBase
     * @param title
     * @param nameAuther
     */
    void updatebookAdd(String title, String nameAuther);

    /**
     * check if database has un Book X
     * @param title
     * @param nameAuther
     * @return
     */
    boolean checkBookData(String title, String nameAuther);
}