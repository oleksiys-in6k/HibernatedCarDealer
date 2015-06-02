package carDealer.factory;

import carDealer.dao.dealDAO.DealDAO;
import carDealer.dao.dealDAO.DealDAOImpl;

public class FactoryDeals {
    private static DealDAO dealDAO = null;
    private static FactoryDeals instanceDeal = null;


    public static synchronized FactoryDeals getInstanceDeal(){
        if (instanceDeal == null){
            instanceDeal = new FactoryDeals();
        }
        return instanceDeal;
    }

    public DealDAO getDealDAO(){
        if (dealDAO == null){
            dealDAO = new DealDAOImpl();
        }
        return dealDAO;
    }
}
