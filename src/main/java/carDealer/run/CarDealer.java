package carDealer.run;

import carDealer.entities.Car;
import carDealer.entities.Deal;
import carDealer.entities.Seller;
import carDealer.Period;
import carDealer.SearchingForTheBestSeller;
import carDealer.factory.FactoryCar;
import carDealer.factory.FactoryDeals;
import carDealer.factory.FactorySeller;

import java.sql.SQLException;
import java.util.List;

public class CarDealer {

    List<Car> cars;
    List<Seller> sellers;
    List<Deal> deals;

    public void execute() throws SQLException {

//        Car c1 = new Car("BMW", "xxx", 99);
//        FactoryCar.getInstanceCar().getCarDAO().addCar(c1);

        printAllSellers();

        printAllCars();

        printAllDeals();

//        initialization();
//        searchingBestSeller();

    }

    private static void printAllSellers() throws SQLException {
        List<Seller> sellers = FactorySeller.getInstanceSeller().getSellerDAO().getAllSellers();
        System.out.println("========All sellers=========");
        for (Seller seller : sellers) {
            System.out.println("SellerId : " + seller.getSeller_id() + "\t, Seller Name : " + seller.getName());
        }
    }

    private static void printAllDeals() throws SQLException {
        List<Deal> deals = FactoryDeals.getInstanceDeal().getDealDAO().getAllDeals();
        System.out.println("========All deals=========");
        for (Deal deal : deals) {
            System.out.println("DealId : " + deal.getDeal_id() + "\t, Seller Name : " + deal.getSeller().getName() + "\t,  Car : " + deal.getCar().getModel());
        }
    }

    private static void printAllCars() throws SQLException {
        List<Car> cars = FactoryCar.getInstanceCar().getCarDAO().getAllCars();
        System.out.println("========All cars=========");
        for (Car car : cars) {
            System.out.println("Brand : " + car.getBrand() + "\t, Model : " + car.getModel() + "\t,  Price : " + car.getPrice());
        }
    }

    private void searchingBestSeller() throws SQLException {

        Period period = new Period();

        Seller seller = getBestSellerEver(period);

        System.out.println("Best seller ever is " + seller.getName());
    }

    private Seller getBestSellerEver(Period period) {
        SearchingForTheBestSeller searchingForTheBestSeller = new SearchingForTheBestSeller(sellers, deals, period);
        return searchingForTheBestSeller.getBestSellerFromListSellers(sellers);
    }

    private void initialization() throws SQLException {
        cars = FactoryCar.getInstanceCar().getCarDAO().getAllCars();
        sellers = FactorySeller.getInstanceSeller().getSellerDAO().getAllSellers();
        deals = FactoryDeals.getInstanceDeal().getDealDAO().getAllDeals();
    }
}
