package com.portfolio.model;
import java.util.List;

public class MarketView {
    public void display(List<Company> companies) {
        System.out.printf("%-20s %-6s %10s%n", "Company", "Ticker", "Price");
        System.out.println("-".repeat(40));
        for (Company c : companies) {
            System.out.printf("%-20s %-6s $%9.2f%n",
                c.getName(), c.getTicker(), c.getCurrentPrice());
        }
    }
}