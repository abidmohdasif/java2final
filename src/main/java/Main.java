import controller.TradeController;
import model.MarketSimulator;
import model.Player;
import view.MarketView;
import view.PortfolioView;
import view.EndGameView;
import java.util.Scanner;

/**
 * Entry point for the 30-Day Trading Simulator.
 * <p>
 * Initializes the market, player, controller, and all observer views,
 * then runs the main game loop accepting player commands until the game
 * ends or the player quits.
 * </p>
 *
 * <p>Supported commands:</p>
 * <ul>
 *   <li>{@code BUY <ticker> <qty>}  — Purchase shares of a company</li>
 *   <li>{@code SELL <ticker> <qty>} — Sell shares of a company</li>
 *   <li>{@code NEXT}                — Advance to the next trading day</li>
 *   <li>{@code QUIT}                — Exit the simulation early</li>
 * </ul>
 */

public class Main {

    /**
     * Launches the trading simulator.
     * <p>
     * Sets up the {@link MarketSimulator}, {@link Player}, and
     * {@link TradeController}, registers the {@link MarketView},
     * {@link PortfolioView}, and {@link EndGameView} as observers,
     * and enters the main command loop.
     * </p>
     *
     * @param args command-line arguments (not used)
     */
    
    public static void main(String[] args) {
        MarketSimulator market = new MarketSimulator();
        Player player = new Player(100_000.0);

        TradeController controller = new TradeController(market, player);

        MarketView marketView = new MarketView();
        PortfolioView portfolioView = new PortfolioView(player);
        EndGameView endGameView = new EndGameView(player);

        market.attach(marketView);
        market.attach(portfolioView);
        market.attach(endGameView);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the 30-Day Trading Simulator!");

        // Trigger initial view so player can see the market on Day 1
        market.notifyObservers();

        while (!controller.isGameOver()) {
            System.out.println("Commands: BUY <ticker> <qty> | SELL <ticker> <qty> | NEXT | QUIT");
            System.out.print("> ");
            String input = scanner.nextLine().trim().toUpperCase();
            String[] parts = input.split("\\s+");

            switch (parts[0]) {
                case "BUY":
                    if (parts.length == 3) {
                        controller.processBuy(parts[1], Integer.parseInt(parts[2]));
                    } else {
                        System.out.println("Usage: BUY <ticker> <quantity>");
                    }
                    break;

                case "SELL":
                    if (parts.length == 3) {
                        controller.processSell(parts[1], Integer.parseInt(parts[2]));
                    } else {
                        System.out.println("Usage: SELL <ticker> <quantity>");
                    }
                    break;

                case "NEXT":
                    controller.advanceDay();
                    break;

                case "QUIT":
                    System.out.println("Thanks for playing!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Unknown command.");
            }
        }

        scanner.close();
    }
}