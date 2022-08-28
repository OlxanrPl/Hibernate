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
@Entity
@Table(name = "buyer")
@NoArgsConstructor
public class BuyerEntity {

  public BuyerEntity(String name) {
    this.name = name;
  }

  @Id
  @GeneratedValue
  private Integer id;
  @Column
  private String name;

}
