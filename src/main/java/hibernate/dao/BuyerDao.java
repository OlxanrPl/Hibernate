package hibernate.dao;

import hibernate.models.BuyerEntityHb;
import hibernate.models.ProductEntityHb;
import java.sql.SQLException;
import java.util.List;


public interface BuyerDao {
  List<BuyerEntityHb> getAllBuyer ();
  List<ProductEntityHb> getAllProductById (Integer buyerId);
  BuyerEntityHb getBuyerById(Integer buyerId) throws SQLException;
  void addBuyer(BuyerEntityHb bt) throws SQLException;
  void deleteBuyer (BuyerEntityHb bt) throws SQLException;
  void updateBuyer (BuyerEntityHb bt) throws SQLException;

}

