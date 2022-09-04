package hibernate.models;

public class Adress {

  private BuyerEntityHb buyerEntityHb;
  private Integer id;
  private String description;

  public Adress() {
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

  public BuyerEntityHb getBuyerEntityHb() {
    return buyerEntityHb;
  }

  public void setBuyerEntityHb(BuyerEntityHb buyerEntityHb) {
    this.buyerEntityHb = buyerEntityHb;
  }

  @Override
  public String toString() {
    return "Adress{" +
        "buyer name=" + buyerEntityHb.getName() +
        ", id=" + id +
        ", description='" + description + '\'' +
        '}';
  }
}
