package dao;

import model.Product;
import model.Supplier;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ProductHibDAO {
    Session session;

    public List<Product> getAll() {
        List<Product> list = null;
        try {
            session = HibernateUtil.getSession();
            Query query = session.createQuery("from Product");
            list = query.list();
        }
        finally {
            if (session != null)  session.close();
        }

        return list;
    }
}
