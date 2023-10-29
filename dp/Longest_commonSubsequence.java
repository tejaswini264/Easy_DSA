package DP;

import java.util.Arrays;

public class Longest_commonSubsequence {
    public static void main(String[] args) {
       String text1 = "abcde" ;
          String     text2 = "ace" ;
          int n = text1.length() ;
          int m = text2.length() ;
          int[][] dp = new int[n][m] ;
          for (int[] row : dp){
              Arrays.fill(row , -1);
          }
        System.out.println(longestCommonSubsequence(text1.length()-1 , text2.length()-1 , text1 , text2 , dp));

    }
    public static int longestCommonSubsequence(int ind1 , int ind2 , String text1, String text2) {
        // base Case
        if (ind1 < 0 || ind2 < 0) return  0 ;


        //  case string is match
        if (text1.charAt(ind1) == text2.charAt(ind2)){
            return  1 + longestCommonSubsequence(ind1 -1 , ind2 -1 , text1  , text2) ;

        }
        // string does not match
        int maxi = Math.max(longestCommonSubsequence(ind1-1 , ind2 , text1 , text2) , longestCommonSubsequence(ind1 , ind2-1 , text1 , text2));


        return  maxi ;
    }
    // optimized it memorazation
    public static int longestCommonSubsequence(int ind1 , int ind2 , String text1, String text2 , int[][]dp) {
        // base Case
        if (ind1 < 0 || ind2 < 0) return  0 ;

        if (dp[ind1][ind2] != -1) return  dp[ind1][ind2] ;



        //  case string is match
        if (text1.charAt(ind1) == text2.charAt(ind2)){
            return dp[ind1][ind2] =  1 + longestCommonSubsequence(ind1 -1 , ind2 -1 , text1  , text2,dp) ;

        }
        // string does not match
        int maxi = Math.max(longestCommonSubsequence(ind1-1 , ind2 , text1 , text2,dp) , longestCommonSubsequence(ind1 , ind2-1 , text1 , text2,dp));


        return dp[ind1][ind2] =  maxi ;
    }
    public int longestCommonSubsequence(String text1, String text2) {
        // find the len of it

        int n = text1.length() ;
        int m = text2.length() ;

        int dp[][] = new  int[n+1][m+1] ;
        for (int rows[] : dp){
            Arrays.fill(rows , -1);
        }

        // we have to fill the uper part first
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0 ;

        }
        for (int i = 0; i <= m  ; i++) {
            dp[0][i] = 0  ;

        }
        for (int ind1 = 1; ind1 <= n ; ind1++) {
            for (int ind2 = 1; ind2 <= m ; ind2++) {
                if (text1.charAt(ind1-1) == text2.charAt(ind2-1))
                dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1] ;
                else
                    dp[ind1][ind2]  = 0 + Math.max(dp[ind1-1][ind2] , dp[ind1][ind2-1]);

            }

        }
        return dp[n][m] ;
}



}
