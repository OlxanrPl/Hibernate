package hibernate.models;

import java.util.Set;


public class ProductEntityHb {

  private Integer id;
  private String description;
  private Double price;
  private Double count;
  private Set<BuyerEntityHb> buyerEntityHbs;
  private ProductDepartment productDepartment;

  public ProductEntityHb() {
  }

  public ProductDepartment getProductDepartment() {
    return productDepartment;
  }

  public void setProductDepartment(ProductDepartment productDepartment) {
    this.productDepartment = productDepartment;
  }

  public Double getCount() {
    return count;
  }

  public void setCount(Double count) {
    this.count = count;
  }

  public Set<BuyerEntityHb> getBuyerEntityHbs() {
    return buyerEntityHbs;
  }

  public void setBuyerEntityHbs(Set<BuyerEntityHb> buyerEntityHbs) {
    this.buyerEntityHbs = buyerEntityHbs;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "ProductEntityHb{" +
        " productDepartment =" + productDepartment.getDepName() +
        "id=" + id +
        ", description='" + description + '\'' +
        ", price=" + price +
        ", count=" + count +
        '}';
  }
}
