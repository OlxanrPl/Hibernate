package hibernate;

import hibernate.models.Adress;
import hibernate.models.BuyerEntityHb;
import hibernate.models.ProductDepartment;
import hibernate.models.ProductEntityHb;
import hibernate.services.SessionFactoryUtil;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;

public class Test {

  public static void main(String[] args) throws SQLException {
    Session session = SessionFactoryUtil.getSession();
    session.beginTransaction();




    ProductDepartment productDepartment = new ProductDepartment();
    productDepartment.setDepName("Milk products");
    ProductDepartment productDepartment1 = new ProductDepartment();
    productDepartment1.setDepName("Grocery");

    ProductEntityHb productEntityHb = new ProductEntityHb();
    productEntityHb.setDescription("IceCola");
    productEntityHb.setPrice(0.81d);
    productEntityHb.setCount(3d);
    productEntityHb.setProductDepartment(productDepartment1);
    ProductEntityHb productEntityHb1 = new ProductEntityHb();
    productEntityHb1.setDescription("Kefir");
    productEntityHb1.setPrice(1.10d);
    productEntityHb1.setCount(2.5d);
    productEntityHb1.setProductDepartment(productDepartment);
    ProductEntityHb productEntityHb2 = new ProductEntityHb();
    productEntityHb2.setDescription("Borgomy");
    productEntityHb2.setPrice(0.41d);
    productEntityHb2.setCount(2d);
    productEntityHb2.setProductDepartment(productDepartment1);

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
    adress.setDescription("Nebesnoi sotni 102 Poltava");

    buyerEntityHb.setName("Viktoria");
    buyerEntityHb.setAdress(adress);
    adress.setBuyerEntityHb(buyerEntityHb);
    buyerEntityHb.setProductEntityHbSet(productEntityHbSet);
    session.save(productDepartment);
    session.save(productDepartment1);
    session.save(buyerEntityHb);
    System.out.println("session.save(buyerEntityHb) - ok");
    session.getTransaction().commit();
    session.close();
    System.out.println("success");

  }

}
