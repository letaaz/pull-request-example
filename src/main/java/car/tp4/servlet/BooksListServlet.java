package car.tp4.servlet;

import car.tp4.bean.BookBeanServiceItrf;
import car.tp4.dataBase.Book;
import car.tp4.dataBase.Commande;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

/**
 * BooksListServlet Class implements a Servlet to list of the book available
 */
@WebServlet("/list_books")
public class BooksListServlet extends HttpServlet {

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

        HttpSession session = request.getSession();

        //System.out.println("----------------------------------------getQueryString----------" + request.getQueryString());
        //System.out.println("----------------------------------------getRequestURI----------" + request.getRequestURI());

        String ParamPath = request.getQueryString();

        if(ParamPath == null){
            System.out.println("ParamPath == null");
            request.setAttribute("books", (bookServiceBean.getAllBooks()));
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/bookList.jsp");
            dispatcher.forward(request, response);
        }
        else {
            String[] splitQuery = ParamPath.split("=");
            if (splitQuery[1].toLowerCase().equals("asc") || splitQuery[1].toLowerCase().equals("desc")) {
                System.out.println("PATHPARAM !==== NULL");
                request.setAttribute("books", (bookServiceBean.getAllBookOrderByYear(splitQuery[1].toUpperCase())));
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/bookList.jsp");
                dispatcher.forward(request, response);
            }
            else if(splitQuery[0].toLowerCase().startsWith("idpanier"))
            {
                String id_book = splitQuery[0].split("-")[1];
                System.out.println("---------------------------------------- CHECKED ----------" + checkPanier(session, splitQuery[0]));
                bookServiceBean.updatebookRetr(Long.parseLong(id_book));
                System.out.println("----------------------------------------getQueryString----------" + request.getQueryString());
                request.setAttribute("books", (bookServiceBean.getAllBooks()));
                //session.setAttribute(splitQuery[0],splitQuery[1]);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/bookList.jsp");
                dispatcher.forward(request, response);
            }else if(splitQuery[0].toLowerCase().startsWith("getatt")){
                Enumeration e = session.getAttributeNames();
                while (e.hasMoreElements()) {
                    String name = (String) e.nextElement();
                    if(name.startsWith("idpanier")) {
                        long idBook =Long.parseLong(name.split("-")[1]);
                        int quatite = Integer.parseInt((String)session.getAttribute(name));
                        String title= bookServiceBean.getBookById(idBook).getTitle();
                        System.out.println(title + " - ===================>: " + quatite + "<BR>");
                        Commande commande = new Commande(title, quatite);
                        session.setAttribute("panier"+idBook,commande);

                    }
                }
                request.setAttribute("panier", (bookServiceBean.getAllBooks()));
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/valideCommande.jsp");
                dispatcher.forward(request, response);
            }else{
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/bookList.jsp");
                dispatcher.forward(request, response);
            }
        }


    }

    public boolean checkPanier(HttpSession session,String attibuteName){
        Object result = session.getAttribute(attibuteName);
        if(result!= null){
            int numberOfCommand = (Integer.parseInt((String)result));
            System.out.println("========> "+numberOfCommand);
            numberOfCommand++;
            String attributeValue = String.valueOf(numberOfCommand);
            session.setAttribute(attibuteName,attributeValue);
            System.out.println("========> "+attributeValue);
            return true;
        }
        else{
            session.setAttribute(attibuteName,"1");
            return false;
        }
    }

}
