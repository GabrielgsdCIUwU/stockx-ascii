package edu.estatuas.item;

public class Bid implements Offer {
    
    private String size;
    private int bid;

    public Bid(String size, int bid) {
        this.size = size;
        this.bid = bid;
    }

    @Override
    public String size() {
        return size;
    }

    @Override
    public int value() {
        return bid;
    }

    @Override
    public int compareTo(Offer offer) {
        // TODO Auto-generated method stub
        return 0;
    }
}
