package car.tp4.servlet;


import car.tp4.bean.BookBeanServiceItrf;
import car.tp4.bean.CartBeanServiceItf;
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
import java.util.List;

@WebServlet("/validecommande")
public class ValideCommandeServlet extends HttpServlet {
    @EJB
    CartBeanServiceItf commandBean;

    @EJB
    BookBeanServiceItrf bookbean ;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();


        Enumeration e = session.getAttributeNames();
        System.out.print("GO" + e.hasMoreElements());
        while (e.hasMoreElements()) {
            String name = (String) e.nextElement();
            if(name.startsWith("idpanier")) {
                long idBook =Long.parseLong(name.split("-")[1]);
                int quatite = Integer.parseInt((String)session.getAttribute(name));
                Book book= bookbean.getBookById(idBook);
                System.out.println(book.getTitle() + " - ===================>: " + quatite + "<BR>");
                if(quatite>0) {
                    Commande commande = new Commande(book.getTitle(), quatite);
                    System.out.println(idBook + " - id: " + quatite + "<BR>");
                    commandBean.addCommande(commande);
                    session.setAttribute(name,"-1");
                }
            }
        }

        request.setAttribute("newCommande" , commandBean.getAllCommades());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/cart.jsp");
        dispatcher.forward(request, response);
    }


}