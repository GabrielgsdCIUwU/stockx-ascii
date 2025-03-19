package edu.estatuas.criteria;

import java.util.List;
import java.util.Optional;

import edu.estatuas.item.Item;
import edu.estatuas.item.Offer;

public class Min implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public Min(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Offer> checkCriteria(Item item) {
        
        List<Offer> firstCriteriaOffers = criteria.checkCriteria(item);
        List<Offer> secondCriteriaOffers = otherCriteria.checkCriteria(item);

        Optional<Offer> min = firstCriteriaOffers.stream()
            .filter(secondCriteriaOffers::contains)
            .min(Offer::compareTo);

        return min.isPresent() ? List.of(min.get()) : List.of();
    }
}
