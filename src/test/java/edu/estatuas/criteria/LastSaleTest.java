package edu.estatuas.criteria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import edu.estatuas.item.Ask;
import edu.estatuas.item.Offer;
import edu.estatuas.item.Sale;
import edu.estatuas.item.Sneaker;

public class LastSaleTest {
    
    @Test
    public void getLastSale() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");
        sneaker.add(new Sale("9.5", 352));
        sneaker.add(new Sale("9.5", 404));
        sneaker.add(new Sale("13", 360));
        sneaker.add(new Sale("13", 372));

        Criteria lastSale = new LastSale();
        List<Offer> lastSaleOffer = lastSale.checkCriteria(sneaker);

        assertEquals(1, lastSaleOffer.size());
        assertEquals("13", lastSaleOffer.get(0).size());
        assertEquals(372, lastSaleOffer.get(0).value());
    }

    @Test
    public void getLastSaleWithAsk() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");
        sneaker.add(new Sale("9.5", 404));
        sneaker.add(new Sale("13", 360));
        sneaker.add(new Ask("5", 20));
        sneaker.add(new Ask("18", 100));

        Criteria lastSale = new LastSale();
        List<Offer> lastSaleOffer = lastSale.checkCriteria(sneaker);

        assertEquals(1, lastSaleOffer.size());
        assertTrue(lastSaleOffer.stream().allMatch(Sale.class::isInstance));
    }

    @Test
    public void getLastSaleEmpty() {
        Sneaker sneaker = new Sneaker("555088-105", "Jordan 1");

        Criteria lastSale = new LastSale();
        List<Offer> lastSaleOffer = lastSale.checkCriteria(sneaker);

        assertEquals(0, lastSaleOffer.size());
    }
}
