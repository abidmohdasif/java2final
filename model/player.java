package com.portfolio.model;

public class Player {
    private double cash;
    private Portfolio portfolio;

    public Player(double initialCash) {
        this.cash = initialCash;
        this.portfolio = new Portfolio();
    }

    
    public boolean canAfford(double price, int quantity) {
        return cash >= (price * quantity);
    }

    public void buy(Company company, int quantity) {
        double totalCost = company.getCurrentPrice() * quantity;
        this.cash -= totalCost;
        this.portfolio.addStock(company.getTicker(), quantity);
    }

    
    public void sell(Company company, int quantity) {
        if (portfolio.getShares(company.getTicker()) >= quantity) {
            double totalSale = company.getCurrentPrice() * quantity;
            this.cash += totalSale;
            this.portfolio.removeStock(company.getTicker(), quantity);
        }
    }

    
    public double getCash() { return cash; }
    public Portfolio getPortfolio() { return portfolio; }
}