package edu.estatuas.criteria;

import java.util.List;

import edu.estatuas.item.Item;
import edu.estatuas.item.Offer;

public class LastSale implements Criteria {

    @Override
    public List<Offer> checkCriteria(Item item) {
        return item.offers().isEmpty() ? List.of() : List.of(item.offers().getLast());
    }
}
