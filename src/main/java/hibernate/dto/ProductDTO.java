package hibernate.dto;

public class ProductDTO {
  public String buyerName;
  public String addressDescription;
  public String productDescription;
  public Double productCount;
  public Double productPrice;
  public String productDepartmentDepName;

  public ProductDTO(String buyerName, String addressDescription,
      String productDescription, Double productCount, Double productPrice,
      String productDepartmentDepName) {
    this.buyerName = buyerName;
    this.addressDescription = addressDescription;
    this.productDescription = productDescription;
    this.productCount = productCount;
    this.productPrice = productPrice;
    this.productDepartmentDepName = productDepartmentDepName;
  }

  @Override
  public String toString() {
    return "ProductDTO{" +
        "name='" + buyerName + '\'' +
        ", address='" + addressDescription + '\'' +
        ", product='" + productDescription + '\'' +
        ", count=" + productCount +
        ", price=" + productPrice +
        ", product department='" + productDepartmentDepName + '\'' +
        '}'+'\n';
  }
}
