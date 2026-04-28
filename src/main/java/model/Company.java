package model;

/**
 * Represents a publicly traded company in the market simulation.
 * Each company has a name, ticker symbol, description, current stock price,
 * and a {@link PriceUpdateStrategy} that determines how its price changes each day.
 */

public class Company {
    private String name;
    private String ticker;
    private String description;
    private double currentPrice;
    private PriceUpdateStrategy strategy;

    /**
     * Constructs a Company with the given details and pricing strategy.
     *
     * @param name          the full name of the company
     * @param ticker        the stock ticker symbol (e.g., "AAPL")
     * @param description   a brief description of the company
     * @param initialPrice  the starting stock price of the company
     * @param strategy      the {@link PriceUpdateStrategy} used to update the stock price each day
     */

    public Company(String name, String ticker, String description, double initialPrice, PriceUpdateStrategy strategy) {
        this.name = name;
        this.ticker = ticker;
        this.description = description;
        this.currentPrice = initialPrice;
        this.strategy = strategy;
    }

     /**
     * Returns the full name of the company.
     *
     * @return the company name
     */

    public String getName() { 
        return name; 
    }

    /**
     * Returns the stock ticker symbol of the company.
     *
     * @return the ticker symbol
     */
    
    public String getTicker() { 
        return ticker; 
    }

     /**
     * Returns a brief description of the company.
     *
     * @return the company description
     */

    public String getDescription() { 
        return description; 
    }

    /**
     * Returns the current stock price of the company.
     *
     * @return the current price
     */

    public double getCurrentPrice() { 
        return currentPrice; 
    }

    /**
     * Updates the company's stock price using its assigned {@link PriceUpdateStrategy}.
     * Called once per simulation day.
     */

    public void updatePrice() { 
        this.currentPrice = strategy.updatePrice(currentPrice); 
    }

    /**
     * Applies a market event impact to the company's stock price by scaling
     * it with the given multiplier. The result is rounded to two decimal places.
     * <p>
     * For example, a multiplier of {@code 0.8} represents a 20% price drop,
     * while {@code 1.2} represents a 20% price increase.
     * </p>
     *
     * @param multiplier the factor by which to scale the current price
     */
    
    public void applyEventImpact(double multiplier) {
        this.currentPrice = Math.round(this.currentPrice * multiplier * 100.0) / 100.0;
    }
}
