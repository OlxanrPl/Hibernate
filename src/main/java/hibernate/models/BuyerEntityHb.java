package hibernate.models;

import java.util.Set;


public class BuyerEntityHb {

  private Integer id;
  private String name;
  private Adress adress;
  private Set<ProductEntityHb> productEntityHbSet;

  public BuyerEntityHb() {
  }

  public Set<ProductEntityHb> getProductEntityHbSet() {
    return productEntityHbSet;
  }

  public void setProductEntityHbSet(Set<ProductEntityHb> productEntityHbSet) {
    this.productEntityHbSet = productEntityHbSet;
  }

  public Adress getAdress() {
    return adress;
  }

  public void setAdress(Adress adress) {
    this.adress = adress;
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
        ", Adress= " + adress.getDescription() +
        ", Products = " + productEntityHbSet +
        '}';
  }
}
