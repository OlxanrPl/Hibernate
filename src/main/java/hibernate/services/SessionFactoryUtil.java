package hibernate.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
public static Session getSession () {
  Configuration configuration = new Configuration();
  configuration.configure("hibernate.cfg.xml");
  SessionFactory factory = configuration.buildSessionFactory();
  return factory.openSession();
}


}
