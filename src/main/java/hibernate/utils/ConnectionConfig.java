package hibernate.utils;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfig {
  private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
  private static final String DB_URL = "jdbc:mysql://localhost:3306/shophb?serverTimezone=UTC";
  private static final String ID = "root";
  private static final String PASS = "admin";
  public Connection getConnection() {
    try {
      Class.forName(DRIVER_NAME);
      return DriverManager.getConnection(DB_URL, ID, PASS);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void close(AutoCloseable statement) {
    if (statement != null) {
      try {
        statement.close();
      }
      catch (Exception e) {
        throw  new RuntimeException(e);
      }
    }
  }

}
