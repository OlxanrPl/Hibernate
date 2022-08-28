package jdbc.config.Dao;

import java.sql.SQLException;
import java.util.List;
import jdbc.config.Dao.ShoppingDaoImpl.NosuhShoppingExeption;
import jdbc.config.Entity.ShoppingEntity;

public interface ShoppingDao {
  List<ShoppingEntity> getAllShopping ();
  void addShopping (Double quantity, Integer product_id, Integer buyer_id) throws SQLException, NosuhShoppingExeption;
  void deleteShopping ( Integer id) throws SQLException, NosuhShoppingExeption;
  void updateShopping (Double quantity, Integer product_id, Integer buyer_id, Integer id) throws SQLException, NosuhShoppingExeption;
}
