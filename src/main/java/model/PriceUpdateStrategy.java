package model;

/**
 * Strategy interface for updating a company's stock price each simulation day.
 * <p>
 * Implementations define different market behaviors (e.g., steady growth,
 * high volatility). This follows the Strategy design pattern, allowing
 * each {@link Company} to have its own pricing behavior.
 * </p>
 */

public interface PriceUpdateStrategy {

    /**
     * Calculates and returns a new stock price based on the current price.
     *
     * @param currentPrice the company's current stock price
     * @return the updated stock price
     */

    double updatePrice(double currentPrice);
}

/**
 * A {@link PriceUpdateStrategy} that simulates a steady bull market.
 * <p>
 * Each day the stock price increases by a random amount between 0% and 4%,
 * reflecting consistent upward market momentum.
 * </p>
 */

class BullMarketStrategy implements PriceUpdateStrategy {

    /**
     * Applies a random daily gain of 0–4% to the current price.
     * The result is rounded to two decimal places.
     *
     * @param currentPrice the company's current stock price
     * @return the updated price after applying the bull market gain
     */

    public double updatePrice(double currentPrice) {
        double change = 1 + (Math.random() * 0.04); // 0–4% gain
        return Math.round(currentPrice * change * 100.0) / 100.0;
    }
}

/**
 * A {@link PriceUpdateStrategy} that simulates a highly volatile market.
 * <p>
 * Each day the stock price changes by a random amount between -8% and +8%,
 * reflecting unpredictable price swings in either direction.
 * </p>
 */

class VolatileStrategy implements PriceUpdateStrategy {

    /**
     * Applies a random daily change of -8% to +8% to the current price.
     * The result is rounded to two decimal places.
     *
     * @param currentPrice the company's current stock price
     * @return the updated price after applying the volatile market change
     */
    
    public double updatePrice(double currentPrice) {
        double change = 0.92 + (Math.random() * 0.16); // -8% to +8%
        return Math.round(currentPrice * change * 100.0) / 100.0;
    }
}
