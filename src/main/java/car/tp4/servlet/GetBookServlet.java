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
 * GetBookServlet Class implements a Servlet to search book by title
 */
@WebServlet("/get_book")
public class GetBookServlet extends HttpServlet {

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
        HttpSession session = request.getSession();

        String title = request.getParameter("title");
                request.setAttribute("book_searched" , bookBean.getBook(title));
                session.setAttribute("title", title);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/get_book.jsp");
                dispatcher.forward(request, response);
        }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ParamPath = request.getQueryString();
        HttpSession session = request.getSession();


            String[] splitQuery = ParamPath.split("=");
            if (splitQuery[0].toLowerCase().startsWith("idpanier")) {
                String id_book = splitQuery[0].split("-")[1];
                System.out.println("CHEKED" + checkPanier(session, splitQuery[0]));
                bookBean.updatebookRetr(Long.parseLong(id_book));
                request.setAttribute("books", (bookBean.getAllBooks()));
            }


        String title = (String)session.getAttribute("title");
        System.out.println("CHE====================KED" + title);
        request.setAttribute("book_searched" , bookBean.getBook(title));
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/get_book.jsp");
        dispatcher.include(request, response);



    }

    public boolean checkPanier(HttpSession session, String attibuteName){
        Object result = session.getAttribute(attibuteName);
        if(result!= null){
            int numberOfCommand = (Integer.parseInt((String)result));
            System.out.println("=> "+numberOfCommand);
            numberOfCommand++;
            String attributeValue = String.valueOf(numberOfCommand);
            session.setAttribute(attibuteName,attributeValue);
            System.out.println("=> "+attributeValue);
            return true;
        }
        else{
            session.setAttribute(attibuteName,"1");
            return false;
        }
    }

}
