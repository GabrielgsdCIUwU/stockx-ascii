package edu.estatuas.criteria;

import java.util.List;

import edu.estatuas.item.Item;
import edu.estatuas.item.Offer;

public interface Criteria {
    List<Offer> checkCriteria(Item item);
}
