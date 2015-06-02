package carDealer;

import carDealer.entities.Deal;
import carDealer.entities.Seller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchingForTheBestSeller {

    private List <Deal> deals = new ArrayList<Deal>();
    private List <Seller> sellers = new ArrayList<Seller>();
    private Period period;

    public SearchingForTheBestSeller(List<Seller> sellers, List<Deal> deals, Period period) {
        this.sellers = sellers;
        this.deals = deals;
        this.period = period;
    }

    public Seller getBestSellerFromListSellers(List<Seller> sellers) {
        Seller bestSellerEver = null;
        int maxCountOfSales = 0;
        int countOfSalesForCurrentSeller;

        for (Seller seller : sellers) {
            countOfSalesForCurrentSeller = getCountOfDealsInCurrentSellerInPeriod(seller, period);
            if ( countOfSalesForCurrentSeller > maxCountOfSales ) {
                bestSellerEver = seller;
                maxCountOfSales = countOfSalesForCurrentSeller;
            }
        }

        return bestSellerEver;
    }

    private int getCountOfDealsInCurrentSellerInPeriod(Seller seller, Period period) {
        int countOfDeals = 0;
        for (Deal deal : deals) {
            Date saleDate = deal.getCalendar().getTime();
            if (period.includes(saleDate) && deal.wasSoldBy(seller)) {
                countOfDeals++;
            }
        }

        return countOfDeals;
    }

}
