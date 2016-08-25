package com.company.DataStructures;

/**
 * Created by Jirka on 25.8.2016.
 */
public class TradeRecord {

    // private memmbers
    private String symbol;
    private Double levelPrice;
    private String direction;

    //constructor


    public TradeRecord(String symbol, Double levelPrice, String direction) {
        this.symbol = symbol;
        this.levelPrice = levelPrice;
        this.direction = direction;
    }



    // Setters and Getters

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getLevelPrice() {
        return levelPrice;
    }

    public void setLevelPrice(Double levelPrice) {
        this.levelPrice = levelPrice;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }



    @Override
    public String toString() {
        String output_str ="";
        output_str = "Trade> Symbol: " + symbol + ",tlevelPrice: " + levelPrice + ",direction: " + direction;

        return output_str;
    }

    public String toStringNice() {
        String output_str ="";
        output_str = "Trade: \n" +
                "\tsymbol: " + symbol + "\n" +
                "\tlevelPrice: " + levelPrice + "\n" +
                "\tdirection: " + direction + "\n";

        return output_str;
    }

}
