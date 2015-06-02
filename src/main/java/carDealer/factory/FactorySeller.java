package carDealer.factory;

import carDealer.dao.sellerDAO.SellerDAO;
import carDealer.dao.sellerDAO.SellerDAOImpl;

public class FactorySeller {
    private static SellerDAO sellerDAO = null;
    private static FactorySeller instanceSeller = null;


    public static synchronized FactorySeller getInstanceSeller(){
        if (instanceSeller == null){
            instanceSeller = new FactorySeller();
        }
        return instanceSeller;
    }

    public SellerDAO getSellerDAO(){
        if (sellerDAO == null){
            sellerDAO = new SellerDAOImpl();
        }
        return sellerDAO;
    }
}
