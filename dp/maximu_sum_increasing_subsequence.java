package DP;

import java.util.Arrays;

public class maximu_sum_increasing_subsequence {
    public int maxSumIS(int arr[], int n)
    {
        int[][] dp = new int[n][n+1] ;
        for (int[] row: dp){
            Arrays.fill(row , -1);
        }
        return maxSumIS(0 , -1 ,  n , arr , dp) ;
    }
    public static int maxSumIS(int ind , int perv_ind , int n , int[] nums , int[][] dp){
        // base case of the
        if (ind == n) return  0 ;

        if (dp[ind][perv_ind +1] != -1)return dp[ind][perv_ind +1] ;
        int nottake = 0 + maxSumIS(ind +1 ,perv_ind , n , nums , dp) ;
        int take = 0 ;
        if (perv_ind == -1 || nums[ind] > nums[perv_ind]) {
            take  =  nums[ind] + maxSumIS(ind+1 , ind  , n , nums,dp) ;

        }
        return dp[ind][perv_ind +1] = Math.max(nottake , take) ;

    }
}
