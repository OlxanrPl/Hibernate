package hibernate.dao;

import hibernate.models.Adress;
import hibernate.models.BuyerEntityHb;
import java.sql.SQLException;
import java.util.List;

public interface AdressDao {

  List<Adress> getAllAdress();

  BuyerEntityHb getBuyerById(Integer id) throws SQLException;

  Adress getAdress(Integer id) throws SQLException;

  void addAdress(Adress bt) throws SQLException;

  void deleteAdress(Adress bt) throws SQLException;

  void updateAdress(Adress bt) throws SQLException;

}
