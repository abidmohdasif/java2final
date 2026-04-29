package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a player's stock portfolio, tracking the number of shares
 * held for each company by ticker symbol.
 * <p>
 * Internally uses a {@link HashMap} mapping ticker symbols to share quantities.
 * Entries are automatically removed when the share count drops to zero or below.
 * </p>
 */

public class Portfolio {
    private Map<String, Integer> holdings = new HashMap<>();

    /**
     * Adds the specified quantity of shares for the given ticker symbol.
     * If the ticker already exists in the portfolio, the quantity is added
     * to the existing amount.
     *
     * @param ticker   the stock ticker symbol
     * @param quantity the number of shares to add
     */

    public void addStock(String ticker, int quantity) {
        holdings.merge(ticker, quantity, Integer::sum);
    }

    /**
     * Removes the specified quantity of shares for the given ticker symbol.
     * If the resulting share count is zero or below, the ticker is removed
     * from the portfolio entirely.
     *
     * @param ticker   the stock ticker symbol
     * @param quantity the number of shares to remove
     */

    public void removeStock(String ticker, int quantity) {
        holdings.merge(ticker, -quantity, Integer::sum);
        if (holdings.get(ticker) <= 0) holdings.remove(ticker);
    }

    /**
     * Returns the number of shares held for the given ticker symbol.
     * Returns {@code 0} if the ticker is not present in the portfolio.
     *
     * @param ticker the stock ticker symbol to look up
     * @return the number of shares held, or {@code 0} if none
     */

    public int getShares(String ticker) {
        return holdings.getOrDefault(ticker, 0);
    }

    /**
     * Returns the full map of holdings, with ticker symbols as keys
     * and share quantities as values.
     *
     * @return a {@link Map} of ticker symbols to share counts
     */

    public Map<String, Integer> getHoldings() { 
        return holdings; 
    }
}