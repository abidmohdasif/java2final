package model;

import java.util.ArrayList;
import java.util.List;

public class MarketSimulator {
    private List<Company> companies;
    private int currentDay;
    private List<MarketObserver> observers;
    private String latestNews = "Market open. Good luck!";

    public MarketSimulator() {
        this.companies = MarketDataFactory.createAllCompanies();
        this.currentDay = 1;
        this.observers = new ArrayList<>();
    }

    // Observer Pattern Methods
    public void attach(MarketObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (MarketObserver observer : observers) {
            observer.update(this);
        }
    }

    // Core Game Loop
    public void nextDay() {
        currentDay++;
        latestNews = "Trading Day " + currentDay + " has concluded.";

        // Normal volatility
        for (Company c : companies) {
            c.updatePrice();
        }

        // Trigger specific market events
        triggerRandomEvents();

        // Automatically updates all registered views
        notifyObservers();
    }

    private void triggerRandomEvents() {
        // 15% chance for a major event on a random company
        if (Math.random() < 0.15) {
            Company c = companies.get((int)(Math.random() * companies.size()));
            if (Math.random() < 0.5) {
                c.applyEventImpact(1.25); // +25% boom
                latestNews = "BREAKING: " + c.getName() + " announces massive breakthrough! Stock surges.";
            } else {
                c.applyEventImpact(0.75); // -25% crash
                latestNews = "BREAKING: Scandal hits " + c.getName() + "! Stock plummets.";
            }
        }
    }

    public Company findCompany(String ticker) {
        for (Company c: companies) {
            if (c.getTicker().equalsIgnoreCase(ticker)) {
                return c;
            }
        }
        return null;
    }

    public List<Company> getCompanies() { return companies; }
    public int getCurrentDay() { return currentDay; }
    public String getLatestNews() { return latestNews; }
}