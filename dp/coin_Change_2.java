package DP;

import java.util.Arrays;

public class coin_Change_2 {
    static long countWaysToMakeChangeUtil(int[] arr,int ind, int T, long[][] dp){

        if(ind == 0){
            if(T%arr[0]==0)
                return 1;
            else
                return 0;
        }

        if(dp[ind][T]!=-1)
            return dp[ind][T];

        long notTaken = countWaysToMakeChangeUtil(arr,ind-1,T,dp);

        long taken = 0;
        if(arr[ind] <= T)
            taken = countWaysToMakeChangeUtil(arr,ind,T-arr[ind],dp);

        return dp[ind][T] = notTaken + taken;
    }


    static long countWaysToMakeChange1(int[] coins, int n, int T){

        long dp[][]=new long[n][T+1];
        for(long row[]: dp)
            Arrays.fill(row,-1);
        return countWaysToMakeChangeUtil(coins,n-1, T, dp);
    }

    public int change(int amount, int[] coins) {
        int n = coins.length ;

        return (int)  countWaysToMakeChange(coins , n , amount) ;

    }


    static long countWaysToMakeChange(int[] arr, int n, int T){

        long dp[][]=new long[n][T+1];


        //Initializing base condition
        for(int i=0;i<=T;i++){
            if(i%arr[0]==0)
                dp[0][i]=1;
            // Else condition is automatically fulfilled,
            // as dp array is initialized to zero
        }

        for(int ind=1; ind<n;ind++){
            for(int target=0;target<=T;target++){
                long notTaken = dp[ind-1][target];

                long taken = 0;
                if(arr[ind]<=target)
                    taken = dp[ind][target-arr[ind]];

                dp[ind][target] = notTaken + taken;
            }
        }

        return dp[n-1][T];
    }

}
