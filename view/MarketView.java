import model.Company;
import model.MarketObserver;
import model.MarketSimulator;

public class MarketView implements MarketObserver {
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
