package hibernate;

import hibernate.models.BuyerEntityHb;
import hibernate.models.ProductEntityHb;
import hibernate.services.SessionFactoryUtil;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import hibernate.dao.BuyerDaoImplHb;

public class Test {

  public static void main(String[] args) throws SQLException {
    Session session = SessionFactoryUtil.getSession();
    session.beginTransaction();
/*
    BuyerEntityHb buyerEntityHb = new BuyerEntityHb();
    buyerEntityHb.setName("Karl");
    ProductEntityHb productEntityHb =new ProductEntityHb();
    productEntityHb.setDescription("Juice");
    productEntityHb.setPrice(0.50d);
    productEntityHb.setCount(3d);
    ProductEntityHb productEntityHb1 =new ProductEntityHb();
    productEntityHb1.setDescription("Sugar");
    productEntityHb1.setPrice(1.50d);
    productEntityHb1.setCount(2.5d);
    ProductEntityHb productEntityHb2 =new ProductEntityHb();
    productEntityHb2.setDescription("Bread");
    productEntityHb2.setPrice(0.50d);
    productEntityHb2.setCount(2d);
    Set<ProductEntityHb> productEntityHbSet = new HashSet<>();
    productEntityHbSet.add(productEntityHb);
    productEntityHbSet.add(productEntityHb1);
    productEntityHbSet.add(productEntityHb2);
    buyerEntityHb.setProductEntityHbSet(productEntityHbSet);

    session.save(buyerEntityHb);
    session.save(productEntityHb);

    session.getTransaction().commit();
    */

    BuyerDaoImplHb daoImplHb = new BuyerDaoImplHb();
   daoImplHb.getAllBuyer().forEach(System.out::println);
   // System.out.println(daoImplHb.getBuyerById(4).toString());
    session.close();
  }

}
