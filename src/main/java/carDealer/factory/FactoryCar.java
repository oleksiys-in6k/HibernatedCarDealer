package carDealer.factory;

import carDealer.dao.carDao.CarDAO;
import carDealer.dao.carDao.CarDAOImpl;

/**
 * Created by LEX on 01.06.2015.
 */
public class FactoryCar {
    private static CarDAO carDAO = null;
    private static FactoryCar instanceCar = null;


    public static synchronized FactoryCar getInstanceCar(){
        if (instanceCar == null){
            instanceCar = new FactoryCar();
        }
        return instanceCar;
    }

    public CarDAO getCarDAO(){
        if (carDAO == null){
            carDAO = new CarDAOImpl();
        }
        return carDAO;
    }
}
