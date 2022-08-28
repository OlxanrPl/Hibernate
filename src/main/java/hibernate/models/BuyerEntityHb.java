package hibernate.models;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




public class BuyerEntityHb {
  private Integer id;
  private String name;
  private Set<ProductEntityHb> productEntityHbSet;

  public BuyerEntityHb() {
  }

  public Set<ProductEntityHb> getProductEntityHbSet() {
    return productEntityHbSet;
  }

  public void setProductEntityHbSet(Set<ProductEntityHb> productEntityHbSet) {
    this.productEntityHbSet = productEntityHbSet;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "BuyerEntityHb{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
