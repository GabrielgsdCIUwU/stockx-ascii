package edu.estatuas.criteria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.estatuas.item.Ask;
import edu.estatuas.item.Bid;
import edu.estatuas.item.Offer;
import edu.estatuas.item.Sneaker;

public class MaxTest {
    private Sneaker sneaker;
    @Before
    public void setup() {
        sneaker = new Sneaker("555088-105", "Jordan 1");  
    }
    
    @Test
    public void checkCriteriaMax() {
        sneaker.add(new Bid("6", 200));
        sneaker.add(new Bid("9.5", 479));
        sneaker.add(new Bid("13", 338));
        sneaker.add(new Bid("9.5", 480));

        Criteria size = new Size("9.5");
        Criteria bids = new Bids();
        Criteria sizeMaxBid = new Max(size, bids);
        List<Offer> sizeBid = sizeMaxBid.checkCriteria(sneaker);

        assertEquals(1, sizeBid.size());
        assertTrue(sizeBid.stream().allMatch(Bid.class::isInstance));
        assertEquals("9.5", sizeBid.get(0).size());
        assertEquals(480, sizeBid.get(0).value());
    }

    @Test
    public void checkCriteriaMaxWithAsk() {
        sneaker.add(new Ask("9.5", 333));
        sneaker.add(new Ask("9.5", 500));
        sneaker.add(new Bid("13", 338));
        sneaker.add(new Bid("9.5", 480));
        sneaker.add(new Bid("9.5", 359));

        Criteria size = new Size("9.5");
        Criteria bids = new Bids();
        Criteria sizeMaxBid = new Max(size, bids);
        List<Offer> sizeBid = sizeMaxBid.checkCriteria(sneaker);

        assertEquals(1, sizeBid.size());
        assertTrue(sizeBid.stream().allMatch(Bid.class::isInstance));
        assertEquals("9.5", sizeBid.get(0).size());
        assertEquals(480, sizeBid.get(0).value());
    }

    @Test
    public void checkCriteriaMaxEmpty() {

        Criteria size = new Size("9.5");
        Criteria bids = new Bids();
        Criteria sizeMaxBid = new Max(size, bids);
        List<Offer> sizeBid = sizeMaxBid.checkCriteria(sneaker);

        assertTrue(sizeBid.isEmpty());
    }
}
