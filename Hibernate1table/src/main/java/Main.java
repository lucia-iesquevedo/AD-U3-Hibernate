import model.Supplier;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {


       public static void main(final String[] args) throws Exception {

           SupplierHibDAO dao = new SupplierHibDAO();

           // Get all suppliers
           List<Supplier> list;
           list = dao.getAll();
           list.forEach((c) -> {
               System.out.println(c);
           });

           //Get supplier by id
           System.out.println("Supplier number 49: " + dao.getById(49));

           //Add new supplier
           Supplier s = new Supplier(2, "123-12 St.", "New York", "US");
           dao.add(s);
           System.out.println("Supplier added");

           // Update supplier
           s.setStreet("Main Street");
           dao.update(s);
           System.out.println("Supplier updated");

           // Delete supplier
           //dao.delete(s);
        }
}