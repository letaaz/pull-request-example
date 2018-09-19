package car.tp4.servlet;


import car.tp4.bean.CartBeanServiceItf;

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
 * CartServlet Class implements a Servlet to show content of the cart
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet{

    @EJB
    private CartBeanServiceItf cartBean;

    /**
     * Call when http request send GET
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
//        HttpSession session = request.getSession();
//        cartBean.init(session.getId());
//
//
//        System.out.println("---------->>>>>>> " + session.getId());
//
//        request.setAttribute("books", (cartBean.getBooks()));
//        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/cart.jsp");
//        dispatcher.forward(request, response);
    }

}
