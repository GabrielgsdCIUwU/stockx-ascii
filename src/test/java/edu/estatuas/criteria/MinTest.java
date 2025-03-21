package edu.estatuas.criteria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import edu.estatuas.item.Ask;
import edu.estatuas.item.Bid;
import edu.estatuas.item.Offer;
import edu.estatuas.item.Sale;
import edu.estatuas.item.Sneaker;

public class MinTest {
    
    @Test
    public void checkCriteriaMin() {

        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");
        sneaker.add(new Sale("9.5", 352));
        sneaker.add(new Sale("13", 372));

        sneaker.add(new Ask("13", 600));
        sneaker.add(new Ask("9.5", 333));
        sneaker.add(new Ask("9.5", 340));

        Criteria size = new Size("9.5");
        Criteria asks = new Asks();
        Criteria sizeMinAsk = new Min(size, asks);
        List<Offer> sizeAsk = sizeMinAsk.checkCriteria(sneaker);

        assertEquals(1, sizeAsk.size());
        assertTrue(sizeAsk.stream().allMatch(Ask.class::isInstance));
        assertEquals(333, sizeAsk.get(0).value());
        assertEquals("9.5", sizeAsk.get(0).size());
    }
    @Test
    public void checkCriteriaMinWithBid() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");
        sneaker.add(new Ask("8", 50));
        sneaker.add(new Ask("12", 200));
        sneaker.add(new Bid("8", 25));
        sneaker.add(new Bid("12", 800));

        Criteria size = new Size("12");
        Criteria asks = new Asks();
        Criteria sizeMinAsk = new Min(size, asks);
        List<Offer> sizeAsk = sizeMinAsk.checkCriteria(sneaker);

        assertEquals(1, sizeAsk.size());
        assertTrue(sizeAsk.stream().allMatch(Ask.class::isInstance));
        assertEquals("12", sizeAsk.get(0).size());
        assertEquals(200, sizeAsk.get(0).value());
    }

    @Test
    public void checkCriteriaMinEmpty() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");

        Criteria size = new Size("12");
        Criteria asks = new Asks();
        Criteria sizeMinAsk = new Min(size, asks);
        List<Offer> sizeAsk = sizeMinAsk.checkCriteria(sneaker);

        assertTrue(sizeAsk.isEmpty());
    }
}
