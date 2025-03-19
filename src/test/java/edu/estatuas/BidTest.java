package edu.estatuas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.estatuas.item.Bid;

public class BidTest {
    
    @Test
    public void createBid() {
        String size = "18";
        int bidValue = 200;

        Bid bid = new Bid(size, bidValue);

        assertEquals(size, bid.size());
        assertEquals(bidValue, bid.value());
    }
}
