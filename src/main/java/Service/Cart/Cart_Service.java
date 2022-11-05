package Service.Cart;

import Models.Cart.Cart;
import Models.User.User;
import dao.Cart.CRUD_cart;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

public class Cart_Service {


    public static ArrayList<Integer> idCart(User user, List<Cart> carts) {
        ArrayList<Integer> idCart = new ArrayList<>();
        for (Cart cart : carts
        ) {
            if (cart.getUserName().equals(user.getUserName())) {
                idCart.add(cart.getIdcart());
            }
        }
    return idCart;
    }

}
