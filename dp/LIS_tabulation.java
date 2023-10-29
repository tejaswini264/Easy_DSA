package DP;

import java.util.Arrays;

public class LIS_tabulation {

    static int lengthOfLIS(int[] nums){
        int n = nums.length;
        // declered my dp
        int[][] dp = new int[n+1][n+1];

        for (int ind = n-1; ind >= 0 ; ind--) {
            for (int prev = ind-1; prev >= -1  ; prev--) {
                // if you dont want to take the element
                int len = 0 + dp[ind +1 ][prev +1];
                // if you want to take the elelment
                if (prev == -1   || nums[ind] > nums[prev]){
                    len= Math.max(len, 1 + dp[ind+1][ind+1]);
                }
                dp[ind][prev+1] = len;

            }

        }
        return dp[0][-1+1];
    }
    static int lengthOfLIS1(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = Integer.MIN_VALUE;
        for (int ind = 0; ind < n; ind++) {
            for (int prev = 0; prev < ind; prev++) {
                if (nums[prev] < nums[ind]){
                    dp[ind] = Math.max(1+dp[prev],dp[ind]);
                }
            }
            max = Math.max(max,dp[ind]);

        }
        return max;

    }
}
