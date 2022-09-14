package hibernate.dao;

import hibernate.dto.ProductDTO;
import hibernate.models.BuyerEntityHb;
import hibernate.models.ProductEntityHb;
import hibernate.services.SessionFactoryUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ProductDaoImplHb implements ProductDao {

  static final Logger logger = LogManager.getLogger(ProductDepartmentDaoImpl.class);

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

  public List<ProductDTO> getDepartment(Session session, String departmnt) {
    logger.error("getDepartment");
    List<ProductDTO> lPDTO = new ArrayList<>();
    try {
      CriteriaBuilder builder = session.getCriteriaBuilder();
      CriteriaQuery<ProductEntityHb> criteria = builder.createQuery(ProductEntityHb.class);
      Root<ProductEntityHb> from = criteria.from(ProductEntityHb.class);
      from.join("buyerEntityHbs");
      criteria.select(from);
      criteria.where(builder.equal(from.get("productDepartment").get("depName"), departmnt));
      TypedQuery<ProductEntityHb> typed = session.createQuery(criteria);
      System.out.println("Grocery print");
      List<ProductEntityHb> products = typed.getResultList();
      for (ProductEntityHb by : products) {
        List<BuyerEntityHb> buyers = by.getBuyerEntityHbs().stream().toList();

        for (BuyerEntityHb byr : buyers) {
          ProductDTO pDTO = new ProductDTO(byr.getName(),
              byr.getAdress().getDescription(),
              by.getDescription(), by.getCount(), by.getPrice(),
              by.getProductDepartment().getDepName());
          lPDTO.add(pDTO);

        }
      }
    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);

    }
    return lPDTO;
  }
}
