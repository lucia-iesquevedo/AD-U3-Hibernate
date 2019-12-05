import model.Supplier;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SupplierHibDAO {
    Session session;

    public List<Supplier> getAll() {
        List<Supplier> list = null;
        session = HibernateUtil.getSession();
        Query query = session.createQuery("from Supplier");
        list = query.list();
        session.close();
        return list;
    }

    public Supplier getById(int sid) {
       session = HibernateUtil.getSession();
        // con load es LAZY, con get EAGER
        Supplier supp = session.get(Supplier.class, sid);
        session.close();
        return supp;
    }

    public void add(Supplier supp) {
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.save(supp);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }



    public void delete(Supplier supp) {
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.delete(supp);
            transaction.commit();

        } catch (ConstraintViolationException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            session.close();
        }

    }

    public void update(Supplier supp) {
        Transaction transaction = null;
        try {
            // Open session
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.update(supp);
            transaction.commit();


        } catch (ConstraintViolationException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            session.close();
        }
    }
}
