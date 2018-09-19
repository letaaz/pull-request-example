package car.tp4.servlet;

import car.tp4.bean.BookBeanServiceItrf;
import car.tp4.dataBase.Book;
import car.tp4.bean.BookServiceBean;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * BookInitServlet Class implements a Servlet to init database with default books
 */
@WebServlet("/initBooks")
public class BookInitServlet extends HttpServlet {

  @EJB
  private BookBeanServiceItrf bookServiceBean;


  @Override
  public void init() throws ServletException {
  }

  /**
   * Call when http request send GET
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    List<Book> books = new ArrayList<Book>();
    Book newBook = new Book();
    newBook.setAuthor("Victor Hugo");
    newBook.setTitle("Les misérables");
    newBook.setYear("1862");
    newBook.setQuantity(26);
    books.add(newBook);
    Book newBook2 = new Book();
    newBook2.setAuthor("Charles Baudelaire");
    newBook2.setTitle("Les Fleurs du Mal");
    newBook2.setYear("1861");
    newBook2.setQuantity(18);
    books.add(newBook2);

    Book book3 = new Book();
    book3.setAuthor("Franck Thilliez");
    book3.setTitle("Rêver");
    book3.setYear("2016");
    book3.setQuantity(6);
    books.add(book3);

    Book book4 = new Book();
    book4.setAuthor("Franck Thilliez");
    book4.setTitle("Sharko");
    book4.setYear("2017");
    book4.setQuantity(11);
    books.add(book4);

    bookServiceBean.addBooks(books);



    request.setAttribute("books", (bookServiceBean.getAllBooks()));
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/bookList.jsp");
    dispatcher.forward(request, response);
  }


}
