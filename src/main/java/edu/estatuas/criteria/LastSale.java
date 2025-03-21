package edu.estatuas.criteria;

import java.util.List;

import edu.estatuas.item.Item;
import edu.estatuas.item.Offer;
import edu.estatuas.item.Sale;

public class LastSale implements Criteria {

    @Override
    public List<Offer> checkCriteria(Item item) {
        List<Offer> allSales = item.offers().stream()
            .filter(offer -> offer.getClass().equals(Sale.class))
            .toList();

        return allSales.isEmpty() ? List.of() : List.of(allSales.getLast());
    }
}
