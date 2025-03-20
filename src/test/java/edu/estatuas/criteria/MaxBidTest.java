package edu.estatuas.criteria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import edu.estatuas.item.Ask;
import edu.estatuas.item.Bid;
import edu.estatuas.item.Offer;
import edu.estatuas.item.Sneaker;

public class MaxBidTest {
    
    @Test
    public void getMaxbid() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");
        sneaker.add(new Bid("6", 200));
        sneaker.add(new Bid("9.5", 179));
        sneaker.add(new Bid("13", 338));
        sneaker.add(new Bid("9.5", 480));

        Criteria maxBid = new MaxBid();
        List<Offer> maxBidOffer = maxBid.checkCriteria(sneaker);

        assertEquals(1, maxBidOffer.size());
        assertEquals(480, maxBidOffer.get(0).value());
        assertEquals("9.5", maxBidOffer.get(0).size());
    }

    @Test
    public void getMaxBidWithAsk() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");
        sneaker.add(new Bid("6", 200));
        sneaker.add(new Bid("9.5", 179));
        sneaker.add(new Ask("8", 50));
        sneaker.add(new Ask("12", 200));

        Criteria maxBid = new MaxBid();
        List<Offer> maxBidOffer = maxBid.checkCriteria(sneaker);

        assertTrue(maxBidOffer.stream().allMatch(Bid.class::isInstance));
    } 

    @Test
    public void getMaxBidEmpty() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");

        Criteria maxBid = new MaxBid();
        List<Offer> maxBidOffer = maxBid.checkCriteria(sneaker);

        assertEquals(0, maxBidOffer.size());
    }
}
