package jpa.Dao;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import jpa.Config.FactoryManager;
import jpa.Entity.BuyerEntity;
import jpa.Entity.ProductEntity;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
  EntityManager em = FactoryManager.getEntityManager();


  @Override
  public List<ProductEntity> getAllProduct() {
    return em.createQuery("Select product from ProductEntity product", ProductEntity.class).getResultList();
  }

  @Override
  public Optional<BuyerEntity> getProductById(Integer ProductId) throws SQLException {
    return em.createQuery("Select product from ProductEntity product WHERE id=:ProductId", BuyerEntity.class).setParameter("ProductId",ProductId).
        getResultList().stream().findFirst();
  }

  @Override
  public void addProduct(BuyerEntity be){
  EntityTransaction et = em.getTransaction();
    et.begin();
    em.persist(be);
    et.commit();
  }

  @Override
  public void deleteProduct(BuyerEntity be) throws SQLException {
    EntityTransaction et = em.getTransaction();
    et.begin();
    em.remove(be);
    et.commit();
  }

  @Override
  public void updateProduct(BuyerEntity be){
  EntityTransaction et = em.getTransaction();
    et.begin();
    em.persist(be);
    et.commit();
  }


}
