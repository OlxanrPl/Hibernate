package jpa;

import jdbc.config.Dao.BuyerDaoImpl.NosuhBuyerExeption;
import jpa.Dao.BuyerDao;
import jpa.Dao.BuyerDaoImpl;
import java.sql.SQLException;
import jpa.Entity.BuyerEntity;


public class Test  {

  public static void main(String[] args)
      throws SQLException, NosuhBuyerExeption, BuyerDaoImpl.NosuhBuyerExeption {

    BuyerDao buyerDao = new BuyerDaoImpl();
   // ProductDao productDao = new ProductDaoImpl();
   // System.out.println(buyerDao.getBuyerById(2));
   /* buyerDao.getAllBuyer().forEach(System.out::println);
    buyerDao.updateBuyer(3,"Viktory");
    buyerDao.getAllBuyer().forEach(System.out::println);*/
 //   productDao.addProduct("Milk",2.80d);
   // productDao.addProduct("Broth",3.10d);
    // productDao.addProduct("Meat",12.80d);
    // productDao.addProduct("Water",0.80d);
    // productDao.getAllProduct().forEach(System.out::println);
   // productDao.updateProduct(2,"Bread",1.20d);
  //  productDao.getAllProduct().forEach(System.out::println);
    buyerDao.getAllBuyer().forEach(System.out::println);
    buyerDao.updateBuyer(new BuyerEntity("Mr Prime2"));
   // ;
    //System.out.println(buyerDao.getBuyerById(2));
  }

}
