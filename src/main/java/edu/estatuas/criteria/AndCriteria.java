package edu.estatuas.criteria;

import java.util.List;

import edu.estatuas.item.Item;
import edu.estatuas.item.Offer;

public class AndCriteria implements Criteria{
    
    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Offer> checkCriteria(Item item) {
        List<Offer> firstCriteriaOffers = criteria.checkCriteria(item);
        List<Offer> secondCriteriaOffers = otherCriteria.checkCriteria(item);

        return firstCriteriaOffers.stream()
            .filter(secondCriteriaOffers::contains)
            .toList();
    }
}
