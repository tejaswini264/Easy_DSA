package DP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class frogJump {
    public static void main(String[] args) {
        int[] height = {10 , 20 , 30 , 10} ;
        System.out.println(frogJump_tabulation(3 , height));

    }
    public static int frogJump(int n, int heights[]) {

       // base case
        if (n == 0) return  0 ;

        int left = frogJump(n-1 , heights) + Math.abs(heights[n] - heights[n-1]) ;
        // check for the edgeCase
        int right = Integer.MAX_VALUE ;
        if (n > 1 ) {
             right = frogJump(n - 2, heights) + Math.abs(heights[n] - heights[n - 2]);
        }
        return  Math.min(left ,right);
    }
    // Convert rec to memo
    public static int frogJump_memo(int n, int heights[]) {
        // base case
        if (n == 0 ) return  0 ;
        int[] dp =  new int[n+1] ;
        Arrays.fill(dp , -1 );

        if (dp[n] !=  -1) return  dp[ n] ;

        int left = frogJump(n-1 , heights) + Math.abs(heights[n] - heights[n-1]) ;
        // check for the edgeCase
        int right = Integer.MAX_VALUE ;
        if (n > 1 ) {
            right = frogJump(n - 2, heights) + Math.abs(heights[n] - heights[n - 2]);
        }
        return dp[n] = Math.min(left , right ) ;
    }
    // tabulation
    public static int frogJump_tabulation(int n, int heights[]) {

        int[] dp = new int[n+1] ;
        Arrays.fill(dp , -1 );


        dp[0] = 0 ;
        for (int i = 1; i <= n ; i++) {

            int js = dp[i-1] + Math.abs(dp[i] - dp[i-1]);
            int ss =  Integer.MAX_VALUE ;
            if (i > 1){
                ss = dp[i-2] + Math.abs(dp[i] - dp[i-2]) ;

            }
            dp[i] = Math.min(js , ss ) ;


        }
        return dp[n] ;
    }


}
