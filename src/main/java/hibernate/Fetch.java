package hibernate;

import hibernate.models.BuyerEntityHb;
import hibernate.models.ProductEntityHb;
import hibernate.services.SessionFactoryUtil;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Root;
import org.hibernate.Session;


public class Fetch {

  public static void main(String[] args) {
    try (Session session = SessionFactoryUtil.getSession()) {
      CriteriaBuilder builder = session.getCriteriaBuilder();

      CriteriaQuery<ProductEntityHb> criteria = builder.createQuery(ProductEntityHb.class);
      Root<ProductEntityHb> from = criteria.from(ProductEntityHb.class);

     from.join("buyerEntityHbs");
      criteria.select(from);
      criteria.where(builder.equal(from.get("productDepartment").get("depName"), "Grocery"));
      TypedQuery<ProductEntityHb> typed = session.createQuery(criteria);
      System.out.println("Grocery print");
      List<ProductEntityHb> products = typed.getResultList();
      for (ProductEntityHb by:products){
        List<BuyerEntityHb> buyers = by.getBuyerEntityHbs().stream().toList();
        System.out.println("Buyers detail:::::::::::::");
        for (BuyerEntityHb byr:buyers){
          System.out.println(byr.getName()+"\t"+byr.getAdress().getDescription()+"\t"+
              by.getDescription()+"\t"+by.getCount()+"\t"+by.getPrice()+"\t"+
              by.getProductDepartment().getDepName());

        }

      }


/*
*   Criteria c = getSession()
      .createCriteria(YourEntity.class)
      .createCriteria("someMember", "s")
      .add(Restrictions.eq("name", someArgument));  // checks YourEntity.someMember.name
* */
      /*
      CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> employee = query.from(Employee.class);
        ListJoin<Employee, Task> tasks = employee.join(Employee_.tasks);
        query.select(employee)
             .where(cb.equal(tasks.get(Task_.supervisor), "Denise"))
             .distinct(true);
        TypedQuery<Employee> typedQuery = em.createQuery(query);
        typedQuery.getResultList().forEach(System.out::println);
        */
    //  Buters_category_product(session, builder);

    }

    System.out.println("success");
  }

  private static void Buters_category_product(Session session, CriteriaBuilder builder) {
    CriteriaQuery<BuyerEntityHb> crBuy = builder.createQuery(BuyerEntityHb.class);
    Root<BuyerEntityHb> fromBuyer = crBuy.from(BuyerEntityHb.class);
    List<BuyerEntityHb> lBuy;
    crBuy.select(fromBuyer).where(
        builder.equal(fromBuyer.join("productEntityHbSet").join("productDepartment").get("depName"),"Milk products"));

    TypedQuery<BuyerEntityHb> typedGr = session.createQuery(crBuy);
    for (BuyerEntityHb by:typedGr.getResultList()){
      System.out.println(by.toString());
    }
  }
}  