package carDealer.dao.carDao;

import carDealer.Entitys.Car;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by LEX on 01.06.2015.
 */
public interface CarDAO {
    public void addCar(Car car) throws SQLException;   //добавить студента
    public void updateCar(Car car) throws SQLException;//обновить студента
    public Car getCarById(Long id) throws SQLException;    //получить стедента по id
    public List getAllCars() throws SQLException;              //получить всех студентов
    public void deleteCar(Car car) throws SQLException;//удалить студента

}
