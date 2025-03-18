package edu.estatuas.criteria;

import java.util.List;

import edu.estatuas.item.Item;
import edu.estatuas.item.Offer;
import edu.estatuas.item.Sale;

public class Sales implements Criteria {
    
    @Override
    public List<Offer> checkCriteria(Item item) {
        return item.offers().stream()
            .filter(sale -> sale.getClass().equals(Sale.class))
            .toList();
    }
}
