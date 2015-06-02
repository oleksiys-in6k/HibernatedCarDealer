package carDealer.entities;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "deal")
public class Deal {

    @Id
    @GeneratedValue
    private int deal_id;

    private Calendar calendar = Calendar.getInstance();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id")
    private Seller seller;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;

    public Deal(Seller seller, Car car, Calendar calendar) {
        this.seller = seller;
        this.car = car;
        this.calendar.setTime(calendar.getTime());
    }

    public Deal() {
    }

    public Car getCar() {
        return car;
    }

    public Seller getSeller() {
        return seller;
    }

    public int getDeal_id() {
        return deal_id;
    }

    public void setDeal_id(int deal_id) {
        this.deal_id = deal_id;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public boolean wasSoldBy(Seller seller) {
        return this.seller.equals(seller);
    }

}
