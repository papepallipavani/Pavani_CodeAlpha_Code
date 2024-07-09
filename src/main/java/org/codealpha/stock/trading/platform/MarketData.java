package org.codealpha.stock.trading.platform;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MarketData {
    private Map<String, Double> stockPrices;

    public MarketData() {
        stockPrices = new HashMap<>();
        stockPrices.put("TATAPOWER", 432.75);
        stockPrices.put("UNIONBANK", 134.11);
        stockPrices.put("YESBANK", 23.85);
        stockPrices.put("IOB", 63.21);
        stockPrices.put("HDFCBANK", 1730.60);
        stockPrices.put("TATAMOTORS", 981.30);
    }

    public void updatePrices() {
        Random random = new Random();
        for (String symbol : stockPrices.keySet()) {
            double currentPrice = stockPrices.get(symbol);
            double priceChange = currentPrice * 0.02 * (random.nextDouble() - 0.5);
            double newPrice = currentPrice + priceChange;
            stockPrices.put(symbol, newPrice);
        }
    }

    public double getPrice(String symbol) {
        return stockPrices.getOrDefault(symbol, 0.0);
    }

    public Map<String, Double> getStockPrices() {
        return stockPrices;
    }

    public void setStockPrices(Map<String, Double> stockPrices) {
        this.stockPrices = stockPrices;
    }
}
