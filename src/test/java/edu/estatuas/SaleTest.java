package edu.estatuas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.estatuas.item.Sale;

public class SaleTest {
    
    @Test
    public void createSale() {
        
        String size = "7";
        int price = 299;

        Sale sale = new Sale(size, price);

        assertEquals(size, sale.size());
        assertEquals(price, sale.value());
    }
}
