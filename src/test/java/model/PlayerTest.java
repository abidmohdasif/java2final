package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void buyReducesCashAndAddsStock() {
        Company company = new Company("Test Corp", "TEST", "Test stock", 150.00, currentPrice -> currentPrice);
        Player player = new Player(1000.00);

        assertTrue(player.canAfford(company.getCurrentPrice(), 2));

        player.buy(company, 2);

        assertEquals(700.00, player.getCash(), 1e-6);
        assertEquals(2, player.getPortfolio().getShares("TEST"));
    }

    @Test
    void sellIncreasesCashAndRemovesShares() {
        Company company = new Company("Test Corp", "TEST", "Test stock", 100.00, currentPrice -> currentPrice);
        Player player = new Player(500.00);
        player.buy(company, 3);

        player.sell(company, 2);

        assertEquals(400.00, player.getCash(), 1e-6);
        assertEquals(1, player.getPortfolio().getShares("TEST"));
    }

    @Test
    void sellingMoreThanHeldDoesNotChangeCashOrHoldings() {
        Company company = new Company("Test Corp", "TEST", "Test stock", 100.00, currentPrice -> currentPrice);
        Player player = new Player(500.00);
        player.buy(company, 2);

        player.sell(company, 5);

        assertEquals(300.00, player.getCash(), 1e-6);
        assertEquals(2, player.getPortfolio().getShares("TEST"));
    }
}
