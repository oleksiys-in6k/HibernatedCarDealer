package carDealer.dao.carDao;

import carDealer.Entitys.Car;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by LEX on 01.06.2015.
 */
public interface CarDAO {
    public void addCar(Car car) throws SQLException;   //�������� ��������
    public void updateCar(Car car) throws SQLException;//�������� ��������
    public Car getCarById(Long id) throws SQLException;    //�������� �������� �� id
    public List getAllCars() throws SQLException;              //�������� ���� ���������
    public void deleteCar(Car car) throws SQLException;//������� ��������

}
