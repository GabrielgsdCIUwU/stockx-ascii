package edu.estatuas.item;

public class Ask implements Offer {
    
    private String size;
    private Integer ask;

    public Ask(String size, int ask) {
        this.size = size;
        this.ask = ask;
    }

    @Override
    public String size() {
        return size;
    }

    @Override
    public int value() {
        return ask.intValue();
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
                .append("\t").append(ask).append("\n");
        return sb.toString();        
    }
}
