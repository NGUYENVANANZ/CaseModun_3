package Controller.SellerController;

import Models.Product.Product;
import dao.Product.CRUD_product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SellerAdd_Product", value = "/SellerAdd_Product")
public class SellerAdd_Product extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String img = request.getParameter("img");
        String nameProduct = request.getParameter("nameProduct");
        int price = Integer.parseInt(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        int productType = Integer.parseInt(request.getParameter("browser"));

        Product product = new Product(nameProduct, price, img, amount, productType);
        CRUD_product.saveProduct(product);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/SellerProduct_Servlet");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
