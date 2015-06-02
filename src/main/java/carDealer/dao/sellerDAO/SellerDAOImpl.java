package carDealer.dao.sellerDAO;

import carDealer.entities.Seller;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

public class SellerDAOImpl implements SellerDAO {

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addSeller(Seller seller) throws SQLException {
        Session session = getSession();
        session.save(seller);
    }

    public void updateSeller(Seller seller) throws SQLException {
        Session session = getSession();
        session.update(seller);
    }

    public Seller getSellerById(Long id) throws SQLException {
        Session session = getSession();
        return (Seller) session.load(Seller.class, id);
    }

    public List getAllSellers() throws SQLException {
        Session session = getSession();
        return session.createCriteria(Seller.class).list();
    }

    public void deleteSeller(Seller seller) throws SQLException {
        Session session = getSession();
        session.delete(seller);
    }
}
