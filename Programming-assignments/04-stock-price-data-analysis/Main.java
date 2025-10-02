/*
 ================================================================
 *  Stock Price Analysis Program
 * ================================================================
 *
 *  Description:
 *  ------------
 *  This program demonstrates basic stock price analysis using arrays 
 *  and ArrayLists in Java. It processes a list of stock prices and 
 *  performs various calculations such as:
 *
 *     - Average stock price
 *     - Maximum and minimum stock price
 *     - Occurrences of a given stock price
 *     - Cumulative (running) sums of stock prices
 *     - Daily changes between consecutive stock prices
 *
 *  Educational Purpose:
 *  --------------------
 *  Through this program, I learned how to:
 *
 *     1. Use arrays (double[]) to store fixed sets of numerical data.
 *     2. Use ArrayList<Double> to store data dynamically, 
 *        demonstrating how objects (Double) differ from primitives (double).
 *     3. Write and use methods in Java to break problems into smaller, 
 *        reusable parts.
 *     4. Perform basic operations on arrays: traversal, searching, and aggregation.
 *     5. Round floating-point numbers (e.g., daily stock changes to 2 decimals).
 *
 *  Key Concepts Learned:
 *  ---------------------
 *     - The difference between primitive types (double) and wrapper classes (Double).
 *     - Iterating through arrays with both enhanced for-loops and indexed for-loops.
 *     - Returning values from methods and printing results in the main program.
 *     - Using ArrayLists when the size of the data can change dynamically.
 *
 * ================================================================
 *
 *  Method Summary (with Examples):
 *  -------------------------------
 *
 *  1. calculateAveragePrice(double[] prices)
 *       - Calculates the average stock price from all elements in the array.
 *       Example:
 *          Input:  {100.0, 200.0, 300.0}
 *          Output: 200.0
 *
 *  2. findMaximumPrice(double[] prices)
 *       - Finds the highest stock price in the array.
 *       Example:
 *          Input:  {50.0, 80.0, 70.0}
 *          Output: 80.0
 *
 *  3. countOccurrences(double targetPrice, double[] prices)
 *       - Counts how many times a specific stock price occurs in the array.
 *       Example:
 *          Input:  prices = {10.0, 20.0, 10.0}, targetPrice = 10.0
 *          Output: 2
 *
 *  4. computeCumulativeSum(double[] prices)
 *       - Builds a running total of stock prices, storing results in an ArrayList.
 *       Example:
 *          Input:  {10.0, 20.0, 30.0}
 *          Output: [10.0, 30.0, 60.0]
 *
 *  5. findMinimumPrice(double[] prices)
 *       - Finds the lowest stock price in the array.
 *       Example:
 *          Input:  {50.0, 80.0, 40.0}
 *          Output: 40.0
 *
 *  6. dailyChange(double[] prices)
 *       - Calculates the difference between each day’s stock price and the previous day,
 *         rounding values to 2 decimal places.
 *       Example:
 *          Input:  {100.0, 105.5, 103.0}
 *          Output: [5.5, -2.5]
 *
 * ================================================================
 */

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Initialize an array of stock prices
        double[] stockPrices = { 100.5, 102.3, 98.7, 105.2, 101.0, 99.8, 104.6, 103.1, 100.0, 102.5 };

        // Create an ArrayList to store stock prices
        ArrayList<Double> stockPrices2 = new ArrayList<Double>();

        // Copy elements from array into ArrayList
        for (double price : stockPrices) {
            stockPrices2.add(price);
        }

        // Call and print results of different stock price analysis methods
        System.out.println("Average Price: " + calculateAveragePrice(stockPrices));
        System.out.println("Maximum Price: " + findMaximumPrice(stockPrices));
        System.out.println("Occurrences of 102.5: " + countOccurrences(102.5, stockPrices));
        System.out.println("Cumulative Prices: " + computeCumulativeSum(stockPrices));

        // Extra "bonus" methods
        System.out.println("\n(Bonus)=======================================");
        System.out.println("Minimum Price: " + findmMinimumPrice(stockPrices));
        System.out.println("Daily Stock Changes: " + dailyChange(stockPrices));
    }

    // Calculate average price of stocks
    public static double calculateAveragePrice(double[] prices) {
        double total = 0;

        for (int index = 0; index < prices.length; index++) {
            total += prices[index];
        }

        return (total / prices.length);
    }

    // Find the highest stock price
    public static double findMaximumPrice(double[] prices) {
        double maxPrice = prices[0];

        for (int index = 1; index < prices.length; index++) {
            if (maxPrice < prices[index]) {
                maxPrice = prices[index];
            }
        }

        return maxPrice;
    }

    // Count how many times a given price occurs
    public static int countOccurrences(double targetPrice, double[] prices) {
        int counter = 0;

        for (int index = 0; index < prices.length; index++) {
            if (targetPrice == prices[index]) {
                counter++;
            }
        }

        return counter;
    }

    // Compute running total of stock prices
    public static ArrayList<Double> computeCumulativeSum(double[] prices) {

        double currentValue = 0;
        ArrayList<Double> cumulativePrices = new ArrayList<Double>();

        for (int index = 0; index < prices.length; index++) {
            // add current price to running total
            currentValue += prices[index];

            // store cumulative sum
            cumulativePrices.add(currentValue);
        }

        return cumulativePrices;
    }

    // Bonus Methods

    // Find the lowest stock price
    public static double findmMinimumPrice(double[] prices) {
        double minPrice = prices[0];

        for (int index = 1; index < prices.length; index++) {
            if (minPrice > prices[index]) {
                minPrice = prices[index];
            }
        }

        return minPrice;
    }

    // Calculate daily changes in stock prices
    public static ArrayList<Double> dailyChange(double[] prices) {
        ArrayList<Double> changes = new ArrayList<Double>();
        double change;

        for (int index = 0; index < prices.length - 1; index++) {
            // difference between consecutive days
            change = prices[index + 1] - prices[index];

            // round to 2 decimals
            change = Math.round(change * 100.0) / 100.0;

            // push the change in the ArrayList
            changes.add(change);
        }

        return changes;
    }
}
