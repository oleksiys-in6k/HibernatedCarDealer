package carDealer.dao.dealDAO;

import carDealer.Entitys.Deal;

import java.sql.SQLException;
import java.util.List;


public interface DealDAO {
    public void addDeal(Deal deal) throws SQLException;
    public void updateDeal(Deal deal) throws SQLException;
    public List getAllDeals() throws SQLException;
    public void deleteDeal(Deal deal) throws SQLException;

}
