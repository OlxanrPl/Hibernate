package jdbc.config.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class ProductEntity {
  private Integer id;
  private String description;
  private Double price;


}
