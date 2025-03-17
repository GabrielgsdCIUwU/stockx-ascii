package edu.estatuas.criteria;

import java.util.List;

import edu.estatuas.item.Bid;
import edu.estatuas.item.Item;
import edu.estatuas.item.Offer;

public class Bids implements Criteria {
    @Override
    public List<Offer> checkCriteria(Item item) {
        return item.offers().stream()
            .filter(offer -> offer.getClass().equals(Bid.class))
            .toList();
    }
}
