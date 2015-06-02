package carDealer.run;

import carDealer.dao.carDao.CarDAO;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        CarDAO carDAO = beanFactory.getBean(CarDAO.class);

        System.out.println(carDAO.getAllCars());

    }

 }