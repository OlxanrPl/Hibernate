package jpa.Entity;

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
public class ShoppingEntity {
  @Id
  @GeneratedValue
  private Integer id;
  private Integer product_id;
  private Double quantity;
  private Integer buyer_id;

}
