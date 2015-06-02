package carDealer.dao.dealDAO;

import carDealer.entities.Deal;

import java.sql.SQLException;
import java.util.List;


public interface DealDAO {
    public void addDeal(Deal deal) throws SQLException;
    public void updateDeal(Deal deal) throws SQLException;
    public List getAllDeals() throws SQLException;
    public void deleteDeal(Deal deal) throws SQLException;
    public Deal getDealById(Long id) throws SQLException;    //получить стедента по id

}
