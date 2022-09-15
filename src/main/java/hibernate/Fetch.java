package hibernate;

import hibernate.dao.BuyerDaoImplHb;
import hibernate.dao.ProductDaoImplHb;
import hibernate.dto.SumProductDTO;
import hibernate.services.SessionFactoryUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;


public class Fetch {

  public static void main(String[] args) {

    ProductDaoImplHb pDp = new ProductDaoImplHb();
    System.out.println(pDp.getSumAllProduct().toString());


    //  BuyerDaoImplHb buyD = new BuyerDaoImplHb(); System.out.println(buyD.getAllBuyer().toString());

   /*  ProductDaoImplHb pDaoImp = new ProductDaoImplHb();
   try (Session session = SessionFactoryUtil.getSession()) {
      String departmnt = "Milk products";
       System.out.println(pDaoImp.getDepartment(session, departmnt).toString());

    }*/


  }


}