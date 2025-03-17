package edu.estatuas.item;

public class Bid implements Offer {

    private String size;
    private Integer bid;

    public Bid(String size, int bid) {
        this.size = size;
        this.bid = Integer.valueOf(bid);
    }

    @Override
    public String size() {
        return size;
    }

    @Override
    public int value() {
        return bid.intValue();
    }

    @Override
    public int compareTo(Offer offer) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\t").append(size)
                .append("\t").append(bid).append("\n");
        return sb.toString();
    }
}
