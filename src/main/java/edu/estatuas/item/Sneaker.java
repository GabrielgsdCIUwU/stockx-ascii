package edu.estatuas.item;

import java.util.ArrayList;
import java.util.List;

public class Sneaker implements Item {
    
    private final String style;
    private final String name;
    private int sale = 0;
    private int ask = 0;
    private int bid = 0;
    private List<Offer> offers = new ArrayList<>();

    public Sneaker(String name, String style) {
        this.name = name;
        this.style = style;
    }

    //region Item interfaz
    @Override
    public int getBid() {
        return bid;
    }

    @Override
    public int getAsk() {
        return ask;
    }

    @Override
    public int getSale() {
        return sale;
    }

    @Override
    public void add(Offer offer) {
        offers.add(offer);
    }

    @Override
    public List<Offer> offers() {
        return offers;
    }

    @Override
    public void setBid(int bid) {
        this.bid = bid;
    }

    @Override
    public void setAsk(int ask) {
        this.ask = ask;
    }

    @Override
    public void setSale(int sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        message.append(style)
        .append(name);

        return message.toString();        
    }
}
