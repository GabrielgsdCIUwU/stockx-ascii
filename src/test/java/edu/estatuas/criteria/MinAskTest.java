package edu.estatuas.criteria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import edu.estatuas.item.Ask;
import edu.estatuas.item.Bid;
import edu.estatuas.item.Offer;
import edu.estatuas.item.Sneaker;

public class MinAskTest {
    
    @Test
    public void checkCriteriaMinAsk() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");
        sneaker.add(new Ask("8", 50));
        sneaker.add(new Ask("12", 200));
        sneaker.add(new Ask("5", 20));
        sneaker.add(new Ask("18", 100));

        Criteria minAsk = new MinAsk();
        List<Offer> criteriaMinAsk = minAsk.checkCriteria(sneaker);

        assertTrue(criteriaMinAsk.stream().allMatch(Ask.class::isInstance));
        assertEquals(20, criteriaMinAsk.get(0).value());
    }

    @Test   
    public void checkCriteriaMinAskWithBid() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");
        sneaker.add(new Ask("8", 50));
        sneaker.add(new Ask("12", 200));
        sneaker.add(new Bid("8", 25));
        sneaker.add(new Bid("12", 800));

        Criteria minAsk = new MinAsk();
        List<Offer> criteriaMinAsk = minAsk.checkCriteria(sneaker);

        assertTrue(criteriaMinAsk.stream().allMatch(Ask.class::isInstance));
        assertEquals(50, criteriaMinAsk.get(0).value());
    }

    @Test
    public void checkCriteriaMinAskEmpty() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");

        Criteria minAsk = new MinAsk();
        List<Offer> criteriaMinAsk = minAsk.checkCriteria(sneaker);

        assertTrue(criteriaMinAsk.isEmpty());
    }
}
