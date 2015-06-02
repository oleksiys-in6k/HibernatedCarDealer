package carDealer.dao.carDao;

import carDealer.Entitys.Car;
import carDealer.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LEX on 01.06.2015.
 */
public class CarDAOImpl implements CarDAO {
    public void addCar(Car car) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(car);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("I/O Error from CarDAOImpl");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateCar(Car car) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
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

    public Car getCarById(Long id) throws SQLException {
        Session session = null;
        Car car = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
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

    public List getAllCars() throws SQLException {
        Session session = null;
        List<Car> cars = new ArrayList<Car>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            cars = session.createCriteria(Car.class).list();
        } catch (Exception e) {
            System.out.println("I/O Error from getAllCars");
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return cars;
    }

    public void deleteCar(Car car) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
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
