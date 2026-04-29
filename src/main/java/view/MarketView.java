package view;

import model.Company;
import model.MarketObserver;
import model.MarketSimulator;

/**
 * A {@link MarketObserver} that displays the current state of the stock market
 * to the console at the end of each simulation day.
 * <p>
 * Prints the current day number, the latest news headline, and a formatted
 * table of all companies with their ticker symbols, current prices, and names.
 * </p>
 */

public class MarketView implements MarketObserver {

    /**
     * Displays the market summary for the current simulation day.
     * <p>
     * Output includes the day number, latest market news, and a row for
     * each {@link Company} showing its ticker, current price, and name.
     * </p>
     *
     * @param market the {@link MarketSimulator} providing the current
     *               day, news, and list of companies
     */
    
    @Override
    public void update(MarketSimulator market) {
        System.out.println("\n========================================");
        System.out.println("             DAY " + market.getCurrentDay() + " MARKET");
        System.out.println("========================================");
        System.out.println("NEWS: " + market.getLatestNews());
        System.out.println("----------------------------------------");
        for (Company c : market.getCompanies()) {
            System.out.printf("%-5s | $%-8.2f | %s\n", c.getTicker(), c.getCurrentPrice(), c.getName());
        }
        System.out.println("========================================\n");
    }
}
