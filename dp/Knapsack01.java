package DP;

import java.util.Arrays;

public class Knapsack01 {
    public static void main(String[] args) {
        int wt[] = {3, 2, 5};
        int val[] = {30, 40, 60};
        int n = wt.length;
        int W = 6;
        int[][] dp = new int[n][W + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(knapsack(wt, val, n - 1, 6, dp));
    }

    //  todo resursion approach
    static int knapsack(int[] weight, int[] value, int ind, int maxWeight) {

        // Base case of the
        if (ind == 0) {
            // if there first case
            if (weight[0] <= maxWeight) return value[0];
            return 0;
        }
        // now try all the possibilities
        int nottake = 0 + knapsack(weight, value, ind - 1, maxWeight);

        int take = Integer.MIN_VALUE; // beause we have to find the max of both value
        // check a condation
        if (weight[ind] <= maxWeight) {
            take = value[ind] + knapsack(weight, value, ind - 1, maxWeight - weight[ind]);
        }

        return Math.max(nottake, take);


    }

    static int knapsack(int[] weight, int[] value, int ind, int maxWeight, int[][] dp) {

        // Base case of the
        if (ind == 0) {
            // if there first case
            if (weight[0] <= maxWeight) return value[0];
            return 0;
        }
        // check it is already use or not
        if (dp[ind][maxWeight] != -1) return dp[ind][maxWeight];
        // now try all the possibilities
        int nottake = 0 + knapsack(weight, value, ind - 1, maxWeight, dp);

        int take = Integer.MIN_VALUE; // beause we have to find the max of both value
        // check a condation
        if (weight[ind] <= maxWeight) {
            take = value[ind] + knapsack(weight, value, ind - 1, maxWeight - weight[ind], dp);
        }

        return dp[ind][maxWeight] = Math.max(nottake, take);


    }
    static  int knapsack(int n,int[] weight, int[] value,  int maxWeight){
        int[][] dp = new int[n][maxWeight+1] ;

        for (int i = weight[0]; i <= maxWeight ; i++) {
            dp[0][i] = value[0] ;

        }
        for (int ind = 1; ind < n ; ind++) {
            for (int cap = 0; cap <= maxWeight; cap++) {
                int  notTaken = 0 + dp[ind -1][cap] ;
                int taken = Integer.MIN_VALUE ;

                if(weight[ind] <= cap){
                    taken = value[ind] + dp[ind-1][cap - weight[ind]] ;
                }
                dp[ind][cap] = Math.max(notTaken , taken) ;


            }

        }
        return dp[n-1][maxWeight] ;
    }

}
