package DP;

import java.util.Arrays;

public class fibonnachi {
    //  Tabulation method
    // you need to take care of the base case

    public static void main(String[] args) {
        // tabulation method
        int n = 5 ;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 0 ;
        dp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];

        }
        System.out.println(dp[n]);
    }
    // todo First approach recursion
    public  static int  fibo(int n ){
        // base case
        if (n <= 1) return   n ;

        return fibo(n-1) + fibo(n-2) ;


    }
    // TODO 2 Memeoration approach
    // how to convert it to the recursion
    // create a array of size  N+1 and fill them with 1

    // Store each of the element in to the array
    // check that it is already use or not if it is not then we have to call it otherwise we have to return the vlaue

    public  static  int fibo_memo(int n , int[] dp){
        if (n <= 1) return  n ;
        // create a dp of size n+1
        if (dp[n] != -1) return dp[n];
        return dp[n] = fibo_memo(n-1 , dp ) + fibo_memo(n-2 , dp ) ;


    }

}
