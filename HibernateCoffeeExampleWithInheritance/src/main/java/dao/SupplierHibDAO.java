package dao;

import model.Supplier;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SupplierHibDAO {
    Session session;

    public List<Supplier> getAll() {
        List<Supplier> list = null;
        try {
            session = HibernateUtil.getSession();
            Query query = session.createQuery("from Supplier");
            list = query.list();
        }
        finally {
            session.close();
        }

        return list;
    }
}
