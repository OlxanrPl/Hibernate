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
    List<ProductEntityHb> product = (List<ProductEntityHb>)
        SessionFactoryUtil.getSession().createQuery("From ProductEntityHb").list();

    return product;
  }

  @Override
  public ProductEntityHb getProductById(Integer ProductId) throws SQLException {
    return SessionFactoryUtil.getSession().get(ProductEntityHb.class, ProductId);
  }

  @Override
  public void addProduct(ProductEntityHb be) {
    Session session = SessionFactoryUtil.getSession();
    Transaction transaction=session.beginTransaction();
    session.save(be);
    transaction.commit();
    session.close();
  }

  @Override
  public void deleteProduct(ProductEntityHb be) throws SQLException {
    Session session = SessionFactoryUtil.getSession();
    Transaction transaction=session.beginTransaction();
    session.delete(be);
    transaction.commit();
    session.close();

  }

  @Override
  public void updateProduct(ProductEntityHb be) throws SQLException {
    Session session = SessionFactoryUtil.getSession();
    Transaction transaction=session.beginTransaction();
    session.update(be);
    transaction.commit();
    session.close();
  }
}
