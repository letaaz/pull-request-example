package car.tp4.servlet;

import car.tp4.bean.BookBeanServiceItrf;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * GetBookByAuthorsServler Class implements a Servlet to search books by author
 */
@WebServlet("/getBookByAuthor")
public class GetBookByAuthorsServlet extends HttpServlet {

    @EJB
    private BookBeanServiceItrf bookBean;

    /**
     * Call when http request send POST
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("author");
        HttpSession session = request.getSession();
        System.out.println("================================> " + name);
        request.setAttribute("book_author_searched" , bookBean.getBookByAuthor(name));
        session.setAttribute("author", name);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/get_bookByAuthor.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ParamPath = request.getQueryString();
        HttpSession session = request.getSession();


        String[] splitQuery = ParamPath.split("=");
        if (splitQuery[0].toLowerCase().startsWith("idpanier")) {
            String id_book = splitQuery[0].split("-")[1];
            checkPanier(session, splitQuery[0]);
            bookBean.updatebookRetr(Long.parseLong(id_book));
        }


        String title = (String)session.getAttribute("author");
        request.setAttribute("book_author_searched" , bookBean.getBookByAuthor(title));
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/get_bookByAuthor.jsp");
        dispatcher.include(request, response);



    }
    public boolean checkPanier(HttpSession session, String attibuteName){
        Object result = session.getAttribute(attibuteName);
        if(result!= null){
            int numberOfCommand = (Integer.parseInt((String)result));
            numberOfCommand++;
            String attributeValue = String.valueOf(numberOfCommand);
            session.setAttribute(attibuteName,attributeValue);
            return true;
        }
        else{
            session.setAttribute(attibuteName,"1");
            return false;
        }
    }
}