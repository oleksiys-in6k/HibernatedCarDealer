package carDealer.entities;

/**
 * Created by employee on 6/3/15.
 */
public class BestSeller {

    private int seller_id;

    private double dealsCount;

    public BestSeller(Object[] tuple, String[] aliases) {
        seller_id = (int) tuple [1];
        dealsCount = (int) aliases [1];
    }
}
