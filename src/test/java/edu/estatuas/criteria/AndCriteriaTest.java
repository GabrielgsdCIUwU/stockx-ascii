package edu.estatuas.criteria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import edu.estatuas.item.Ask;
import edu.estatuas.item.Offer;
import edu.estatuas.item.Sale;
import edu.estatuas.item.Sneaker;

public class AndCriteriaTest {
    
    @Test
    public void checkCriteriaAndCriteria() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");
        sneaker.add(new Sale("9.5", 352));
        sneaker.add(new Sale("9.5", 404));
        sneaker.add(new Sale("13", 360));
        sneaker.add(new Sale("13", 372));

        Criteria size = new Size("13");
        Criteria sale = new Sales();
        Criteria andSizeSales = new AndCriteria(size, sale);
        List<Offer> sizeSales = andSizeSales.checkCriteria(sneaker);

        assertEquals(2, sizeSales.size());
        assertTrue(sizeSales.stream().allMatch(Sale.class::isInstance));
        assertTrue(sizeSales.stream().allMatch(saleSize -> saleSize.size().equals("13")));
    }

    @Test
    public void checkCriteriaAndCriteriaWithAsk() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");
        sneaker.add(new Sale("9.5", 352));
        sneaker.add(new Sale("9.5", 404));
        sneaker.add(new Ask("9.5", 333));
        sneaker.add(new Ask("9.5", 500));

        Criteria size = new Size("9.5");
        Criteria sale = new Sales();
        Criteria andSizeSales = new AndCriteria(size, sale);
        List<Offer> sizeSales = andSizeSales.checkCriteria(sneaker);

        assertEquals(2, sizeSales.size());
        assertTrue(sizeSales.stream().allMatch(Sale.class::isInstance));
        assertTrue(sizeSales.stream().allMatch(saleSize -> saleSize.size().equals("9.5")));
    }

    @Test
    public void checkCriteriaAndCriteriaEmpty() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");

        Criteria size = new Size("9.5");
        Criteria sale = new Sales();
        Criteria andSizeSales = new AndCriteria(size, sale);
        List<Offer> sizeSales = andSizeSales.checkCriteria(sneaker);

        assertTrue(sizeSales.isEmpty());
    }
}
