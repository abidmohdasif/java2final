package model;

public class Company {
    private String name;
    private String ticker;
    private String description;
    private double currentPrice;
    private PriceUpdateStrategy strategy;

    public Company(String name, String ticker, String description, double initialPrice, PriceUpdateStrategy strategy) {
        this.name = name;
        this.ticker = ticker;
        this.description = description;
        this.currentPrice = initialPrice;
        this.strategy = strategy;
    }

    public String getName() { return name; }
    public String getTicker() { return ticker; }
    public String getDescription() { return description; }
    public double getCurrentPrice() { return currentPrice; }

    public void updatePrice() { 
        this.currentPrice = strategy.updatePrice(currentPrice); 
    }

    // Used for purposeful market events
    public void applyEventImpact(double multiplier) {
        this.currentPrice = Math.round(this.currentPrice * multiplier * 100.0) / 100.0;
    }
}
