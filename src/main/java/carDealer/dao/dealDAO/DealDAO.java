package carDealer.dao.dealDAO;

import carDealer.Period;
import carDealer.entities.BestSeller;
import carDealer.entities.Deal;

import java.sql.SQLException;
import java.util.List;


public interface DealDAO {
    void addDeal(Deal deal) throws SQLException;
    void updateDeal(Deal deal) throws SQLException;
    List getAllDeals() throws SQLException;
    void deleteDeal(Deal deal) throws SQLException;
    Deal getDealById(Long id) throws SQLException;
    BestSeller getBestSeller(Period period) throws SQLException;


}
