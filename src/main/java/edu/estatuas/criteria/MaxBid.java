package edu.estatuas.criteria;

import java.util.List;
import java.util.Optional;

import edu.estatuas.item.Item;
import edu.estatuas.item.Offer;

public class MaxBid implements Criteria {
    
    @Override
    public List<Offer> checkCriteria(Item item) {
        Optional<Offer> maxOffer = item.offers().stream()
            .max(Offer::compareTo);

        return maxOffer.isPresent() ? List.of(maxOffer.get()) : List.of();
    }
}
