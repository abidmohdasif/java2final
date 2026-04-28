package controller;

import model.Company;
import model.MarketSimulator;
import model.Player;

/**
 * Controls trading operations between a {@link Player} and the {@link MarketSimulator}.
 * Handles buying, selling, and advancing the simulation by one day.
 */
public class TradeController {
    private MarketSimulator market;
    private Player player;

    /**
     * Constructs a TradeController with the given market and player.
     *
     * @param market the {@link MarketSimulator} representing the stock market
     * @param player the {@link Player} participating in the simulation
     */

    public TradeController(MarketSimulator market, Player player) {
        this.market = market;
        this.player = player;
    }

    /**
     * Processes a buy order for the specified stock ticker and quantity.
     * The trade succeeds only if the company exists and the player can afford it.
     *
     * @param ticker   the stock ticker symbol of the company to buy
     * @param quantity the number of shares to purchase
     */

    public void processBuy(String ticker, int quantity) {
        Company company = market.findCompany(ticker); 
        if (company != null && player.canAfford(company.getCurrentPrice(), quantity)) {
            player.buy(company, quantity);
            System.out.println("Trade successful!");
        } else {
            System.out.println("Trade failed: Insufficient funds or invalid company.");
        }
    }

    /**
     * Advances the market simulation by one day.
     */

    public void advanceDay() {
        market.nextDay();
    }

    /**
     * Processes a sell order for the specified stock ticker and quantity.
     * Prints an error message if the company is not found in the market.
     *
     * @param ticker   the stock ticker symbol of the company to sell
     * @param quantity the number of shares to sell
     */

    public void processSell(String ticker, int quantity) {
    Company company = market.findCompany(ticker);
    if (company == null) {
        System.out.println("Company not found.");
        return;
    }
    player.sell(company, quantity);
    }

    /**
     * Checks whether the game is over.
     * The game ends when the current day exceeds 30.
     *
     * @return {@code true} if the simulation has exceeded 30 days, {@code false} otherwise
     */

    public boolean isGameOver() {
        return market.getCurrentDay() > 30;
    }
}
