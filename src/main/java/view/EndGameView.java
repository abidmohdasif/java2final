package view;

import java.util.Map;
import model.Company;
import model.MarketObserver;
import model.MarketSimulator;
import model.Player;

/**
 * A {@link MarketObserver} that displays the end-game summary when the
 * 30-day simulation concludes.
 * <p>
 * Once the current day reaches or exceeds 30, this view calculates the
 * player's final net worth (cash plus the market value of all held shares)
 * and determines whether they met the win condition of $120,000.
 * </p>
 */

public class EndGameView implements MarketObserver {

    private Player player;

    /** The minimum net worth required to win the game. */
    private static final double WIN_CONDITION = 120000.0;

    /**
     * Constructs an EndGameView for the given player.
     *
     * @param player the {@link Player} whose final net worth will be evaluated
     */

    private static final double WIN_CONDITION = 120000.0;

    public EndGameView(Player player) {
        this.player = player;
    }

    /**
     * Checks whether the simulation has ended and, if so, displays the
     * final net worth and win/loss result.
     * <p>
     * Final net worth is calculated as the player's remaining cash plus
     * the current market value of all shares in their portfolio.
     * If the net worth meets or exceeds {@value #WIN_CONDITION}, the player wins.
     * The application exits after the summary is printed.
     * </p>
     *
     * @param market the {@link MarketSimulator} providing the current day
     *               and company prices
     */

    @Override
    public void update(MarketSimulator market) {
        if (market.getCurrentDay() >= 30) {
            System.out.println("\n******************************************");
            System.out.println("* END OF 30 DAYS              *");
            System.out.println("******************************************");
            
            double finalNetWorth = player.getCash();
            for (Map.Entry<String, Integer> entry : player.getPortfolio().getHoldings().entrySet()) {
                Company c = market.findCompany(entry.getKey());
                finalNetWorth += (c.getCurrentPrice() * entry.getValue());
            }

            System.out.printf("FINAL NET WORTH: $%.2f\n", finalNetWorth);
            
            if (finalNetWorth >= WIN_CONDITION) {
                System.out.println("RESULT: Congratulations! You hit $120k and kept your job!");
            } else {
                System.out.println("RESULT: You failed to reach $120k. Your boss fired you.");
            }
            System.out.println("******************************************");
            System.exit(0); // Ends the game
        }
    }
}