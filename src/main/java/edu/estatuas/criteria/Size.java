package edu.estatuas.criteria;

import java.util.List;

import edu.estatuas.item.Item;
import edu.estatuas.item.Offer;

public class Size implements Criteria {

    private String size;

    public Size(String size) {
        this.size = size;
    }

    @Override
    public List<Offer> checkCriteria(Item item) {
        return item.offers().stream()
            .filter(offer -> offer.size().equals(size)).toList();
    }
}
