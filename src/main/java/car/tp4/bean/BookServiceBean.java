package car.tp4.bean;
import car.tp4.dataBase.Book;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


/**
 * BookServiceBean Class implements interface BookBeanService
 */
@Stateless
@Local(BookBeanServiceItrf.class)
public class BookServiceBean implements BookBeanServiceItrf {

    @PersistenceContext(unitName = "book-pu")
    private EntityManager entityManager;

    /**
     * init the data base
     */
    @Override
    public void init() {

    }

    /**
     * add a books to the base
     * @param book list of Book object
     */
    @Override
    public void addBooks(List<Book> book) {
        for(Book bk : book)
            entityManager.persist(bk);
    }

    /**
     * add a book to the base
     * @param book object of  Book
     */
    @Override
    public void addBook(Book book) {
            entityManager.persist(book);
    }


    /**
     * searche a book in the base
     *
     * @param titre title of book searched
     * @return the book target
     */
    @Override
    public List<Book> getBook(String titre) {
        Query q;
        q = entityManager.createQuery("SELECT OBJECT(b) FROM Book b WHERE b.title LIKE :t");
        q.setParameter("t", "%" + titre +"%");
        String retour;
        return q.getResultList();
//        try{
//            retour = q.getSingleResult().toString();
//        }catch(NoResultException e){
//            retour = "Le livre demandé n'existe pas dans la base.";
//        }
//        return retour;
    }




    /**
     * List all the Authors
     *
     * @return all the authors
     */
    @Override
    public List<String> getAllAutorss() {
        Query query = entityManager.createQuery("SELECT m.author from Book as m");
        return query.getResultList();
    }


    /**
     * Search a book in the base by his author
     * @param name name of book's author searched
     * @return the book target
     */
    @Override
    public List<Book> getBookByAuthor(String name) {
        Query q;
        q = entityManager.createQuery("SELECT OBJECT(b) FROM Book b WHERE b.author LIKE :t");
        q.setParameter("t", "%" + name +"%");
        String retour;
        System.out.print("======================> " + q.getResultList());
        return q.getResultList();
//        try{
//            retour = q.getResultList().toString();
//        }catch(NoResultException e){
//            retour = "Le livre demandé n'existe pas dans la base.";
//        }
//        return retour;

    }

    /**
     * List all the book
     *
     * @return all the books
     */
    @Override
    public List<Book> getAllBooks() {
        Query query = entityManager.createQuery("SELECT m from Book as m");
        return query.getResultList();
    }


    /**
     * List all the book
     *
     * @return all the books
     * @param id
     */
    @Override
    public Book getBookById(long id) {
        Query query = entityManager.createQuery("SELECT m from Book as m where m.id = :id");
        query.setParameter("id", id);
        return (Book)query.getSingleResult();
    }

    /**
     * Get list of books order by the year of publication
     * @param order asc or desc
     * @return List of Book
     */
    @Override
    public List<Book> getAllBookOrderByYear(String order) {
        Query query;
        if(order.equals("DESC")) {
            query = entityManager.createQuery("SELECT b from Book b order by b.year DESC");
        }
        else
        {
            query = entityManager.createQuery("SELECT b from Book b order by b.year ASC");
        }

        return query.getResultList();
    }

    /**
     * Update negatuv a book in database
     * @param id unique id of the book
     */
    @Override
    public void updatebookRetr(long id){
        Query query= entityManager.createQuery("UPDATE Book b SET b.quantity = b.quantity-1 where b.id = :t");
        query.setParameter("t",id);
        query.executeUpdate();
    }

    /**
     * Update  positive a book in database
     * @param title
     * @param nameAuther
     */
    @Override
    public void updatebookAdd(String title, String nameAuther){
        Query query= entityManager.createQuery("UPDATE Book b SET b.quantity = b.quantity+1  WHERE b.author LIKE :a AND b.title LIKE :t");
        query.setParameter("t",title);
        query.setParameter("a",nameAuther);
        query.executeUpdate();
    }

    /**
     * check if boock existe
     * @param title
     * @param nameAuther
     */
    @Override
    public boolean checkBookData(String title, String nameAuther) {
        Query query= entityManager.createQuery("SELECT OBJECT(b) FROM Book b WHERE b.author LIKE :a AND b.title LIKE :t");
        query.setParameter("t",title);
        query.setParameter("a",nameAuther);
        try{
              List result = query.getResultList();
              if(result.size()==0)
                  return true;
              else
                  return false;

        }catch(NoResultException e){
            return true;
        }
    }
}
