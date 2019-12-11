package dao;

import model.Coffee;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CoffeeHibDAO {
    Session session;

    public List<Coffee> getAll() {
        List<Coffee> list = null;
        try {
            session = HibernateUtil.getSession();
            Query query = session.createQuery("from Coffee");
            list = query.list();
        }
        finally {
            if (session != null)  session.close();
        }

        return list;
    }
}
