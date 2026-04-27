package com.portfolio.model;

public class PortfolioView {
    public void display(Player player, MarketSimulator market) {
        System.out.printf("Cash: $%.2f%n", player.getCash());
        player.getPortfolio().getHoldings().forEach((ticker, qty) -> {
            Company c = market.findCompany(ticker);
            double value = c != null ? c.getCurrentPrice() * qty : 0;
            System.out.printf("  %s: %d shares @ $%.2f = $%.2f%n",
                ticker, qty, c.getCurrentPrice(), value);
        });
    }
}