package DP;

import java.util.Arrays;

public class climbStairs {
    public static void main(String[] args) {
        System.out.println( climbStairs_memo(3)) ; 

    }


    // recursion way
    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;

        int left = climbStairs(n - 1);
        int right = climbStairs(n - 2);

        return left + right;


    }

    public static int climbStairs_memo(int n) {
        int[] dp = new  int[n+1] ;
        Arrays.fill(dp , -1 );
        if (n == 0 || n == 1) return  1 ;
        if (dp[n] != -1) return  dp[n] ;
        return dp[n] = climbStairs_memo(n-1) + climbStairs_memo(n -2 ) ;

    }
    // tabulation 
    public static int climbStairs_tabulation(int n){
        int[] dp = new int[n+1] ; 
        dp[0] = 1 ; 
        dp[1] = 1 ;
        for (int i = 2; i <= n ; i++) {
            dp[i] = dp[i-1] + dp[i-2] ;

            
        }
        return dp[n] ;
    }
    
}
