package edu.estatuas.criteria;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import edu.estatuas.item.Ask;
import edu.estatuas.item.Bid;
import edu.estatuas.item.Offer;
import edu.estatuas.item.Sneaker;

public class AsksTest {
    
    @Test
    public void checkCriteriaAsks() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");
        sneaker.add(new Ask("8", 50));
        sneaker.add(new Ask("12", 200));
        sneaker.add(new Ask("5", 20));
        sneaker.add(new Ask("18", 100));

        Criteria asks = new Asks();
        List<Offer> criteriaAsks = asks.checkCriteria(sneaker);

        assertTrue(criteriaAsks.stream().allMatch(Ask.class::isInstance));
    }

    @Test
    public void checkCriteriaAsksBids() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");
        sneaker.add(new Bid("8", 250));
        sneaker.add(new Bid("12", 800));
        sneaker.add(new Ask("15", 288));
        sneaker.add(new Bid("5", 120));
        sneaker.add(new Ask("12", 400));

        Criteria asks = new Asks();
        List<Offer> criteriaAsks = asks.checkCriteria(sneaker);

        assertTrue(criteriaAsks.stream().allMatch(Ask.class::isInstance));
    }

    @Test
    public void checkCriteriaAsksEmpty() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");

        Criteria asks = new Asks();
        List<Offer> criteriaAsks = asks.checkCriteria(sneaker);

        assertTrue(criteriaAsks.isEmpty());
    }
}
