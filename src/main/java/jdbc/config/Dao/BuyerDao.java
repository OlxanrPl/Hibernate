package jdbc.config.Dao;

import java.sql.SQLException;
import java.util.List;
import jdbc.config.Dao.BuyerDaoImpl.NosuhBuyerExeption;
import jdbc.config.Entity.BuyerEntity;

public interface BuyerDao {
  List<BuyerEntity> getAllBuyer ();
  BuyerEntity getBuyerById(Integer buyerId) throws SQLException, NosuhBuyerExeption;
  void addBuyer (String name) throws SQLException, NosuhBuyerExeption;
  void deleteBuyer (Integer buyerId) throws SQLException, NosuhBuyerExeption;
  void updateBuyer (Integer buyerId, String name) throws SQLException, NosuhBuyerExeption;

}

