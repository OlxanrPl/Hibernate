package jdbc.config.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ShoppingEntity {
  private Integer id;
  private Integer product_id;
  private Double quantity;
  private Integer buyer_id;

}
