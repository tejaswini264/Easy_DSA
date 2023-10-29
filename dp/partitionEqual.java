package DP;

public class partitionEqual {
    public static void main(String[] args) {
        int[] arr = {1,5,11,5} ;
        System.out.println(canPartition(arr));
    }
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
    public static boolean canPartition(int[] nums) {
        int totsum = 0;
        for (int i = 0; i < nums.length; i++) {
            totsum += nums[i] ;
        }
        if (totsum % 2 == 1 ) return  false ;
        int target = totsum / 2;
        return  subsetSumToK(nums.length , target , nums) ;

    }
}
