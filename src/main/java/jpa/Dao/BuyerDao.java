package jpa.Dao;

import java.util.Optional;
import jpa.Entity.BuyerEntity;
import java.sql.SQLException;
import java.util.List;
import jdbc.config.Dao.BuyerDaoImpl.NosuhBuyerExeption;

public interface BuyerDao {
  List<BuyerEntity> getAllBuyer ();
  Optional<BuyerEntity> getBuyerById(Integer buyerId) throws SQLException, NosuhBuyerExeption, BuyerDaoImpl.NosuhBuyerExeption;
  void addBuyer(BuyerEntity bt) throws SQLException, BuyerDaoImpl.NosuhBuyerExeption;
  void deleteBuyer (BuyerEntity bt) throws SQLException, NosuhBuyerExeption, BuyerDaoImpl.NosuhBuyerExeption;
  void updateBuyer (BuyerEntity bt) throws SQLException, NosuhBuyerExeption, BuyerDaoImpl.NosuhBuyerExeption;

}

