package carDealer;

import carDealer.Entitys.Car;
import carDealer.Entitys.Deal;
import carDealer.Entitys.Seller;
import carDealer.factory.FactoryCar;
import carDealer.factory.FactoryDeals;
import carDealer.factory.FactorySeller;

import java.sql.SQLException;
import java.util.List;

public class Run {

    List<Deal> deals;
    List<Car> cars;
    List<Seller> sellers;

    public static void main(String[] args) throws SQLException {

//        Car c1 = new Car("BMW", "xxx", 99);
//        FactoryCar.getInstanceCar().getCarDAO().addCar(c1);
//
//        Seller s1 = new Seller("seller1");
//        FactorySeller.getInstanceSeller().getSellerDAO().addSeller(s1);
//
//        Deal deal1 = new Deal(s1,c1, Calendar.getInstance());
//        FactoryDeals.getInstanceDeal().getDealDAO().addDeal(deal1);


        printAllSellers();

        printAllCars();

        printAllDeals();

//        new Run().searchingBestSeller();
    }

    private static void printAllSellers() throws SQLException {
        List<Seller> sellers = FactorySeller.getInstanceSeller().getSellerDAO().getAllSellers();
        System.out.println("========All deals=========");
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

    private void searchingBestSeller() {
        initialization();
        Period period = new Period();
        SearchingForTheBestSeller searchingForTheBestSeller = new SearchingForTheBestSeller(sellers, deals, period);
        Seller seller = searchingForTheBestSeller.getBestSellerFromListSellers(sellers);
        System.out.println("Best seller ever is " + seller.getName());
    }

    public void initialization() {
        InputData inputData = new InputData();
        cars = inputData.getListOfCar();
        sellers = inputData.getListOfSeller();
        deals = inputData.getDeals();
    }
}