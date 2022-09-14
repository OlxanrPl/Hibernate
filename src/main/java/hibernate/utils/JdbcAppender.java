package hibernate.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;

@Plugin(
    name = "JdbcAppender",
    category = Core.CATEGORY_NAME,
    elementType = Appender.ELEMENT_TYPE
)
public class JdbcAppender extends AbstractAppender {

  private final static ConnectionConfig CONNECTION_CONFIG = new ConnectionConfig();

  protected JdbcAppender(String name) {
    super(name, null, null, false, null);
  }

  @PluginFactory
  public static JdbcAppender createAppender(@PluginAttribute("name") String name) {
    return new JdbcAppender(name);
  }

  @Override
  public void append(LogEvent logEvent) {
    saveLog(logEvent);
  }

  private void saveLog(LogEvent logEvent) {
    Connection connection = CONNECTION_CONFIG.getConnection();
    PreparedStatement preparedStatement = null;
    try {
      preparedStatement = connection.prepareStatement("insert into logs values(?, ?, ?)");
      preparedStatement.setString(1, logEvent.getMessage().getFormattedMessage());
      preparedStatement.setString(2, logEvent.getLevel().name());
      preparedStatement.setString(3, new Date().toString());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      throw new IllegalArgumentException(e);
    }
  }


}
