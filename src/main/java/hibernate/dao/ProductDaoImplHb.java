package hibernate.dao;

import hibernate.models.ProductEntityHb;
import hibernate.services.SessionFactoryUtil;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ProductDaoImplHb implements ProductDao {


  @Override
  public List<ProductEntityHb> getAllProduct() {
    try (Session session = SessionFactoryUtil.getSession()) {
      List<ProductEntityHb> product = (List<ProductEntityHb>)
          session.createQuery(
              "Select pe From ProductEntityHb pe LEFT JOIN FETCH pe.productDepartment").list();
      return product;
    }

  }

  @Override
  public ProductEntityHb getProductById(Integer ProductId) throws SQLException {
    try (Session session = SessionFactoryUtil.getSession()) {
      return session.get(ProductEntityHb.class, ProductId);
    }
  }

  @Override
  public void addProduct(ProductEntityHb be) {
    Session session = SessionFactoryUtil.getSession();
    Transaction transaction = session.beginTransaction();
    session.save(be);
    transaction.commit();
    session.close();
  }

  @Override
  public void deleteProduct(ProductEntityHb be) throws SQLException {
    Session session = SessionFactoryUtil.getSession();
    Transaction transaction = session.beginTransaction();
    session.delete(be);
    transaction.commit();
    session.close();

  }

  @Override
  public void updateProduct(ProductEntityHb be) throws SQLException {
    Session session = SessionFactoryUtil.getSession();
    Transaction transaction = session.beginTransaction();
    session.update(be);
    transaction.commit();
    session.close();
  }
}
