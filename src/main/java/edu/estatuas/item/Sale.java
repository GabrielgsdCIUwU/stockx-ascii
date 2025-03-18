package edu.estatuas.item;

public class Sale implements Offer {
    
    private String size;
    private Integer price;

    public Sale(String string, int size) {
        this.size = string;
        this.price = Integer.valueOf(size);
    }

    @Override
    public String size() {
        return size;
    }

    @Override
    public int value() {
        return price.intValue();
    }

    @Override
    public int compareTo(Offer offer) {
        return price.compareTo(offer.value());
    }
}
