package DP;

import java.util.Arrays;

public class houshRobber {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1} ;
        int ind = nums.length -1 ;
        System.out.println(rob_tabulation(ind , nums));
    }
    public int rob(int ind  , int[] nums) {
        // base case
        if (ind == 0 ) return  nums[ind] ;
        if (ind < 0 ) return  0 ;

        int pick = nums[ind] + rob(ind - 2 , nums) ;
        int notpick =  rob(ind -1 , nums) ;

        return Math.max(pick , notpick) ;

    }

    // todo 2 memorazation
    public static int rob_memo(int ind , int[] nums){
        int[] dp  = new  int[ind+1] ;
        Arrays.fill(dp , -1 );
        // base case
        if (ind == 0 ) return  nums[ind] ;
        if (ind < 0) return  0 ;
        // check for we are already  do it or not
        if (dp[ind] != -1) return  dp[ind] ;
        int pick = nums[ind] + rob_memo(ind - 2 , nums) ;
        int notpick = 0+  rob_memo(ind -1 , nums) ;

        return dp[ind] = Math.max(pick , notpick ) ;
    }
    // tabulation method
    public static int rob_tabulation(int ind , int[] nums){
        //  declered an dp array
        int[] dp  = new int[ind+1] ;
        Arrays.fill(dp , -1 );
        // how  to define the base case
        dp[0] = nums[0] ;
        // keep in mind that you have to handel the -ve indexing as well

        // start the loop from 1 to n
        for (int i = 1; i <=ind  ; i++) {

            int pick = nums[i] ;
            // keep in mind that you have to handel the -ve indexing as well
            if (i > 1) pick += dp[i-2] ;
            int notpick =  0+ dp[i-1] ;

            // so we have to store the maximum
            dp[i] = Math.max(pick , notpick );
        }
        return dp[ind] ;
    }

}
