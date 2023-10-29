package DP;

import java.util.Arrays;

public class SubSetsumEqualsToTarget {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4} ;
        int  k = 4 ;
        int n = arr.length ;
        int dp[][]=new int[n][k+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        System.out.println(subsetSumToK(n,k,arr,dp));
        //System.out.println(subsetSumToK(arr.length -1 , k , arr));
    }

    public static boolean subsetSumToK_imp(int n, int k, int arr[]){
        // Write your code here.

        // base case for the traget
        if(k == 0) return  true ;
        // check of the given index
        if (n == 0 ) return  arr[0] ==  k ;

        // we have the 2 option either take or not take the element
        boolean notTake =  subsetSumToK_imp(n-1 , k , arr) ;

        // now check for  take
        boolean Take = subsetSumToK_imp(n-1 , k - arr[n] , arr) ;

        return notTake || Take ;
    }
    // memo
    public static boolean subsetSumToK(int n, int k, int arr[] , int[][] dp ){
        // Write your code here.

        // base case for the traget
        if(k == 0) return  true ;
        // check of the given index
        if (n == 0 ) return  arr[0] ==  k ;

        if (dp[n][k] != -1) return dp[n][k] == 0 ?false:true ;

        // we have the 2 option either take or not take the element
        boolean notTake =  subsetSumToK(n-1 , k , arr , dp) ;

        // now check for  take
        boolean Take = subsetSumToK(n-1 , k - arr[n] , arr ,dp ) ;

        dp[n][k] = notTake || Take ?1:0 ;

        return notTake || Take ;
    }
    // todo tbulation
    public static boolean subsetSumToK(int n, int k,int[] arr){
        boolean dp[][] = new boolean[n][k+1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;

        }
        if (arr[0] <= k){
            dp[0][arr[0]] = true;
        }
        for (int ind = 1; ind < n ; ind++) {
            for (int target = 1; target <=k ; target++) {
                boolean nottaken = dp[ind-1][target];

                boolean taken = false;
                if (arr[ind] <=target) taken = dp[ind-1][target-arr[ind]];

                dp[ind][target] = nottaken || taken;


            }

        }
        return dp[n-1][k];
    }


    }
