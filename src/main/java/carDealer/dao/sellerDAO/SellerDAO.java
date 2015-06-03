package carDealer.dao.sellerDAO;

import carDealer.entities.Seller;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by LEX on 01.06.2015.
 */
public interface SellerDAO {
    void addSeller(Seller seller) throws SQLException;
    void updateSeller(Seller seller) throws SQLException;
    Seller getSellerById(Long id) throws SQLException;
    List getAllSellers() throws SQLException;
    void deleteSeller(Seller seller) throws SQLException;

}
