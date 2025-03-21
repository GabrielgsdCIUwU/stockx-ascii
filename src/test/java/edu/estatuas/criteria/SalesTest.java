package edu.estatuas.criteria;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.estatuas.item.Bid;
import edu.estatuas.item.Offer;
import edu.estatuas.item.Sale;
import edu.estatuas.item.Sneaker;

public class SalesTest {
private Sneaker sneaker;
    @Before
    public void setup() {
        sneaker = new Sneaker("555088-105", "Jordan 1");  
    }
    
    @Test
    public void checkCriteriaSales() {
        sneaker.add(new Sale("9.5", 352));
        sneaker.add(new Sale("9.5", 404));
        sneaker.add(new Sale("13", 360));
        sneaker.add(new Sale("13", 372));

        Criteria sales = new Sales();
        List<Offer> criteriaSales = sales.checkCriteria(sneaker);

        assertTrue(criteriaSales.stream().allMatch(Sale.class::isInstance));
    }

    @Test
    public void checkCriteriaSalesBids() {
        sneaker.add(new Sale("9.5", 352));
        sneaker.add(new Sale("9.5", 404));
        sneaker.add(new Bid("8", 250));
        sneaker.add(new Bid("12", 800));

        Criteria sales = new Sales();
        List<Offer> criteriaSales = sales.checkCriteria(sneaker);

        assertTrue(criteriaSales.stream().allMatch(Sale.class::isInstance));
        
    }

    @Test
    public void checkCriteriaSalesEmpty() {

        Criteria sales = new Sales();
        List<Offer> criteriaSales = sales.checkCriteria(sneaker);

        assumeTrue(criteriaSales.isEmpty());
    }
}
