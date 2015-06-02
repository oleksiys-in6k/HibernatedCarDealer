package carDealer.dao.sellerDAO;

import carDealer.Entitys.Seller;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by LEX on 01.06.2015.
 */
public interface SellerDAO {
    public void addSeller(Seller seller) throws SQLException;   //добавить студента
    public void updateSeller(Seller seller) throws SQLException;//обновить студента
    public Seller getSellerById(Long id) throws SQLException;    //получить стедента по id
    public List getAllSellers() throws SQLException;              //получить всех студентов
    public void deleteSeller(Seller seller) throws SQLException;//удалить студента

}
