package carDealer.dao.carDao;

import carDealer.entities.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Transactional
public class CarDAOImpl implements CarDAO {

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addCar(Car car) throws SQLException {
        Session session = getSession();
        session.save(car);
    }

    public void updateCar(Car car) throws SQLException {
        Session session = getSession();
        session.update(car);
    }

    public Car getCarById(Long id) throws SQLException {
        Session session = getSession();
        return (Car) session.load(Car.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Car> getAllCars() throws SQLException {
        Session session = getSession();
        return session.createCriteria(Car.class).list();
    }

    public void deleteCar(Car car) throws SQLException {
        Session session = getSession();
        session.delete(car);
    }
}
