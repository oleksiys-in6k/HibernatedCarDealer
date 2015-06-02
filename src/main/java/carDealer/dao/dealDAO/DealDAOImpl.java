package carDealer.dao.dealDAO;

import carDealer.entities.Deal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Transactional
public class DealDAOImpl implements DealDAO {

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addDeal(Deal deal) throws SQLException {
        Session session = getSession();
        session.save(deal);
    }

    public void updateDeal(Deal deal) throws SQLException {
        Session session = getSession();
        session.update(deal);
    }

    public List <Deal>  getAllDeals() throws SQLException {
        Session session = getSession();
        return session.createCriteria(Deal.class).list();
    }

    public void deleteDeal(Deal deal) throws SQLException {
        Session session = getSession();
        session.delete(deal);
    }

    public Deal getDealById(Long id) throws SQLException {
        Session session = getSession();
        return (Deal) session.load(Deal.class, id);
    }
}
