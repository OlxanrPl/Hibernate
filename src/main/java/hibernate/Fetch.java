package hibernate;

import hibernate.dao.BuyerDaoImplHb;
import hibernate.models.BuyerEntityHb;
import java.util.List;


public class Fetch {

  public static void main(String[] args) {
    BuyerDaoImplHb bd = new BuyerDaoImplHb();

    List<BuyerEntityHb> listB = bd.getAllBuyer();
    for (BuyerEntityHb Buyers : listB) {
      System.out.println(Buyers);
      }

    System.out.println("success");
  }
}  