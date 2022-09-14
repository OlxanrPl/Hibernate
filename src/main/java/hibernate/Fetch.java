package hibernate;

import hibernate.dao.ProductDaoImplHb;
import hibernate.services.SessionFactoryUtil;
import org.hibernate.Session;


public class Fetch {

  public static void main(String[] args) {
    ProductDaoImplHb pDaoImp = new ProductDaoImplHb();
    try (Session session = SessionFactoryUtil.getSession()) {
      String departmnt = "Milk products";
        System.out.println(pDaoImp.getDepartment(session, departmnt).toString());

    }


  }


}