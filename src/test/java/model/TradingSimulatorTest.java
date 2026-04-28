package model;
import org.junit.jupiter.api.Test;

import controller.TradeController;
import static org.junit.jupiter.api.Assertions.*;

public class TradingSimulatorTest {

    // Portfolio Tests
    @Test
    void testAddStock() {
        Portfolio p = new Portfolio();
        p.addStock("ZENE", 5);
        assertEquals(5, p.getShares("ZENE"));
    }

    @Test
    void testRemoveStock() {
        Portfolio p = new Portfolio();
        p.addStock("ZENE", 5);
        p.removeStock("ZENE", 3);
        assertEquals(2, p.getShares("ZENE"));
    }

    @Test
    void testGetSharesUnknownTicker() {
        Portfolio p = new Portfolio();
        assertEquals(0, p.getShares("FAKE"));
    }

    // Player Tests
    @Test
    void testPlayerStartingCash() {
        Player player = new Player(1000.0);
        assertEquals(1000.0, player.getCash(), 0.001);
    }

    @Test
    void testCanAffordTrue() {
        Player player = new Player(1000.0);
        assertTrue(player.canAfford(100.0, 5));
    }

    @Test
    void testCanAffordFalse() {
        Player player = new Player(50.0);
        assertFalse(player.canAfford(100.0, 1));
    }

    @Test
    void testBuyDeductsCash() {
        Player player = new Player(1000.0);
        Company c = new Company("Test", "TEST", "desc", 100.0, price -> price);
        player.buy(c, 3);
        assertEquals(700.0, player.getCash(), 0.001);
    }

    @Test
    void testSellAddsCash() {
        Player player = new Player(1000.0);
        Company c = new Company("Test", "TEST", "desc", 100.0, price -> price);
        player.buy(c, 5);
        player.sell(c, 2);
        assertEquals(700.0, player.getCash(), 0.001);
    }

    // Company Tests
    @Test
    void testCompanyGetters() {
        Company c = new Company("Test Corp", "TEST", "A company", 100.0, price -> price);
        assertEquals("Test Corp", c.getName());
        assertEquals("TEST", c.getTicker());
        assertEquals(100.0, c.getCurrentPrice(), 0.001);
    }

    @Test
    void testApplyEventImpact() {
        Company c = new Company("Test", "TEST", "desc", 100.0, price -> price);
        c.applyEventImpact(1.25);
        assertEquals(125.0, c.getCurrentPrice(), 0.01);
    }

    // Market Simulator Tests
    @Test
    void testMarketStartsOnDayOne() {
        MarketSimulator market = new MarketSimulator();
        assertEquals(1, market.getCurrentDay());
    }

    @Test
    void testNextDayAdvancesDay() {
        MarketSimulator market = new MarketSimulator();
        market.nextDay();
        assertEquals(2, market.getCurrentDay());
    }

    @Test
    void testFindCompanyExists() {
        MarketSimulator market = new MarketSimulator();
        assertNotNull(market.findCompany("ZENE"));
    }

    @Test
    void testFindCompanyNotFound() {
        MarketSimulator market = new MarketSimulator();
        assertNull(market.findCompany("FAKE"));
    }

    // Controller Tests
    @Test
    void testGameOverAfter30Days() {
        MarketSimulator market = new MarketSimulator();
        TradeController ctrl = new TradeController(market, new Player(100000.0));
        for (int i = 0; i < 30; i++) ctrl.advanceDay();
        assertTrue(ctrl.isGameOver());
    }

    @Test
    void testAdvanceDayUpdatesMarket() {
        MarketSimulator market = new MarketSimulator();
        TradeController ctrl = new TradeController(market, new Player(100000.0));
        ctrl.advanceDay();
        assertEquals(2, market.getCurrentDay());
    }

    @Test
    void testGameNotOverAtStart() {
        MarketSimulator market = new MarketSimulator();
        TradeController ctrl = new TradeController(market, new Player(100000.0));
        assertFalse(ctrl.isGameOver());
    }

    @Test
    void testBuyFailsWithNoMoney() {
        MarketSimulator market = new MarketSimulator();
        Player player = new Player(1.0);
        TradeController ctrl = new TradeController(market, player);
        ctrl.processBuy("QUAN", 10);
        assertEquals(0, player.getPortfolio().getShares("QUAN"));
    }

    @Test
    void testMarketViewDoesNotCrash() {
        MarketSimulator market = new MarketSimulator();
        MarketView view = new MarketView();
        assertDoesNotThrow(() -> view.update(market));
    }

    @Test
    void testPortfolioViewDoesNotCrash() {
        MarketSimulator market = new MarketSimulator();
        Player player = new Player(100000.0);
        PortfolioView view = new PortfolioView(player);
        assertDoesNotThrow(() -> view.update(market));
    }
}