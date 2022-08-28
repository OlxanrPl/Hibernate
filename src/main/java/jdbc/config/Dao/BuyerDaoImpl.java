package jdbc.config.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jdbc.config.Config.DatabaseConfig;
import jdbc.config.Entity.BuyerEntity;

public class BuyerDaoImpl implements BuyerDao {

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
  public List<BuyerEntity> getAllBuyer() {
    List<BuyerEntity> buyer = new ArrayList<>();

    try (Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("Select * from buyer")) {
      while (result.next()) {
        Integer id = result.getInt("id");
        String name = result.getString("name");
        buyer.add(new BuyerEntity(id, name));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return buyer;
  }

  @Override

  public BuyerEntity getBuyerById(Integer buyerId) throws SQLException, NosuhBuyerExeption {
    ResultSet result = null;
    try (PreparedStatement statement = connection.prepareStatement(
        "Select * from buyer where id=?")) {
      statement.setInt(1, buyerId);
      result = statement.executeQuery();
      if (result.next()) {
        return new BuyerEntity(result.getInt("id"), result.getString("name"));

      } else {
        throw new NosuhBuyerExeption("No buyer with id " + buyerId);
      }

    } finally {
      result.close();
    }

  }

  @Override
  public void addBuyer(String name) throws SQLException, NosuhBuyerExeption {

    try (PreparedStatement statement = connection.prepareStatement(
        "insert into buyer (name) value (?)")) {
      statement.setString(1, name);
      statement.execute();

    }

  }

  @Override
  public void deleteBuyer(Integer buyerId) throws SQLException, NosuhBuyerExeption {

    try (PreparedStatement statement = connection.prepareStatement(
        "delete  from buyer where id=?")) {
      statement.setInt(1, buyerId);
      statement.execute();

    }

  }

  @Override
  public void updateBuyer(Integer buyerId, String name) throws SQLException, NosuhBuyerExeption {
    try (PreparedStatement statement = connection.prepareStatement(
        "update buyer set name=? where id=?")) {
      statement.setString(1, name);
      statement.setInt(2, buyerId);
      statement.execute();
    }

  }

  public static class NosuhBuyerExeption extends Exception {

    NosuhBuyerExeption(String message) {
      super(message);
    }
  }
}
