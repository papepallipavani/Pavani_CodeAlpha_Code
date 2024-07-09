package org.codealpha.stock.trading.platform;

import org.codealpha.stock.trading.platform.model.Stock;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private Map<String, Stock> stocks;

    public Portfolio() {
        stocks = new HashMap<>();
    }

    public void addStock(Stock stock) {
        if (stocks.containsKey(stock.getSymbol())) {
            Stock existingStock = stocks.get(stock.getSymbol());
            existingStock.setQuantity(existingStock.getQuantity() + stock.getQuantity());
        } else {
            stocks.put(stock.getSymbol(), stock);
        }
    }

    public void removeStock(String symbol, int quantity) {
        if (stocks.containsKey(symbol)) {
            Stock existingStock = stocks.get(symbol);
            int remainingQuantity = existingStock.getQuantity() - quantity;
            if (remainingQuantity <= 0) {
                stocks.remove(symbol);
            } else {
                existingStock.setQuantity(remainingQuantity);
            }
        }
    }

    public Map<String, Stock> getStocks() {
        return stocks;
    }

    public double calculatePortfolioValue() {
        double portfolioValue = 0.0;
        for (Stock stock : stocks.values()) {
            portfolioValue += stock.getPrice() * stock.getQuantity();
        }
        return portfolioValue;
    }
}
