package edu.estatuas.criteria;

import java.util.List;

import edu.estatuas.item.Ask;
import edu.estatuas.item.Item;
import edu.estatuas.item.Offer;

public class Asks implements Criteria {
    
    @Override
    public List<Offer> checkCriteria(Item item) {
        return item.offers().stream()
            .filter(offer -> offer.getClass().equals(Ask.class))
            .toList();
    }
}
