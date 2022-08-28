package jpa.Dao;

import jpa.Entity.ShoppingEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShoppingDaoImpl implements ShoppingDao {
  private static Connection connection;


  @Override
  public List<ShoppingEntity> getAllShopping() {
    List<ShoppingEntity> shopping = new ArrayList<>();

    try (Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("Select * from shopping")) {
      while (result.next()) {
        Double quantity = result.getDouble("quantity");
        Integer product_id = result.getInt("product_id");
        Integer buyer_id = result.getInt("buyer_id");
        Integer id = result.getInt("id");
        shopping.add(new ShoppingEntity(id,product_id,quantity,buyer_id));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return shopping;
  }

  @Override
  public void addShopping(Double quantity, Integer product_id, Integer buyer_id)
      throws SQLException, NosuhShoppingExeption {
    try (PreparedStatement statement = connection.prepareStatement(
        "insert into shopping (quantity, product_id, buyer_id) value (?,?,?)")) {
         statement.setDouble(1, quantity);
         statement.setInt(2,product_id);
         statement.setInt(3,buyer_id);
      statement.execute();

    }
  }

  @Override
  public void deleteShopping(Integer id)
      throws SQLException, NosuhShoppingExeption {
    try (PreparedStatement statement = connection.prepareStatement(
        "delete  from shopping where id=?")) {
        statement.setInt(1,id);
        statement.execute();

    }
  }

  @Override
  public void updateShopping(Double quantity, Integer product_id, Integer buyer_id, Integer id)
      throws SQLException, NosuhShoppingExeption {
    try (PreparedStatement statement = connection.prepareStatement(
        "update product set quantity=?, product_id=?, buyer_id=? where id=?")) {
      statement.setDouble(1, quantity);
      statement.setInt(2,product_id);
      statement.setInt(3,buyer_id);
      statement.setInt(4,id);
      statement.execute();
    }
  }
  public static class NosuhShoppingExeption extends Exception {

    NosuhShoppingExeption(String message) {
      super(message);
    }
  }
}
