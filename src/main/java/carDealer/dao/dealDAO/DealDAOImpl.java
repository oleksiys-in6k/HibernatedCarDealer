package carDealer.dao.dealDAO;

import carDealer.entities.Deal;
import carDealer.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LEX on 01.06.2015.
 */
public class DealDAOImpl implements DealDAO {

    public void addDeal(Deal deal) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(deal);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("I/O Error from addDeal");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateDeal(Deal deal) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(deal);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("I/O Error from updateDeal");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List <Deal>  getAllDeals() throws SQLException {
        Session session = null;
        List<Deal> deals = new ArrayList<Deal>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            deals = session.createCriteria(Deal.class).list();
        } catch (Exception e) {
            System.out.println("I/O Error from getAllDeals");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return deals;
    }

    public void deleteDeal(Deal deal) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(deal);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("I/O Error from deleteDeal");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Deal getDealById(Long id) throws SQLException {
        Session session = null;
        Deal deal = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            deal = (Deal) session.load(Deal.class, id);
        } catch (Exception e) {
            System.out.println("I/O Error from getDealById");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return deal;
    }
}
