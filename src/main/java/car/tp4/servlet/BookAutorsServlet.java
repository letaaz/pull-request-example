package car.tp4.servlet;

import car.tp4.bean.BookBeanServiceItrf;
import car.tp4.bean.BookServiceBean;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * BookAuthorsServlets Class implements a Servlet to show all authors available
 */
@WebServlet("/BookAutors")
public class BookAutorsServlet extends HttpServlet {

    @EJB
    private BookBeanServiceItrf bookServiceBean;


    /**
     *
     * @throws ServletException
     */
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


        request.setAttribute("booksAutors", (bookServiceBean.getAllAutorss()));
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/authorsList.jsp");
        dispatcher.forward(request, response);
    }
}
