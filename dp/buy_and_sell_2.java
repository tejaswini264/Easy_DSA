package DP;

import java.util.Arrays;

public class buy_and_sell_2 {
    public int maxProfit1(int[] prices) {
        int n = prices.length ;
        int[][] dp = new int[n][2] ;
        for (int[] row : dp){
            Arrays.fill(row ,  -1);
        }
        return  findTheprofit(0 , 0  , prices , prices.length , dp) ;

    }
    static  int  findTheprofit(int ind , int buy , int[] prices , int n ){

        // base case
        if (ind == n ) return  0 ;
        int profit = 0 ;


        // there are 2 possibility
        if (buy == 0){
            profit =  Math.max( -prices[ind] + findTheprofit(ind+1 , 0 , prices , n)  , 0 + findTheprofit(ind+1 , 1 , prices , n) );

        }
        else {
            profit = Math.max(prices[ind] + findTheprofit(ind+1  , 1 , prices , n) ,0+ findTheprofit(ind+1 ,0 , prices , n) ) ;

        }
        return profit ;
    }

    static  int  findTheprofit(int ind , int buy , int[] prices , int n , int[][] dp ){

        // base case
        if (ind == n ) return  0 ;
        int profit = 0 ;
       if (dp[ind][buy] != -1) return  dp[ind][buy] ;

        // there are 2 possibility
        if (buy == 1){
            profit =  Math.max( -prices[ind] + findTheprofit(ind+1 , 0 , prices , n)  , 0 + findTheprofit(ind+1 , 1 , prices , n) );

        }
        else {
            profit = Math.max(prices[ind] + findTheprofit(ind+1  , 1 , prices , n) ,0+ findTheprofit(ind+1 ,0 , prices , n) ) ;

        }
        return dp[ind][buy] =  profit ;
    }
    public int maxProfit(int[] prices) {
        int  n = prices.length ;
        // creat a dp
        int[][] dp = new int[n+1][2] ;

        // base case
        dp[n][0] = dp[n][1] =  0 ;
        for (int ind = n-1; ind >=0 ; ind--) {
            for (int buy = 0; buy <=1 ; buy++) {
                int profit = 0 ;
                if (buy == 1){
                    profit =  Math.max( -prices[ind] + dp[ind+1][0]  , 0 + dp[ind+1][1] );

                }
                else {
                    profit = Math.max(prices[ind] + dp[ind+1][1]  ,0+  dp[ind+1][0]) ;


                }
                dp[ind][buy] = profit ;


            }

        }
        return dp[0][1] ;
    }
}
