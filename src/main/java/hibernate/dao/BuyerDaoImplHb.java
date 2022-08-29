package hibernate.dao;

import hibernate.models.BuyerEntityHb;
import hibernate.models.ProductEntityHb;
import hibernate.services.SessionFactoryUtil;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class BuyerDaoImplHb implements BuyerDao {


  @Override
  public List<BuyerEntityHb> getAllBuyer() {
    try (Session session = SessionFactoryUtil.getSession()) {
      List<BuyerEntityHb> buyers = (List<BuyerEntityHb>)
          session.createQuery("From BuyerEntityHb").list();
      return buyers;
    }
  }

  @Override
  public List<ProductEntityHb> getAllProductById(Integer buyerId) {
    try (Session session = SessionFactoryUtil.getSession()) {
      return session.createQuery(
              " select be.productEntityHbSet FROM BuyerEntityHb be WHERE be.id=:buyerId")
          .setParameter("buyerId", buyerId)
          .getResultList();
    }
  }

  @Override

  public BuyerEntityHb getBuyerById(Integer buyerId) throws SQLException {
    try (Session session = SessionFactoryUtil.getSession()) {
      return session.get(BuyerEntityHb.class, buyerId);
    }
  }

  @Override
  public void addBuyer(BuyerEntityHb bt) throws SQLException {
    Session session = SessionFactoryUtil.getSession();
    Transaction transaction = session.beginTransaction();
    session.save(bt);
    transaction.commit();
    session.close();


  }

  @Override
  public void deleteBuyer(BuyerEntityHb bt) throws SQLException {
    Session session = SessionFactoryUtil.getSession();
    Transaction transaction = session.beginTransaction();
    session.delete(bt);
    transaction.commit();
    session.close();


  }

  @Override
  public void updateBuyer(BuyerEntityHb bt) throws SQLException {
    Session session = SessionFactoryUtil.getSession();
    Transaction transaction = session.beginTransaction();
    session.update(bt);
    transaction.commit();
    session.close();


  }


}
