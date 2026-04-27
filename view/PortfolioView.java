import java.util.Map;
import model.Company;
import model.MarketObserver;
import model.MarketSimulator;
import model.Player;

public class PortfolioView implements MarketObserver {
    private Player player;

    public PortfolioView(Player player) {
        this.player = player;
    }

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