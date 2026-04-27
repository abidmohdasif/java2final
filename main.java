package com.portfolio.model;

public class Main {
    public static void main(String[] args) {
        MarketSimulator market = new MarketSimulator();
        Player player = new Player(100_000.0);
        TradeController controller = new TradeController(market, player);
        MarketView marketView = new MarketView();
        PortfolioView portfolioView = new PortfolioView();

        marketView.display(market.getCompanies());
        controller.processBuy("ZENE", 10);
        controller.advanceDay();
        portfolioView.display(player, market);
    }
}