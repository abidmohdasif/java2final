public MarketSimulator() {
    this.companies = MarketDataFactory.createAllCompanies();
    this.currentDay = 1;
}

public Company findCompany(String ticker) {
    for (Company c: companies) {
        if (c.getTicker().equals(ticker)) {
            return c;
        }
    }
    return null;
}
