package org.codealpha.stock.trading.platform;

import org.codealpha.stock.trading.platform.model.Stock;

import java.util.Scanner;

public class TradingPlatformService {

    private MarketData marketData;
    private Portfolio portfolio;

    public TradingPlatformService() {
        marketData = new MarketData();
        portfolio = new Portfolio();
    }

    public void displayMarketData() {
        System.out.println("Current Market Prices:");
        for (String symbol : marketData.getStockPrices().keySet()) {
            double price = marketData.getPrice(symbol);
            System.out.println(symbol + ": ₹" + price);
        }
    }

    public void buyStock(String symbol, int quantity) {
        double price = marketData.getPrice(symbol);
        Stock stock = new Stock(symbol, price, quantity);
        portfolio.addStock(stock);
        System.out.println(quantity + " shares of " + symbol + " bought at ₹" + price + " each.");
    }

    public void sellStock(String symbol, int quantity) {
        if (portfolio.getStocks().containsKey(symbol)) {
            Stock stock = portfolio.getStocks().get(symbol);
            if (stock.getQuantity() >= quantity) {
                stock.setQuantity(stock.getQuantity() - quantity);
                System.out.println(quantity + " shares of " + symbol + " sold.");
            } else {
                System.out.println("Not enough shares of " + symbol + " to sell.");
            }
        } else {
            System.out.println("You do not own any shares of " + symbol + ".");
        }
    }

    public void displayPortfolio() {
        System.out.println("Portfolio:");
        for (Stock stock : portfolio.getStocks().values()) {
            System.out.println(stock.getSymbol() + ": " + stock.getQuantity() + " shares");
        }
        double portfolioValue = portfolio.calculatePortfolioValue();
        System.out.println("Total Portfolio Value: ₹" + portfolioValue);
    }

    public static void main(String[] args) {
        TradingPlatformService tradingPlatform = new TradingPlatformService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. View Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    tradingPlatform.displayMarketData();
                    break;
                case 2:
                    System.out.print("Enter stock name: ");
                    String buySymbol = scanner.nextLine();
                    System.out.print("Enter quantity to buy: ");
                    int buyQuantity = scanner.nextInt();
                    tradingPlatform.buyStock(buySymbol, buyQuantity);
                    break;
                case 3:
                    System.out.print("Enter stock symbol: ");
                    String sellSymbol = scanner.nextLine();
                    System.out.print("Enter quantity to sell: ");
                    int sellQuantity = scanner.nextInt();
                    tradingPlatform.sellStock(sellSymbol, sellQuantity);
                    break;
                case 4:
                    tradingPlatform.displayPortfolio();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
