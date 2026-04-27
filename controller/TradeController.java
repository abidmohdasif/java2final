package controller;

import model.Company;
import model.MarketSimulator;
import model.Player;

public class TradeController {
    private MarketSimulator market;
    private Player player;

    public TradeController(MarketSimulator market, Player player) {
        this.market = market;
        this.player = player;
    }

    public void processBuy(String ticker, int quantity) {
        Company company = market.findCompany(ticker); 
        if (company != null && player.canAfford(company.getCurrentPrice(), quantity)) {
            player.buy(company, quantity);
            System.out.println("Trade successful!");
        } else {
            System.out.println("Trade failed: Insufficient funds or invalid company.");
        }
    }

    public void advanceDay() {
        market.nextDay();
    }
}
