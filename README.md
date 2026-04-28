# java2final
30-Day Trading Simulator
A terminal-based stock trading simulation game written in Java. You start with $100,000 and have 30 days to grow your portfolio to $120,000. If not, your boss fires you. Each day, stock prices shift based on the market strategies and random news events that happen. 25 companies are in the game and all fictitious. 

In-Game Commands
BUY <TICKER> <QTY>Buy shares of a company
SELL <TICKER> <QTY>Sell shares you own
NEXT Advance to the next trading day
QUIT Exit the game

Factory Pattern
Creating 25 company objects with their names, tickers, descriptions, prices, and strategies in one controlled place 

Observer Pattern
Every time nextDay() is called, all three views need to refresh. Instead of calling each view manually from the controller, the simulator maintains a list of observers and notifies them all at once. This makes it easy to add or remove views without touching any game logic.

src/main/java/
├── Main.java                  
│
├── model/                    
│   ├── Company.java          
│   ├── MarketDataFactory.java 
│   ├── MarketObserver.java    
│   ├── MarketSimulator.java  
│   ├── Player.java            
│   ├── Portfolio.java        
│   └── PriceUpdateStrategy.java 
│
├── controller/
│   └── TradeController.java   
│
└── view/
    ├── MarketView.java        
    ├── PortfolioView.java   
    ├── EndGameView.java      
    └── CompanyDetails.java   

    
