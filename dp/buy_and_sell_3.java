package DP;

import java.util.Arrays;

public class buy_and_sell_3 {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        // Creating a 3D dp array of size [n][2][3]
        int[][][] dp = new int[n][2][3];

        // Initialize the dp array with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // Calculate and return the maximum profit
        return getAns(prices, n, 0, 0, 2, dp);

    }
    private static int buy_and_sell(int ind , int buy , int cap , int[] prices){
        // base case
        if (ind == prices.length || cap == 0) return  0 ;
        int op1 = 0 ;
        int op2 = 0 ;
        // if we buy the stock
        if (buy == 0){
            op1 =  0 + buy_and_sell(ind+1 , 0 , cap , prices) ;
            op2 = -prices[ind] + buy_and_sell(ind+1 , 1 , cap , prices) ;

        }
        else {
            op1 = 0 + buy_and_sell(ind+1 , 1 , cap , prices) ;
            op2 = prices[ind] + buy_and_sell(ind+1 , 0  , cap -1  , prices) ;
        }
        return Math.max(op1 ,op2);
    }
    //  todo  memorazation process 
    static int getAns(int[] Arr, int n, int ind, int buy, int cap, int[][][] dp) {
        // Base case: If we have processed all stocks or have no capital left, return 0 profit
        if (ind == n || cap == 0)
            return 0;

        // If the result for this state is already calculated, return it
        if (dp[ind][buy][cap] != -1)
            return dp[ind][buy][cap];

        int profit = 0;

        if (buy == 0) { // We can buy the stock
            profit = Math.max(0 + getAns(Arr, n, ind + 1, 0, cap, dp),
                    -Arr[ind] + getAns(Arr, n, ind + 1, 1, cap, dp));
        }

        if (buy == 1) { // We can sell the stock
            profit = Math.max(0 + getAns(Arr, n, ind + 1, 1, cap, dp),
                    Arr[ind] + getAns(Arr, n, ind + 1, 0, cap - 1, dp));
        }

        // Store the calculated profit in the dp array and return it
        return dp[ind][buy][cap] = profit;
    }

}
