package DP;

import java.util.Arrays;

public class houshRober2 {
    public int rob(int[] nums) {
        int  n = nums.length ;
        int[] arr1 = new int[n -1] ;
        int[] arr2 = new int[n-1] ;
        if (n == 0 ) return nums[0] ;
        for (int i = 0; i < n; i++) {
            if (i != 0) arr1[i] = nums[i] ;
            if (i != n-1) arr2[i] = nums[i] ;
        }

        int ans1 = house_rob(arr1);
        int ans2  = house_rob(arr2);
        return Math.max(ans1 , ans2) ;



    }





    static  int house_rob(int[] nums){
        int ind = nums.length -1 ;
        return rob_tabulation(ind , nums) ;
    }
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
