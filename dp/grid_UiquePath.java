package DP;

import java.util.Arrays;

public class grid_UiquePath {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        int[][]dp = new int[m][n];
        for (int[]row:dp){
            Arrays.fill(row,-1);

        }
        System.out.println(gridUniquePathDP(m-1,n-1,dp));

    }


    // todo recursion  ways
    public int uniquePaths_dp(int m, int n) {

        // base case
        if(m == 0 && n == 0 ) return  1 ; // whenever you reach the end point you have to return 1
        if (m < 0 || n < 0) return  0 ;

        // try all the possiable ways to do it
        int up =  uniquePaths_dp(m -1 , n) ;
        int left = uniquePaths_dp(m , n-1);
        // return the sum of the all possiabel ways
        return  up + left ;
    }

    static  int gridUniquePathDP(int i, int j,int[][]dp) {
        // base for the at the end
        if (i == 0 && j == 0) return 1;
        // for the edge case
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int up = gridUniquePathDP(i - 1, j, dp);
        int left = gridUniquePathDP(i, j - 1, dp);

        return dp[i][j] = up + left;


    }
    // todo tabulation
    static  int unique_paths(int  m  , int n , int[][] dp ){
        // base case
        dp[0][0] = 1 ;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ( i == 0 && j  == 0 ){
                    dp[i][j] = 1 ;
                }
                else {
                    int up = 0 ;
                    int left = 0 ;
                    if (i > 0){
                        up = dp[i-1][j] ;
                    }
                    if (j > 0 ){
                        left = dp[i][j-1] ;
                    }
                    dp[i][j] = up + left ;
                }}

        }
        return dp[m-1][n-1] ;

    }
}
