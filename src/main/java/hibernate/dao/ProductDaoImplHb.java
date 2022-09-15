package hibernate.dao;

import hibernate.dto.ProductDTO;
import hibernate.dto.SumProductDTO;
import hibernate.models.BuyerEntityHb;
import hibernate.models.ProductEntityHb;
import hibernate.services.SessionFactoryUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
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
    List<ProductEntityHb> product = new ArrayList<>();
    try (Session session = SessionFactoryUtil.getSession()) {

         product.addAll(  session.createQuery(
              "Select pe From ProductEntityHb pe LEFT JOIN FETCH pe.productDepartment").list());

    }catch (Exception ex) {
      logger.error(ex.getMessage(), ex);

    }
    return product;
  }

  @Override
  public ProductEntityHb getProductById(Integer ProductId) throws SQLException {
    ProductEntityHb pEhb= new ProductEntityHb();
    try (Session session = SessionFactoryUtil.getSession()) {

      pEhb= session.get(ProductEntityHb.class, ProductId);
    }catch (Exception ex) {
      logger.error(ex.getMessage(), ex);

    }
    return pEhb;
  }

  @Override
  public void addProduct(ProductEntityHb be) {
   try {
     Session session = SessionFactoryUtil.getSession();
     Transaction transaction = session.beginTransaction();
     session.save(be);
     transaction.commit();
     session.close();
   }catch (Exception ex) {
     logger.error(ex.getMessage(), ex);

   }
  }

  @Override
  public void deleteProduct(ProductEntityHb be) throws SQLException {
    try {
      Session session = SessionFactoryUtil.getSession();
      Transaction transaction = session.beginTransaction();
      session.delete(be);
      transaction.commit();
      session.close();
    } catch (Exception ex) {
      logger.error(ex.getMessage(), ex);

    }
  }

  @Override
  public void updateProduct(ProductEntityHb be) throws SQLException {
   try {
     Session session = SessionFactoryUtil.getSession();
     Transaction transaction = session.beginTransaction();
     session.update(be);
     transaction.commit();
     session.close();
   }catch (Exception ex) {
       logger.error(ex.getMessage(), ex);

     }
  }

  @Override
  public List<SumProductDTO> getSumAllProduct() {
    List<SumProductDTO> lProd = new ArrayList<>();

    try (Session session = SessionFactoryUtil.getSession()) {

   lProd= ( session.createQuery(
          "Select new hibernate.dto.SumProductDTO( pe.description as peProduct, sum(pe.price * pe.count) as peSuma) "
              + "From ProductEntityHb pe group by pe.description ").getResultList());
    }catch (Exception ex) {
      logger.error(ex.getMessage(), ex);

    }
    return lProd;
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
