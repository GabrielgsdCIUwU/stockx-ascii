package edu.estatuas.item;

public class Sale implements Offer {
    
    private String size;
    private Integer price;

    public Sale(String string, int price) {
        this.size = string;
        this.price = Integer.valueOf(price);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\t").append(size)
            .append("\t").append(price).append("\n");

        return sb.toString();
    }
}
