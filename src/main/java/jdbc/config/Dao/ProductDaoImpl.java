package jdbc.config.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.config.Config.DatabaseConfig;
import jdbc.config.Dao.BuyerDaoImpl.NosuhBuyerExeption;
import jdbc.config.Entity.BuyerEntity;
import jdbc.config.Entity.ProductEntity;

public class ProductDaoImpl implements ProductDao {
  private static Connection connection;

  static {
    try {
      connection = DatabaseConfig.getConnection();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<ProductEntity> getAllProduct() {
    List<ProductEntity> product = new ArrayList<>();

    try (Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("Select * from product")) {
      while (result.next()) {
        Integer id = result.getInt("id");
        String name = result.getString("description");
        Double price = result.getDouble("price");
        product.add(new ProductEntity(id, name,price));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return product;
  }

  @Override
  public ProductEntity getProductById(Integer ProductId) throws SQLException, NosuhProductExeption {
    ResultSet result = null;
    try (PreparedStatement statement = connection.prepareStatement(
        "Select * from product where id=?")) {
      statement.setInt(1, ProductId);
      result = statement.executeQuery();
      if (result.next()) {
        return new ProductEntity(result.getInt("id"), result.getString("description"),result.getDouble("price"));

      } else {
        throw new NosuhProductExeption("No product with id " + ProductId);
      }

    } finally {
      result.close();
    }
  }

  @Override
  public void addProduct(String description, Double price)
      throws SQLException, NosuhProductExeption {
    try (PreparedStatement statement = connection.prepareStatement(
        "insert into product (description, price) value (?,?)")) {
      statement.setString(1, description);
      statement.setDouble(2, price);
       statement.execute();

    }
  }

  @Override
  public void deleteProduct(Integer ProductId) throws SQLException, NosuhProductExeption {
    try (PreparedStatement statement = connection.prepareStatement(
        "delete  from product where id=?")) {
      statement.setInt(1, ProductId);
      statement.execute();

    }
  }

  @Override
  public void updateProduct(Integer ProductId, String description, Double price)
      throws SQLException, NosuhProductExeption {
    try (PreparedStatement statement = connection.prepareStatement(
        "update product set description=?, price=? where id=?")) {
      statement.setString(1, description);
      statement.setDouble(2, price);
      statement.setInt(3, ProductId);
      statement.execute();
    }
  }
  public static class NosuhProductExeption extends Exception {

    NosuhProductExeption(String message) {
      super(message);
    }
  }
}
