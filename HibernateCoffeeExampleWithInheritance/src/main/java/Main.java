import dao.CoffeeHibDAO;
import dao.ProductHibDAO;
import dao.SupplierHibDAO;
import model.Coffee;
import model.Product;
import model.Supplier;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {


       public static void main(final String[] args) throws Exception {

           System.setProperty("log4j.configurationFile", "log4j2.xml");
           LoggerFactory.getLogger(Main.class.getName()).error("hola");

           ProductHibDAO pdao = new ProductHibDAO();
           List<Product> listProducts;
           listProducts = pdao.getAll();
           System.out.println("List of products: ");
           listProducts.forEach((c) -> {
               System.out.println(c);
           });


           CoffeeHibDAO cdao = new CoffeeHibDAO();
           List<Coffee> listCoffees;
           listCoffees = cdao.getAll();
           System.out.println("List of coffees: ");
           listCoffees.forEach((c) -> {
               System.out.println(c);
           });

           SupplierHibDAO sdao = new SupplierHibDAO();
           List<Supplier> listSuppliers;
           listSuppliers = sdao.getAll();
           System.out.println("List of Suppliers: ");
           listSuppliers.forEach((c) -> {
               System.out.println(c);
           });

        }
}