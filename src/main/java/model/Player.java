package model;

/**
 * Represents a player participating in the trading simulation.
 * <p>
 * Each player has a cash balance and a {@link Portfolio} of owned stocks.
 * Players can buy and sell {@link Company} shares as long as they meet
 * the necessary conditions (sufficient funds or sufficient shares).
 * </p>
 */

public class Player {
    private double cash;
    private Portfolio portfolio;

    /**
     * Constructs a Player with the given starting cash balance and an empty portfolio.
     *
     * @param initialCash the amount of cash the player starts with
     */

    public Player(double initialCash) {
        this.cash = initialCash;
        this.portfolio = new Portfolio();
    }

    /**
     * Checks whether the player can afford to purchase a given quantity of shares.
     *
     * @param price    the price per share
     * @param quantity the number of shares to purchase
     * @return {@code true} if the player has enough cash, {@code false} otherwise
     */
    
    public boolean canAfford(double price, int quantity) {
        return cash >= (price * quantity);
    }

    /**
     * Purchases the specified quantity of shares in the given company.
     * Deducts the total cost from the player's cash balance and adds
     * the shares to their portfolio.
     * <p>
     * Note: This method does not check affordability. Call {@link #canAfford}
     * before invoking this method.
     * </p>
     *
     * @param company  the {@link Company} whose shares are being purchased
     * @param quantity the number of shares to buy
     */

    public void buy(Company company, int quantity) {
        double totalCost = company.getCurrentPrice() * quantity;
        this.cash -= totalCost;
        this.portfolio.addStock(company.getTicker(), quantity);
    }

    /**
     * Sells the specified quantity of shares in the given company,
     * provided the player owns enough shares. Adds the total sale value
     * to the player's cash balance and removes the shares from their portfolio.
     * <p>
     * If the player does not own enough shares, the sale is silently ignored.
     * </p>
     *
     * @param company  the {@link Company} whose shares are being sold
     * @param quantity the number of shares to sell
     */
    
    public void sell(Company company, int quantity) {
        if (portfolio.getShares(company.getTicker()) >= quantity) {
            double totalSale = company.getCurrentPrice() * quantity;
            this.cash += totalSale;
            this.portfolio.removeStock(company.getTicker(), quantity);
        }
    }

    /**
     * Returns the player's current cash balance.
     *
     * @return the current cash amount
     */

    public double getCash() { 
        return cash; 
    }

    /**
     * Returns the player's stock portfolio.
     *
     * @return the {@link Portfolio} owned by this player
     */

    public Portfolio getPortfolio() { 
        return portfolio; 
    }
}