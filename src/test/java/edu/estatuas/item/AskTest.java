package edu.estatuas.item;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.estatuas.item.Ask;

public class AskTest {
    
    @Test
    public void createAsk() {

        String size = "13";
        int askValue = 240;

        Ask ask = new Ask(size, askValue);

        assertEquals(size, ask.size());
        assertEquals(askValue, ask.value());
    }
}
