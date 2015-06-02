package carDealer.Entitys;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "seller")
public class Seller {

    @Id @GeneratedValue
    private int seller_id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seller")
    private List<Deal> deal = new ArrayList<Deal>();

    public Seller(String name) {
        this.name = name;
    }

    public Seller() {
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seller seller = (Seller) o;

        return name.equals(seller.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }
}
