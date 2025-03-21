package edu.estatuas.criteria;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.estatuas.item.Ask;
import edu.estatuas.item.Bid;
import edu.estatuas.item.Offer;
import edu.estatuas.item.Sneaker;

public class SizeTest {
    private Sneaker sneaker;
    @Before
    public void setup() {
        sneaker = new Sneaker("555088-105", "Jordan 1");  
    }
    
    @Test
    public void checkCriteriaSize() {
        sneaker.add(new Bid("8", 250));
        sneaker.add(new Bid("12", 800));
        sneaker.add(new Bid("5", 120));
        sneaker.add(new Ask("8", 50));
        sneaker.add(new Ask("12", 200));
        sneaker.add(new Ask("5", 20));
        sneaker.add(new Ask("18", 100));

        String searchSize = "12";

        Criteria size = new Size(searchSize);
        List<Offer> criteriaSize = size.checkCriteria(sneaker);

        assertTrue(criteriaSize.stream().allMatch(o -> o.size().equals(searchSize)));
    }

    @Test
    public void checkCriteriaSizeEmpty() {

        String searchSize = "8";

        Criteria size = new Size(searchSize);
        List<Offer> criteriaSize = size.checkCriteria(sneaker);

        assertTrue(criteriaSize.isEmpty());
    }

    @Test
    public void checkCriteriaSizeEmptyWithOtherCriteria() {
        sneaker.add(new Bid("8", 250));
        sneaker.add(new Bid("12", 800));
        sneaker.add(new Bid("5", 120));
        sneaker.add(new Ask("8", 50));
        sneaker.add(new Ask("12", 200));
        sneaker.add(new Ask("5", 20));
        sneaker.add(new Ask("18", 100));

        Criteria size = new Size("20");
        List<Offer> criteriaSize = size.checkCriteria(sneaker);

        assertTrue(criteriaSize.isEmpty());
    }
}
