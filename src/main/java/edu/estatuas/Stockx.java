package edu.estatuas;

import java.util.List;

import edu.estatuas.criteria.AndCriteria;
import edu.estatuas.criteria.Asks;
import edu.estatuas.criteria.Bids;
import edu.estatuas.criteria.Criteria;
import edu.estatuas.criteria.LastSale;
import edu.estatuas.criteria.Max;
import edu.estatuas.criteria.MaxBid;
import edu.estatuas.criteria.Min;
import edu.estatuas.criteria.MinAsk;
import edu.estatuas.criteria.Sales;
import edu.estatuas.criteria.Size;
import edu.estatuas.item.Ask;
import edu.estatuas.item.Bid;
import edu.estatuas.item.Item;
import edu.estatuas.item.Offer;
import edu.estatuas.item.Sale;
import edu.estatuas.item.Sneaker;

/**
 * StockX nació en Detroit, y allí siguen haciendo
 * las cosas a la manera tradicional,
 * Si tienes dudas, puedes interactuar con
 * la webapp based in London que sí que tiene (G)UI
 * https://stockx.com/air-jordan-1-retro-high-dark-mocha
 */


public class Stockx {

    public static void main(String[] args) {

        Item sneaker = new Sneaker("555088-105", "Jordan 1 Retro High Dark Mocha");
        System.out.println(Stockx.draw(sneaker));


        //region Bid
        Bid bid = new Bid("13", 550);
        sneaker.add(bid);
        sneaker.add(new Bid("6", 200));
        sneaker.add(new Bid("9.5", 479));
        sneaker.add(new Bid("13", 338));
        sneaker.add(new Bid("9.5", 480));


        //region Ask
        Ask ask = new Ask("13", 288);
        sneaker.add(ask);
        sneaker.add(new Ask("6", 600));
        sneaker.add(new Ask("9.5", 333));
        sneaker.add(new Ask("9.5", 340));
        sneaker.add(new Ask("13", 330));


        //region Bids
        Criteria bids = new Bids();
        System.out.println("\n\t\t All BIDS");
        bids.checkCriteria(sneaker).forEach(System.out::print);


        //region Asks
        Criteria asks = new Asks();
        System.out.println("\n\t\t All ASKS");
        asks.checkCriteria(sneaker).forEach(System.out::print);


        //region MaxBid
        Criteria maxBid = new MaxBid();
        List<Offer> maximum = maxBid.checkCriteria(sneaker);
        sneaker.setBid(maximum.isEmpty()? 0 : maximum.get(0).value());
        System.out.println(Stockx.draw(sneaker));


        //region MinAsk
        Criteria minAsk = new MinAsk();
        List<Offer> minimum = minAsk.checkCriteria(sneaker);
        sneaker.setAsk(minimum.isEmpty()? 0 : minimum.get(0).value());
        System.out.println(Stockx.draw(sneaker));


        //region Sale
        Sale sale = new Sale("6", 356);
        sneaker.add(sale);
        sneaker.add(new Sale("9.5", 352));
        sneaker.add(new Sale("9.5", 404));
        sneaker.add(new Sale("13", 360));
        sneaker.add(new Sale("13", 372));


        //region Sales
        Criteria sales = new Sales();
        System.out.println("\n\t\t All SALES");
        sales.checkCriteria(sneaker).forEach(System.out::print);
        

        //region LastSale
        Criteria lastSale = new LastSale();
        
        List<Offer> actualSale = lastSale.checkCriteria(sneaker);
        sneaker.setSale(actualSale.isEmpty()? 0 : actualSale.get(0).value());
        System.out.println(Stockx.draw(sneaker));


        //region AndCriteria
        System.out.println("\n\t\t SALES 9.5 US");
        Criteria size = new Size("9.5");
        sales = new Sales();
        Criteria andSizeSales = new AndCriteria(size, sales);
        andSizeSales.checkCriteria(sneaker).forEach(System.out::print);

        List<Offer> sizeSales = andSizeSales.checkCriteria(sneaker);
        sneaker.setSale(sizeSales.isEmpty()? 
                            0 : 
                            sizeSales.get(sizeSales.size() -1).value());
        System.out.println("\n\t\t LAST SALE 9.5 US: " + sneaker.getSale()); 

        System.out.println("\n\t\t BIDS 9.5 US");
        bids = new Bids();
        Criteria andSizeBids = new AndCriteria(size, bids);
        andSizeBids.checkCriteria(sneaker).forEach(System.out::print);

        //region Max
        Criteria sizeMaxBid = new Max(size, bids);
        List<Offer> sizeBid = sizeMaxBid.checkCriteria(sneaker);
        sneaker.setBid(sizeBid.isEmpty()? 0 : sizeBid.get(0).value());
        System.out.println("\n\t\t MAX BID 9.5 US: " + sneaker.getBid());

        //region Min
        Criteria sizeMinAsk = new Min(size, asks);
        List<Offer> sizeAsk = sizeMinAsk.checkCriteria(sneaker);
        sneaker.setAsk(sizeAsk.isEmpty()? 0 : sizeAsk.get(0).value());
        System.out.println("\n\t\t MIN ASK 9.5 US: " + sneaker.getAsk());

        System.out.println(Stockx.draw(sneaker));   
    }

    public static String draw(Item sneaker) {
        return
        "\n\n\t\t" + sneaker.getAsk() + " Buy\t" 
        + sneaker.getBid() + " Sell \n" +  

        "\t\t" + " _    _" + "\n" +
        "\t\t" + "(_\\__/(,_" + "\n" +
        "\t\t" + "| \\ `_////-._" + "\n" +
        "\t\t" + "J_/___\"=> __/`\\" + "\n" +
        "\t\t" + "|=====;__/___./" + "\n" +
        "\t\t" + "\'-\'-\'-\"\"\"\"\"\"\"`" + "\n" +
        
        "\t" + sneaker.toString() + "\n" +
        "\t\tlast sale: " + sneaker.getSale();
    }
}