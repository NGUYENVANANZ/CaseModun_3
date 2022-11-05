package Controller.SellerController;

import Models.User.User;
import dao.Cart.CRUD_cart;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Seller_showBill", value = "/Seller_showBill")
public class Seller_showBill extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");
        request.setAttribute("bill", CRUD_cart.showBill(user));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WedSeller/WebSellerHistory.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
