package carDealer.dao.dealDAO;

import carDealer.Period;
import carDealer.entities.BestSeller;
import carDealer.entities.Deal;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.ResultTransformer;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Transactional
public class DealDAOImpl implements DealDAO {

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addDeal(Deal deal) throws SQLException {
        Session session = getSession();
        session.save(deal);
    }

    public void updateDeal(Deal deal) throws SQLException {
        Session session = getSession();
        session.update(deal);
    }

    public List <Deal>  getAllDeals() throws SQLException {
        Session session = getSession();
        return session.createCriteria(Deal.class).list();
    }

    public void deleteDeal(Deal deal) throws SQLException {
        Session session = getSession();
        session.delete(deal);
    }

    public Deal getDealById(Long id) throws SQLException {
        Session session = getSession();
        return (Deal) session.load(Deal.class, id);
    }


    public BestSeller getBestSeller(Period period) throws SQLException {
        Session session = getSession();
        SQLQuery query = session.createSQLQuery("SELECT seller_id, deals_count, seller_name, deals_count\n" +
                "from (SELECT deal.seller_id as seller_id, count(deal.seller_id) as deals_count\n" +
                "from deal\n" +
                "WHERE calendar BETWEEN '2015-12-31' and '2015-12-31' \n" +
                "GROUP BY deal.seller_id) Seller\n" +
                "ORDER BY deals_count DESC LIMIT 1;");
//        '2015-12-31'
//        query.setDate(0, period.getStart().getTime());
//        query.setDate(1,period.getEnd().getTime());
        System.out.println(query);

        query.setResultTransformer(new ResultTransformer() {
            public BestSeller transformTuple(Object[] tuple, String[] aliases) {
                BestSeller bestSeller = new BestSeller(tuple, aliases);

//                todo: transform to BestSeller
                return bestSeller;
            }

            public List transformList(List collection) {
                return collection;
            }
        });

//        BestSeller bestSeller = (BestSeller) query.uniqueResult();

        return bestSeller;
    }
}
