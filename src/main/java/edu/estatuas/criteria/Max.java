package edu.estatuas.criteria;

import java.util.List;
import java.util.Optional;

import edu.estatuas.item.Item;
import edu.estatuas.item.Offer;

public class Max implements Criteria{
    
    private Criteria criteria;
    private Criteria otherCriteria;

    public Max(Criteria criteria, Criteria othCriteria) {
        this.criteria = criteria;
        this.otherCriteria = othCriteria;
    }

    @Override
    public List<Offer> checkCriteria(Item item) {
        
        List<Offer> firstCriteriaOffers = criteria.checkCriteria(item);
        List<Offer> secondCriteriaOffers = otherCriteria.checkCriteria(item);

        Optional<Offer> max = firstCriteriaOffers.stream()
                .filter(secondCriteriaOffers::contains)
                .max(Offer::compareTo);

        return max.isPresent() ? List.of(max.get()) : List.of();
    }
}
