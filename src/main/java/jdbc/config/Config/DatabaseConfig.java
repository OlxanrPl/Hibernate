package jdbc.config.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
  private static final  String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
  private static final  String URL = "jdbc:mysql://localhost:3306/shop?serverTimezone=UTC";
  private static final  String USER = "root";
  private static final  String PASSWORD = "admin";
  public static Connection getConnection() throws ClassNotFoundException, SQLException {
    Class.forName(MYSQL_DRIVER);
    return DriverManager.getConnection(URL,USER,PASSWORD);

  }

}
