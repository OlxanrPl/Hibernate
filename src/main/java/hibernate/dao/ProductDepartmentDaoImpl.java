package hibernate.dao;

import hibernate.models.ProductDepartment;
import hibernate.services.SessionFactoryUtil;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductDepartmentDaoImpl implements ProductDepartmentDao {

  @Override
  public List<ProductDepartment> getAllProduct() {
    try (Session session = SessionFactoryUtil.getSession()) {
      List<ProductDepartment> product = (List<ProductDepartment>)
          session.createQuery(
              "Select pd From ProductDepartment pd LEFT JOIN FETCH pd.productEntityHbSet").list();
      return product;
    }
  }

  @Override
  public ProductDepartment getProductDepartmentById(Integer depId) throws SQLException {
    try (Session session = SessionFactoryUtil.getSession()) {
      return session.get(ProductDepartment.class, depId);
    }
  }

  @Override
  public void addProductDepartment(ProductDepartment be) {
    Session session = SessionFactoryUtil.getSession();
    Transaction transaction = session.beginTransaction();
    session.save(be);
    transaction.commit();
    session.close();
  }

  @Override
  public void deleteProductDepartment(ProductDepartment be) throws SQLException {
    Session session = SessionFactoryUtil.getSession();
    Transaction transaction = session.beginTransaction();
    session.delete(be);
    transaction.commit();
    session.close();
  }

  @Override
  public void updateProductDepartment(ProductDepartment be) throws SQLException {
    Session session = SessionFactoryUtil.getSession();
    Transaction transaction = session.beginTransaction();
    session.update(be);
    transaction.commit();
    session.close();
  }
}
