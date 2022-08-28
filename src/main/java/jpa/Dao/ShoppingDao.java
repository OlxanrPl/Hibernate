package jpa.Dao;

import jpa.Entity.ShoppingEntity;
import java.sql.SQLException;
import java.util.List;
import jdbc.config.Dao.ShoppingDaoImpl.NosuhShoppingExeption;

public interface ShoppingDao {
  List<ShoppingEntity> getAllShopping ();
  void addShopping (Double quantity, Integer product_id, Integer buyer_id) throws SQLException, NosuhShoppingExeption, ShoppingDaoImpl.NosuhShoppingExeption;
  void deleteShopping ( Integer id) throws SQLException, NosuhShoppingExeption, ShoppingDaoImpl.NosuhShoppingExeption;
  void updateShopping (Double quantity, Integer product_id, Integer buyer_id, Integer id) throws SQLException, NosuhShoppingExeption, ShoppingDaoImpl.NosuhShoppingExeption;
}
