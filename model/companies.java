package com.portfolio.model;

public class companies {
    private String name;
    private String ticker;
    private String description;
    private double currentPrice;
    private PriceUpdateStrategy strategy;

    public companies(String name, String ticker, String description, double initialPrice, PriceUpdateStrategy strategy) {
        this.name = name;
        this.ticker = ticker;
        this.description = description;
        this.currentPrice = initialPrice;
        this.strategy = strategy;
    }

    
    public String getTicker() { return ticker; }
    public String getDescription() { return description; }
    
}