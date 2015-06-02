package carDealer.run;

import carDealer.Period;
import carDealer.SearchingForTheBestSeller;
import carDealer.entities.Deal;
import carDealer.entities.Seller;

import java.sql.SQLException;
import java.util.List;

public class CarDealer {

    List<Seller> sellers;
    List<Deal> deals;

    private void searchingBestSeller() throws SQLException {

        Period period = new Period();

        Seller seller = getBestSellerEver(period);

        System.out.println("Best seller ever is " + seller.getName());
    }

    private Seller getBestSellerEver(Period period) {
        SearchingForTheBestSeller searchingForTheBestSeller = new SearchingForTheBestSeller(sellers, deals, period);
        return searchingForTheBestSeller.getBestSellerFromListSellers(sellers);
    }

}
