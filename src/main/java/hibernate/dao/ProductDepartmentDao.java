package hibernate.dao;

import hibernate.models.ProductDepartment;
import java.sql.SQLException;
import java.util.List;

public interface ProductDepartmentDao {

  List<ProductDepartment> getAllProduct();

  ProductDepartment getProductDepartmentById(Integer depId) throws SQLException;

  void addProductDepartment(ProductDepartment be);

  void deleteProductDepartment(ProductDepartment be) throws SQLException;

  void updateProductDepartment(ProductDepartment be) throws SQLException;

}
