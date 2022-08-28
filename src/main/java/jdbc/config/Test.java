package jdbc.config;

import java.sql.Connection;
import java.sql.SQLException;
import jdbc.config.Config.DatabaseConfig;
import jdbc.config.Dao.BuyerDao;
import jdbc.config.Dao.BuyerDaoImpl;
import jdbc.config.Dao.BuyerDaoImpl.NosuhBuyerExeption;
import jdbc.config.Dao.ProductDao;
import jdbc.config.Dao.ProductDaoImpl;
import jdbc.config.Dao.ProductDaoImpl.NosuhProductExeption;

public class Test  {

  public static void main(String[] args)
      throws SQLException, NosuhBuyerExeption, NosuhProductExeption {

    BuyerDao buyerDao = new BuyerDaoImpl();
    ProductDao productDao = new ProductDaoImpl();
   // System.out.println(buyerDao.getBuyerById(2));
   /* buyerDao.getAllBuyer().forEach(System.out::println);
    buyerDao.updateBuyer(3,"Viktory");
    buyerDao.getAllBuyer().forEach(System.out::println);*/
 //   productDao.addProduct("Milk",2.80d);
   // productDao.addProduct("Broth",3.10d);
    // productDao.addProduct("Meat",12.80d);
    // productDao.addProduct("Water",0.80d);
    // productDao.getAllProduct().forEach(System.out::println);
    productDao.updateProduct(2,"Bread",1.20d);
    productDao.getAllProduct().forEach(System.out::println);
  }

}
