package view;

import java.util.Map;
import model.Company;
import model.MarketObserver;
import model.MarketSimulator;
import model.Player;

public class EndGameView implements MarketObserver {
    private Player player;
    private static final double WIN_CONDITION = 120000.0;

    public EndGameView(Player player) {
        this.player = player;
    }

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