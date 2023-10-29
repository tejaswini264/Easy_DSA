package DP;

public class BestTime_to_buy_and_sell {
    public int maxProfit(int[] prices) {
        // we have to find the min elelment of the  left side when he is bought
        int mini = prices[0] ;
        int profit   = 0 ;

        for (int i = 0; i < prices.length; i++) {
            int cost = prices[i] - mini ;

            profit = Math.max(cost , profit);
            mini = Math.min(mini , prices[i]) ;

        }
        return profit ;

    }

}
