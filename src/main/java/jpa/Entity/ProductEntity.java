package jpa.Entity;

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

@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "product")
@NoArgsConstructor
@Entity
public class ProductEntity {

  public ProductEntity(String description, Double price) {
    this.description = description;
    this.price = price;
  }

  @Id
  @GeneratedValue
  private Integer id;
  @Column
  private String description;
  @Column
  private Double price;


}
