package edu.estatuas.item;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SneakerTest {

    @Test
    public void gettersAndSetters() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");

        int sale = 50;
        int ask = 25;
        int bid = 40;

        sneaker.setSale(sale);
        sneaker.setAsk(ask);
        sneaker.setBid(bid);

        assertEquals(sale, sneaker.getSale());
        assertEquals(ask, sneaker.getAsk());
        assertEquals(bid, sneaker.getBid());
    }
}
