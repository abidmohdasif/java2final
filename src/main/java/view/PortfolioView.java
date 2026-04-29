package view;

import java.util.Map;
import model.Company;
import model.MarketObserver;
import model.MarketSimulator;
import model.Player;

/**
 * A {@link MarketObserver} that displays the player's portfolio summary
 * to the console at the end of each simulation day.
 * <p>
 * Shows the player's available cash, a breakdown of all held shares with
 * their current market value, and the total net worth (cash plus holdings).
 * </p>
 */

public class PortfolioView implements MarketObserver {
    private Player player;

    /**
     * Constructs a PortfolioView for the given player.
     *
     * @param player the {@link Player} whose portfolio will be displayed
     */

    public PortfolioView(Player player) {
        this.player = player;
    }

    /**
     * Displays the player's current portfolio summary.
     * <p>
     * Prints the player's available cash, each held stock with its share count
     * and current market value, and the total net worth. If the player holds
     * no shares, "Holdings: None" is displayed instead.
     * </p>
     *
     * @param market the {@link MarketSimulator} used to look up current
     *               prices for each held company
     */
    
    @Override
    public void update(MarketSimulator market) {
        System.out.println("------------- YOUR PORTFOLIO -------------");
        System.out.printf("Available Cash: $%.2f\n", player.getCash());
        
        double totalValue = player.getCash();
        Map<String, Integer> holdings = player.getPortfolio().getHoldings();
        
        if (holdings.isEmpty()) {
            System.out.println("Holdings: None");
        } else {
            System.out.println("Holdings:");
            for (Map.Entry<String, Integer> entry : holdings.entrySet()) {
                Company c = market.findCompany(entry.getKey());
                double value = c.getCurrentPrice() * entry.getValue();
                totalValue += value;
                System.out.printf("  %-5s: %d shares (Value: $%.2f)\n", entry.getKey(), entry.getValue(), value);
            }
        }
        System.out.printf("Total Net Worth: $%.2f\n", totalValue);
        System.out.println("------------------------------------------\n");
    }
}