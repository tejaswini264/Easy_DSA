package DP;

import java.util.Arrays;

public class CountSubsetsWithsumK {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3} ;
        int  tar = 3 ;
        int n = arr.length ;
        int dp[][]=new int[n][tar+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);

        System.out.println(findWays(arr.length -1 , arr , tar , dp));

    } 
    public static int findWays(int ind , int num[], int tar) {
        // base case for the traget
        if(tar == 0) return  1 ;
        // check of the given index
        if (ind == 0 ) return  num[0] ==  tar?1:0;

        // we have the 2 option either take or not take the element
     int  notTake =  findWays(ind-1 ,  num , tar) ;

        // now check for  take


        int Take = findWays(ind-1 ,  num ,tar - num[ind] ) ;

        return notTake + Take ;
    }
    // convert it to the memorazation
    public static int findWays(int ind , int num[], int tar , int[][] dp) {
        // base case for the traget
        if(tar == 0) return  1 ;
        // check of the given index
        if (ind == 0 ) return  num[0] ==  tar?1:0;

        if (dp[ind][tar] != -1) return  dp[ind][tar] ;

        // we have the 2 option either take or not take the element
        int  notTake =  findWays(ind-1 ,  num , tar,dp) ;

        // now check for  take

       int Take =  0 ;
       if (num[ind] <= tar)  Take = findWays(ind-1 ,  num ,tar - num[ind] , dp) ;

        return dp[ind][tar]  =  notTake + Take ;
    }



}
