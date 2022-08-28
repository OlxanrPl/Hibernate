package jpa.Dao;

import java.util.Optional;
import jpa.Entity.BuyerEntity;
import jpa.Entity.ProductEntity;
import java.sql.SQLException;
import java.util.List;
import jdbc.config.Dao.ProductDaoImpl.NosuhProductExeption;

public interface ProductDao {
  List<ProductEntity> getAllProduct ();
  Optional<BuyerEntity> getProductById(Integer ProductId) throws SQLException;
  void addProduct(BuyerEntity be);
  void deleteProduct (BuyerEntity be) throws SQLException;
  void updateProduct (BuyerEntity be) throws SQLException;

}
