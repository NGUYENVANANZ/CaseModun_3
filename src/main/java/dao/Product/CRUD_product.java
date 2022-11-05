package dao.Product;

import Models.Product.Product;
import Models.User.User;
import dao.User.CRUD_user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CRUD_product {
    public static List<Product> getAllProduct() {
        String sql = "Select * from product where amout > 0";
        List<Product> products = new ArrayList<>();
        try {
            // tạo cái xe để đưa câu lệnh sql qua CSDL
            Statement statement = CRUD_user.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int idproduct = resultSet.getInt("idproduct");
                String name = resultSet.getString("nameproduct");
                int price = resultSet.getInt("price");
                String img = resultSet.getString("img");
                int amout = resultSet.getInt("amout");
                int productType = resultSet.getInt("idproductType");
                products.add(new Product(idproduct, name, price, img, amout, productType));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    public static void saveProduct(Product product) {
        try {
            String sql = "insert into product(nameproduct ,img ,amout,price, idproductType) value ( ?,?,?,?,?)";
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getNameSP());
            preparedStatement.setString(2, product.getImg());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setInt(4, product.getPrice());
            preparedStatement.setInt(5, product.getProductType());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void UpdateProduct(Product product) {
        try {
            String sql = "UPDATE product set nameproduct = ?, img = ?, amout = ?,price = ?,idproductType = ?  where idproduct = ? ";
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getNameSP());
            preparedStatement.setString(2, product.getImg());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setInt(4, product.getPrice());
            preparedStatement.setInt(5, product.getProductType());
            preparedStatement.setInt(6, product.getIdproduct());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteProduct(Product product) {
        try {
            String sql = "DELETE FROM product WHERE idproduct = ? ;";
            PreparedStatement preparedStatement = CRUD_user.connection.prepareStatement(sql);
            preparedStatement.setInt(1, product.getIdproduct());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
