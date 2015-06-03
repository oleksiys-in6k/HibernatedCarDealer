package carDealer.run;

import carDealer.Period;
import carDealer.dao.dealDAO.DealDAO;
import carDealer.entities.BestSeller;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        DealDAO dealDAO = beanFactory.getBean(DealDAO.class);

        Period period = new Period();

        BestSeller bestSeller = dealDAO.getBestSeller(period);


//        System.out.println("Best seller  is  " + list.get(0)[0]);
//        sellerDAO.getSellerById((Long) list.get(0)[0]);

//        System.out.println("Best seller id is  " + list.get(0)[0]);
//        System.out.println("Best seller's deals count " + list.get(0)[1]);



//        for(Object deal : carDAO.getAllCars())
//            System.out.println(deal.toString());


    }
 }