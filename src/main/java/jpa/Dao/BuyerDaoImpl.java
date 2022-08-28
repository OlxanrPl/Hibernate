package jpa.Dao;

import java.util.Optional;
import javax.persistence.EntityTransaction;
import jdbc.config.Dao.BuyerDaoImpl.NosuhBuyerExeption;
import jpa.Config.FactoryManager;
import jpa.Entity.BuyerEntity;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;

public class BuyerDaoImpl   implements BuyerDao {
//EntityManagerFactory emf = FactoryManager.getEntityManagerFactory("AppStorePersistence");

  EntityManager em = FactoryManager.getEntityManager();



  @Override
  public List<BuyerEntity> getAllBuyer() {
  return em.createQuery("Select buyer from BuyerEntity buyer", BuyerEntity.class).getResultList();

  }

  @Override

  public Optional<BuyerEntity> getBuyerById(Integer buyerId) throws SQLException, NosuhBuyerExeption {
    return em.createQuery("Select buyer from BuyerEntity buyer WHERE id=:buyerid", BuyerEntity.class).setParameter("buyerid",buyerId).
        getResultList().stream().findFirst();

  }

    @Override
  public void addBuyer(BuyerEntity bt) throws SQLException, NosuhBuyerExeption {

    EntityTransaction et = em.getTransaction();
    et.begin();
    em.persist(bt);
    et.commit();

  }

  @Override
  public void deleteBuyer(BuyerEntity bt) throws SQLException, NosuhBuyerExeption {
    EntityTransaction et = em.getTransaction();
    et.begin();
    em.remove(bt);
    et.commit();


  }

  @Override
  public void updateBuyer(BuyerEntity bt) throws SQLException, NosuhBuyerExeption {
    EntityTransaction et = em.getTransaction();
    et.begin();
    em.persist(bt);
    et.commit();

  }

  public static class NosuhBuyerExeption extends Exception {

    NosuhBuyerExeption(String message) {
      super(message);
    }
  }
}
