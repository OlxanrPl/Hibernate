package hibernate.dao;

import hibernate.models.ProductEntityHb;
import java.sql.SQLException;
import java.util.List;


public interface ProductDao {
  List<ProductEntityHb> getAllProduct ();
  ProductEntityHb getProductById(Integer ProductId) throws SQLException;
  void addProduct(ProductEntityHb be);
  void deleteProduct (ProductEntityHb be) throws SQLException;
  void updateProduct (ProductEntityHb be) throws SQLException;

}
