package hibernate.dao;

import hibernate.models.BuyerEntityHb;
import java.sql.SQLException;
import java.util.List;


public interface BuyerDao {
  List<BuyerEntityHb> getAllBuyer ();
  BuyerEntityHb getBuyerById(Integer buyerId) throws SQLException;
  void addBuyer(BuyerEntityHb bt) throws SQLException;
  void deleteBuyer (BuyerEntityHb bt) throws SQLException;
  void updateBuyer (BuyerEntityHb bt) throws SQLException;

}

