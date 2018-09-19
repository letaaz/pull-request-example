package car.tp4.servlet;

import car.tp4.bean.BookBeanServiceItrf;
import car.tp4.bean.BookServiceBean;
import car.tp4.dataBase.Book;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AddBookServlet Class implements a Servlet to add book
 */
@WebServlet("/add_book")
public class AddBookServlet extends HttpServlet {

    @EJB
    private BookBeanServiceItrf bookBean;

    /**
     * Call when http request send GET
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/book_added.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Call when http request send POST
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("titre");
        String author = request.getParameter("nom_auteur");
        String year = request.getParameter("parution");
        int quantite = 1;
//        System.out.println(title);
//        System.out.println(author);
//        System.out.println(year);
        if(title != null && author != null && year != null) {
           if(bookBean.checkBookData(title, author)){
               Book book = new Book(author, title,year,quantite);
               bookBean.addBook(book);
               request.setAttribute("newBook" , bookBean.getAllBooks());
               RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/book_added.jsp");
               dispatcher.forward(request, response);
           }else{
               System.out.println(title);
               bookBean.updatebookAdd(title,author);
               request.setAttribute("newBook" , bookBean.getAllBooks());
               RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/book_added.jsp");
               dispatcher.forward(request, response);
           }
        }

    }
}
