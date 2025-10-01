public class Main {
    double[] stockPrices = {100.5, 102.3, 98.7, 105.2, 101.0, 99.8, 104.6, 103.1, 100.0, 102.5};


    public static double calculateAveragePrice(double[] prices) {
        double total = 0;

        for (int index = 0; index < prices.length; index++) {
            total += prices[index];
        }

        return (total / prices.length);
    }  
    
    
}
