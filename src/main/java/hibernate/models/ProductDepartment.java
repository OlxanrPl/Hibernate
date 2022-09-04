package hibernate.models;

import java.util.Set;

public class ProductDepartment {

  private Integer depId;
  private String depName;
  private Set<ProductEntityHb> productEntityHbSet;

  public ProductDepartment() {
  }


  public Integer getDepId() {
    return depId;
  }

  public void setDepId(Integer depId) {
    this.depId = depId;
  }

  public String getDepName() {
    return depName;
  }

  public void setDepName(String depName) {
    this.depName = depName;
  }

  public Set<ProductEntityHb> getProductEntityHbSet() {
    return productEntityHbSet;
  }

  public void setProductEntityHbSet(Set<ProductEntityHb> productEntityHbSet) {
    this.productEntityHbSet = productEntityHbSet;
  }
}
