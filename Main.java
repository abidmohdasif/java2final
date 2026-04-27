package com.portfolio.model;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize Model
        MarketSimulator market = new MarketSimulator();
        Player player = new Player(100_000.0);
        
        // 2. Initialize Controller
        TradeController controller = new TradeController(market, player);
        
        // 3. Initialize Views
        MarketView marketView = new MarketView();
        PortfolioView portfolioView = new PortfolioView(player);
        EndGameView endGameView = new EndGameView(player);

        // 4. Register Views to the MarketSimulator (Observer Pattern)
        market.attach(marketView);
        market.attach(portfolioView);
        market.attach(endGameView);

        // --- GAMEPLAY DEMO ---
        // Normally, you would use a Scanner here to take input from the user in a loop.
        System.out.println("Starting the 30-Day Trading Simulator...");

        // Player makes a trade on Day 1
        controller.processBuy("ZENE", 100);
        
        // Advancing the day automatically triggers update() on MarketView, PortfolioView, etc.
        controller.advanceDay(); 

        // Simulating the rest of the month rapidly to test the End Game condition
        for (int i = 2; i <= 30; i++) {
            controller.advanceDay();
        }
    }
}