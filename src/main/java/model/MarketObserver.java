package model;

/**
 * Observer interface for receiving updates from the {@link MarketSimulator}.
 * <p>
 * Classes that implement this interface are notified whenever the market
 * state changes (e.g., at the end of each simulation day). This follows
 * the Observer design pattern.
 * </p>
 */

public interface MarketObserver {
    /**
     * Called when the market state has changed.
     *
     * @param market the {@link MarketSimulator} whose state has been updated
     */
    
    void update(MarketSimulator market);
}