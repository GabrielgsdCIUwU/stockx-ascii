package edu.estatuas.criteria;

import java.util.List;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import edu.estatuas.item.Ask;
import edu.estatuas.item.Bid;
import edu.estatuas.item.Offer;
import edu.estatuas.item.Sneaker;

public class BidsTest {
    
    @Test
    public void checkCriteriaBids() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");
        sneaker.add(new Bid("8", 250));
        sneaker.add(new Bid("12", 800));
        sneaker.add(new Bid("5", 120));

        Criteria bids = new Bids();
        List<Offer> criteriaBids = bids.checkCriteria(sneaker);

        assertTrue(criteriaBids.stream().allMatch(Bid.class::isInstance));
    }

    public void checkCriteriaBidsAsks() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");
        sneaker.add(new Bid("8", 250));
        sneaker.add(new Bid("12", 800));
        sneaker.add(new Ask("15", 288));
        sneaker.add(new Bid("5", 120));
        sneaker.add(new Ask("12", 400));

        Criteria bids = new Bids();
        List<Offer> criteriaBids = bids.checkCriteria(sneaker);

        assertTrue(criteriaBids.stream().allMatch(Bid.class::isInstance));
    }

    public void checkCriteriaBidsEmpty() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");

        Criteria bids = new Bids();
        List<Offer> criteriaBids = bids.checkCriteria(sneaker);

        assertTrue(criteriaBids.isEmpty());
    }
}
