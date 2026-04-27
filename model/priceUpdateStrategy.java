package com.portfolio.model;

public interface PriceUpdateStrategy {
    double updatePrice(double currentPrice);
}

class BullMarketStrategy implements PriceUpdateStrategy {
    public double updatePrice(double currentPrice) {
        double change = 1 + (Math.random() * 0.04); // 0–4% gain
        return Math.round(currentPrice * change * 100.0) / 100.0;
    }
}

class VolatileStrategy implements PriceUpdateStrategy {
    public double updatePrice(double currentPrice) {
        double change = 0.92 + (Math.random() * 0.16); // -8% to +8%
        return Math.round(currentPrice * change * 100.0) / 100.0;
    }
}
