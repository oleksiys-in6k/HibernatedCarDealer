package carDealer.run;

import carDealer.entities.Car;
import carDealer.dao.carDao.CarDAO;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        CarDAO carDAO = beanFactory.getBean(CarDAO.class);
        carDAO.addCar(new Car("BMW","X6",12300));
        carDAO.addCar(new Car("AUDI","R8",45600));

        System.out.println(carDAO.getAllCars());

    }

 }