package jdbc.config.Dao;

import java.sql.SQLException;
import java.util.List;
import jdbc.config.Dao.ProductDaoImpl.NosuhProductExeption;
import jdbc.config.Entity.ProductEntity;

public interface ProductDao {
  List<ProductEntity> getAllProduct ();
  ProductEntity getProductById(Integer ProductId) throws SQLException, NosuhProductExeption;
  void addProduct (String description, Double price) throws SQLException, NosuhProductExeption;
  void deleteProduct (Integer ProductId) throws SQLException, NosuhProductExeption;
  void updateProduct (Integer ProductId, String description, Double price) throws SQLException, NosuhProductExeption;

}
