package hibernate.dao;

import hibernate.models.Adress;
import hibernate.models.BuyerEntityHb;
import hibernate.services.SessionFactoryUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdressDaoImpl implements AdressDao {

  @Override
  public List<Adress> getAllAdress() {
    List<Adress> adressList = new ArrayList<>();
    try (Session session = SessionFactoryUtil.getSession()) {

          session.createQuery("SELECT a From Adress a LEFT JOIN FETCH a.buyerEntityHb",
              Adress.class).list();
      return adressList;
    }
  }

  @Override
  public BuyerEntityHb getBuyerById(Integer id) throws SQLException {
    try (Session session = SessionFactoryUtil.getSession()) {
      return session.get(BuyerEntityHb.class, id);
    }
  }

  @Override
  public Adress getAdress(Integer id) throws SQLException {
    try (Session session = SessionFactoryUtil.getSession()) {
      return session.get(Adress.class, id);
    }
  }

  @Override
  public void addAdress(Adress bt) throws SQLException {
    Session session = SessionFactoryUtil.getSession();
    Transaction transaction = session.beginTransaction();
    session.saveOrUpdate(bt);
    transaction.commit();
    session.close();
  }

  @Override
  public void deleteAdress(Adress bt) throws SQLException {
    Session session = SessionFactoryUtil.getSession();
    Transaction transaction = session.beginTransaction();
    session.delete(bt);
    transaction.commit();
    session.close();

  }

  @Override
  public void updateAdress(Adress bt) throws SQLException {
    Session session = SessionFactoryUtil.getSession();
    Transaction transaction = session.beginTransaction();
    session.saveOrUpdate(bt);
    transaction.commit();
    session.close();
  }
}
