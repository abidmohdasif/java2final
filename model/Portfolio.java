package com.portfolio.model;
import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private Map<String, Integer> holdings = new HashMap<>();

    public void addStock(String ticker, int quantity) {
        holdings.merge(ticker, quantity, Integer::sum);
    }

    public void removeStock(String ticker, int quantity) {
        holdings.merge(ticker, -quantity, Integer::sum);
        if (holdings.get(ticker) <= 0) holdings.remove(ticker);
    }

    public int getShares(String ticker) {
        return holdings.getOrDefault(ticker, 0);
    }

    public Map<String, Integer> getHoldings() { return holdings; }
}