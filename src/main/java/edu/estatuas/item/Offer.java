package edu.estatuas.item;

public interface Offer extends Comparable<Offer> {
    String size();
    int value();
    int compareTo( Offer offer );
}
