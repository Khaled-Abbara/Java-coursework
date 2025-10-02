import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        double[] stockPrices = { 100.5, 102.3, 98.7, 105.2, 101.0, 99.8, 104.6, 103.1, 100.0, 102.5 };

        ArrayList<Double> stockPrices2 = new ArrayList<Double>();

        for (double price : stockPrices) {
            stockPrices2.add(price);
        }

        System.out.println("Average Price: " + calculateAveragePrice(stockPrices));
        System.out.println("Maximum Price: " + findMaximumPrice(stockPrices));
        System.out.println("Occurrences of 102.5: " + countOccurrences(102.5, stockPrices));
        System.out.println("Cumulative Prices: " + computeCumulativeSum(stockPrices));
        System.out.println("\n(Bonus)=======================================");
        System.out.println("Minimum Price: " + findmMinimumPrice(stockPrices));
        System.out.println("Daily Stock Changes: " + dailyChange(stockPrices));
    }

    public static double calculateAveragePrice(double[] prices) {
        double total = 0;

        for (int index = 0; index < prices.length; index++) {
            total += prices[index];
        }

        return (total / prices.length);
    }

    public static double findMaximumPrice(double[] prices) {
        double maxPrice = prices[0];

        for (int index = 1; index < prices.length; index++) {
            if (maxPrice < prices[index]) {
                maxPrice = prices[index];
            }
        }

        return maxPrice;
    }

    public static int countOccurrences(double targetPrice, double[] prices) {
        int counter = 0;

        for (int index = 0; index < prices.length; index++) {
            if (targetPrice == prices[index]) {
                counter++;
            }
        }

        return counter;
    }

    public static ArrayList<Double> computeCumulativeSum(double[] prices) {

        double currentValue = 0;
        ArrayList<Double> cumulativePrices = new ArrayList<Double>();

        for (int index = 0; index < prices.length; index++) {
            currentValue += prices[index];
            cumulativePrices.add(currentValue);
        }

        return cumulativePrices;

    }

    // Bonus Methods

    public static double findmMinimumPrice(double[] prices) {
        double minPrice = prices[0];

        for (int index = 1; index < prices.length; index++) {
            if (minPrice > prices[index]) {
                minPrice = prices[index];
            }
        }

        return minPrice;
    }

    public static ArrayList<Double> dailyChange(double[] prices) {
        ArrayList<Double> changes = new ArrayList<Double>();
        double change;

        for (int index = 0; index < prices.length - 1; index++) {
            change = prices[index + 1] - prices[index];
            change = Math.round(change * 100.0) / 100.0;
            changes.add(change);
        }

        return changes;
    }
}
