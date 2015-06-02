package carDealer.dao.sellerDAO;

import carDealer.entities.Seller;
import carDealer.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerDAOImpl implements SellerDAO {

    public void addSeller(Seller seller) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(seller);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("I/O Error from addSeller");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateSeller(Seller seller) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(seller);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("I/O Error from updateSeller");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Seller getSellerById(Long id) throws SQLException {
        Session session = null;
        Seller seller = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            seller = (Seller) session.load(Seller.class, id);
        } catch (Exception e) {
            System.out.println("I/O Error from getSellerById");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return seller;
    }

    public List getAllSellers() throws SQLException {
        Session session = null;
        List<Seller> sellers = new ArrayList<Seller>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            sellers = session.createCriteria(Seller.class).list();
        } catch (Exception e) {
            System.out.println("I/O Error from getAllSellers");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return sellers;
    }

    public void deleteSeller(Seller seller) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(seller);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("I/O Error from deleteSeller");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
