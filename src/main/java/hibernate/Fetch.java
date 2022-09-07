package hibernate;

import hibernate.models.BuyerEntityHb;
import hibernate.models.ProductEntityHb;
import hibernate.services.SessionFactoryUtil;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;


public class Fetch {

  public static void main(String[] args) {
    try (Session session = SessionFactoryUtil.getSession()) {
      CriteriaBuilder builder = session.getCriteriaBuilder();
      /*
      CriteriaQuery<ProductEntityHb> criteria = builder.createQuery(ProductEntityHb.class);
      Root<ProductEntityHb> from = criteria.from(ProductEntityHb.class);
      criteria.select(from);
      criteria.where(builder.equal(from.get("description"), "Borgomy"));
      TypedQuery<ProductEntityHb> typed = session.createQuery(criteria);
      System.out.println(typed.getSingleResult());
      System.out.println("Borgomy print");
*/
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
      CriteriaQuery<BuyerEntityHb> crBuy = builder.createQuery(BuyerEntityHb.class);
      Root<BuyerEntityHb> fromBuyer = crBuy.from(BuyerEntityHb.class);
      List<BuyerEntityHb> lBuy;
      crBuy.select(fromBuyer).where(builder.equal(fromBuyer.join("productEntityHbSet").join("productDepartment").get("depName"),"Milk products"));
          /*.where(
          builder.equal(
              fromBuyer.get("productEntityHbSet").get("productDepartment").get("depName"),
              "Grocery"
          )
      );*/
      TypedQuery<BuyerEntityHb> typedGr = session.createQuery(crBuy);
      for (BuyerEntityHb by:typedGr.getResultList()){
        System.out.println(by.toString());
      }

    }

    System.out.println("success");
  }
}  