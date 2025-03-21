package edu.estatuas.criteria;

import java.util.List;
import java.util.Optional;

import edu.estatuas.item.Ask;
import edu.estatuas.item.Item;
import edu.estatuas.item.Offer;

public class MinAsk implements Criteria {
    
    @Override
    public List<Offer> checkCriteria(Item item) {
        Optional<Offer> minOffer = item.offers().stream()
            .filter(offer -> offer.getClass().equals(Ask.class))
            .min(Offer::compareTo);

        return minOffer.isPresent() ? List.of(minOffer.get()) : List.of();
    }
}
