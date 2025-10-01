import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        double[] stockPrices = {100.5, 102.3, 98.7, 105.2, 101.0, 99.8, 104.6, 103.1, 100.0, 102.5};

    System.out.println("Average Price: " + calculateAveragePrice(stockPrices));
    System.out.println("Maximum Price: " + findMaximumPrice(stockPrices));
    System.out.println("Occurrences of 102.5: " + countOccurrences(102.5, stockPrices));
    System.out.println("Cumulative Prices: " + computeCumulativeSum(stockPrices));
    
    
    // System.out.println("Minimum Price: " + findMinimumPrice(stockPrices));
    }

    public static double calculateAveragePrice(double[] prices) {
        double total = 0;

        for (int index = 0; index < prices.length; index++) {
            total += prices[index];
        }

        return (total / prices.length);
    }  
    
    public static double findMaximumPrice (double[] prices) {
        double maxPrice = prices[0];

        for (int index = 1; index < prices.length; index++) {
            if (maxPrice < prices[index]) {
                maxPrice = prices[index];
            }
        }

        return maxPrice;
    }

    public static int countOccurrences (double targetPrice, double[] prices) {
        int counter = 0;

        for (int index = 0; index < prices.length; index++) {
            if (targetPrice == prices[index]) {
                counter++;
            }
        }

        return counter;
    }

    public static ArrayList<Double> computeCumulativeSum (double[] prices) {
        
        double currentValue = 0;
        ArrayList<Double> cumulativePrices = new ArrayList<Double>();

        for (int index = 0; index < prices.length; index++) {
            currentValue += prices[index];
            cumulativePrices.add(currentValue);
        }

        return cumulativePrices;

    }
}
