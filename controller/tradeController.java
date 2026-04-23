package com.portfolio.model;

import model.MarketSimulator;
import model.Player;
import model.Company;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TradeController {
    private MarketSimulator market;
    private Player player;
    private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();


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
        int[] dayCount = {0};
        scheduler.scheduleAtFixedRate(() -> {
            market.nextDay();
            dayCount[0]++;
            if (dayCount[0] >= 30) {
                scheduler.shutdown();
            }
        }, 0, 60, TimeUnit.SECONDS);
    }
}