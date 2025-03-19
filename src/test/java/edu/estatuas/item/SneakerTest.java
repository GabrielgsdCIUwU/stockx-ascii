package edu.estatuas.item;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SneakerTest {

    @Test
    public void addOffer() {
        String size = "19";
        int bidValue = 255;

        Bid bid = new Bid(size, bidValue);

        assertEquals(size, bid.size());
        assertEquals(bidValue, bid.value());
    }
}
