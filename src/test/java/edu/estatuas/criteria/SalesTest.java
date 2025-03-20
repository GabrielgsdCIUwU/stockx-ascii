package edu.estatuas.criteria;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import java.util.List;

import org.junit.Test;

import edu.estatuas.item.Offer;
import edu.estatuas.item.Sale;
import edu.estatuas.item.Sneaker;

public class SalesTest {
    
    @Test
    public void checkCriteriaSales() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");
        sneaker.add(new Sale("9.5", 352));
        sneaker.add(new Sale("9.5", 404));
        sneaker.add(new Sale("13", 360));
        sneaker.add(new Sale("13", 372));

        Criteria sales = new Sales();
        List<Offer> criteriaSales = sales.checkCriteria(sneaker);

        assertTrue(criteriaSales.stream().allMatch(Sales.class::isInstance));
    }

    @Test
    public void checkCriteriaSalesEmpty() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");

        Criteria sales = new Sales();
        List<Offer> criteriaSales = sales.checkCriteria(sneaker);

        assumeTrue(criteriaSales.isEmpty());
    }
}
