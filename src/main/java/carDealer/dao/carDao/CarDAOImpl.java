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

    public void addCar(Car car) throws SQLException {
            Session session = getSession();
            session.save(car);
    }

    public void updateCar(Car car) throws SQLException {
        Session session = null;
        try {

            session = getSession();


            session.update(car);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("I/O Error from UpdateCar");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Car getCarById(Long id) throws SQLException {
        Session session = null;
        Car car = null;
        try {
            session = getSession();
            car = (Car) session.load(Car.class, id);
        } catch (Exception e) {
            System.out.println("I/O Error from getCarById");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return car;
    }

    @SuppressWarnings("unchecked")
    public List<Car> getAllCars() throws SQLException {
        Session session = getSession();
        return session.createCriteria(Car.class).list();
    }

    public void deleteCar(Car car) throws SQLException {
        Session session = null;
        try {
            session = getSession();
            session.delete(car);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("I/O Error from deleteCar");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }
}
