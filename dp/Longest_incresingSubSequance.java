package DP;

import java.util.Arrays;

public class Longest_incresingSubSequance {
    public static void main(String[] args) {

    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length ;
        /* how to find the what would be the len of the dp
        1 - check the two moving variable in the function
        2 - check  what is the end point and Strat  point
        3  -  in the case of that we have  the pervious index  is -1 so we have chage the cordanite  of the index to 1 to n

        */
        int[][] dp = new int[n][n+1] ;
        for (int[] row: dp){
            Arrays.fill(row , -1);
        }
        return lengthOfLIS(0 , -1 , n , nums , dp) ;



    }
    public int lengthOfLIS(int ind , int perv_ind , int n , int[] nums){
        // base case of the
        if (ind == n) return  0 ;
        int len = 0 ;

        len = 0 + lengthOfLIS(ind +1 ,perv_ind , n , nums) ;

        if (perv_ind == -1 || nums[ind] > nums[perv_ind]) {
            int take  = 1 + lengthOfLIS(ind+1 , ind  , n , nums) ;
            len = Math.max(len , take) ;
        }
        return len ;

    }
    public static int lengthOfLIS(int ind , int perv_ind , int n , int[] nums , int[][] dp){
        // base case of the
        if (ind == n) return  0 ;

        if (dp[ind][perv_ind +1] != -1)return dp[ind][perv_ind +1] ;
        int nottake = 0 + lengthOfLIS(ind +1 ,perv_ind , n , nums , dp) ;
        int take = 0 ;
        if (perv_ind == -1 || nums[ind] > nums[perv_ind]) {
           take  = 1 + lengthOfLIS(ind+1 , ind  , n , nums,dp) ;

        }
        return dp[ind][perv_ind +1] = Math.max(nottake , take) ;

    }
}

