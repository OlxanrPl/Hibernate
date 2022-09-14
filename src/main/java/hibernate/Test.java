package hibernate;

import hibernate.dao.BuyerDaoImplHb;
import hibernate.dao.ProductDepartmentDaoImpl;
import hibernate.models.Adress;
import hibernate.models.BuyerEntityHb;
import hibernate.models.ProductDepartment;
import hibernate.models.ProductEntityHb;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Test {
static final Logger logger = LogManager.getLogger(Test.class);
  public static void main(String[] args) throws SQLException {

    ProductDepartment productDepartment = new ProductDepartment();
    productDepartment.setDepName("Milk products");
    ProductDepartment productDepartment1 = new ProductDepartment();
    productDepartment1.setDepName("Grocery");

    ProductEntityHb productEntityHb = new ProductEntityHb();
    productEntityHb.setDescription("Jivschik");
    productEntityHb.setPrice(0.81d);
    productEntityHb.setCount(2d);
    productEntityHb.setProductDepartment(productDepartment1);
    ProductEntityHb productEntityHb1 = new ProductEntityHb();
    productEntityHb1.setDescription("Kefir");
    productEntityHb1.setPrice(1.10d);
    productEntityHb1.setCount(4d);
    productEntityHb1.setProductDepartment(productDepartment);
    ProductEntityHb productEntityHb2 = new ProductEntityHb();
    productEntityHb2.setDescription("Yogurt");
    productEntityHb2.setPrice(2.3d);
    productEntityHb2.setCount(8d);
    productEntityHb2.setProductDepartment(productDepartment);

    Set<ProductEntityHb> productEntityHbSetM = new HashSet<>();
    productEntityHbSetM.add(productEntityHb1);
    productDepartment.setProductEntityHbSet(productEntityHbSetM);

    Set<ProductEntityHb> productEntityHbSetG = new HashSet<>();
    productEntityHbSetG.add(productEntityHb);
    productEntityHbSetG.add(productEntityHb2);
    productDepartment1.setProductEntityHbSet(productEntityHbSetG);

    Set<ProductEntityHb> productEntityHbSet = new HashSet<>();
    productEntityHbSet.add(productEntityHb);
    productEntityHbSet.add(productEntityHb1);
    productEntityHbSet.add(productEntityHb2);

    BuyerEntityHb buyerEntityHb = new BuyerEntityHb();
    Adress adress = new Adress();
    adress.setDescription("Bibliotechna str. 11 Poltava");

    buyerEntityHb.setName("Petro Tutka");
    buyerEntityHb.setAdress(adress);
    adress.setBuyerEntityHb(buyerEntityHb);
    buyerEntityHb.setProductEntityHbSet(productEntityHbSet);

    ProductDepartmentDaoImpl pdpDao = new ProductDepartmentDaoImpl();
    pdpDao.addProductDepartment(productDepartment);
    pdpDao.addProductDepartment(productDepartment1);
    BuyerDaoImplHb buyDao = new BuyerDaoImplHb();
    buyDao.addBuyer(buyerEntityHb);

    logger.info("session.save(buyerEntityHb) - ok");


  }

}
