package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Simulates a stock market over a 30-day trading period.
 * <p>
 * Manages a list of {@link Company} objects, advances the simulation day by day,
 * triggers random market events, and notifies registered {@link MarketObserver}s
 * of any state changes. Follows the Observer design pattern.
 * </p>
 */

public class MarketSimulator {
    private List<Company> companies;
    private int currentDay;
    private List<MarketObserver> observers;
    private String latestNews = "Market open. Good luck!";

    /**
     * Constructs a new MarketSimulator, initializing all companies from
     * {@link MarketDataFactory}, starting on day 1 with no observers.
     */

    public MarketSimulator() {
        this.companies = MarketDataFactory.createAllCompanies();
        this.currentDay = 1;
        this.observers = new ArrayList<>();
    }

    /**
     * Registers a {@link MarketObserver} to receive market update notifications.
     *
     * @param observer the observer to attach
     */

    public void attach(MarketObserver observer) {
        observers.add(observer);
    }

    /**
     * Notifies all registered {@link MarketObserver}s of the current market state.
     */

    public void notifyObservers() {
        for (MarketObserver observer : observers) {
            observer.update(this);
        }
    }

    /**
     * Advances the simulation by one day.
     * <p>
     * Each call increments the day counter, updates every company's stock price
     * via its {@link PriceUpdateStrategy}, potentially triggers a random market
     * event, and notifies all registered observers.
     * </p>
     */

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

    /**
     * Randomly triggers a major market event affecting a single company.
     * <p>
     * There is a 15% chance each day that one randomly selected company
     * experiences either a 25% price surge or a 25% price crash, with
     * the latest news headline updated accordingly.
     * </p>
     */

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

    /**
     * Searches for a company by its ticker symbol (case-insensitive).
     *
     * @param ticker the stock ticker symbol to search for
     * @return the matching {@link Company}, or {@code null} if not found
     */

    public Company findCompany(String ticker) {
        for (Company c: companies) {
            if (c.getTicker().equalsIgnoreCase(ticker)) {
                return c;
            }
        }
        return null;
    }
    
    /**
     * Returns the list of all companies in the simulation.
     *
     * @return a {@link List} of {@link Company} objects
     */

    public List<Company> getCompanies() { 
        return companies; 
    }

    /**
     * Returns the current simulation day.
     *
     * @return the current day number (starts at 1)
     */

    public int getCurrentDay() { 
        return currentDay; 
    }

    /**
     * Returns the latest market news headline.
     *
     * @return a string describing the most recent market event or day summary
     */

    public String getLatestNews() { 
        return latestNews; 
    }
}