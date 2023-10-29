package DP;

public class coinChange {
    public static void main(String[] args) {
        int[] coin = {1,2 ,5} ;
        System.out.println(coinChange(coin.length -1 , coin , 11));
    }
    public static int coinChange(int ind, int[] coins, int amount) {
        // base case
        // we have to find the min number of  coin to match the paticular amount
        if (ind == 0) {
            if (amount % coins[0] == 0) return amount / coins[0];
            else return -1;

        }
        // try out all of the possiable way to find the combanication
        // we have the 2 possiable way to do that
        int nottake = 0 + coinChange(ind - 1, coins, amount);

        int take = Integer.MAX_VALUE;
        if (coins[ind] <= amount) {
            take = 1 + coinChange(ind, coins, amount - coins[ind]);
            //  when there is infinit number of use or multiple numvber of use then we have no need to sub or add for the index

        }
        // now we have to find the number of min ways
        return Math.min(nottake, take);


    }
    // Todo memorazation it
    public int coinChange(int ind , int[] coins, int amount , int[][] dp ) {
        // base case
        // we have to find the min number of  coin to match the paticular amount
        if (ind == 0) {
            if (amount % coins[0] == 0) return amount / coins[0];
            else return -1;

        }
        if (dp[ind][amount] != -1) return  dp[ind][amount] ;
        // try out all of the possiable way to find the combanication
        // we have the 2 possiable way to do that
        int nottake = 0 + coinChange(ind - 1, coins, amount,dp);

        int take = Integer.MAX_VALUE;
        if (coins[ind] <= amount) {
            take = 1 + coinChange(ind, coins, amount - coins[ind],dp);
            //  when there is infinit number of use or multiple numvber of use then we have no need to sub or add for the index

        }
        // now we have to find the number of min ways
        return dp[ind][amount] =  Math.min(nottake, take);

    }
    // TODO  tabulation
    public int coinChange(int[] coins, int amount) {
        // create a dp
        int n = coins.length ;
        int[][] dp  = new int[n][amount+ 1] ;

        // how to define the base case in case of dp
        for (int tar = 0; tar <= amount; tar++) {
            if (tar % coins[0] == 0) dp[0][tar] = tar/ coins[0] ;

            else dp[0][tar] = (int) Math.pow(10 , 9) ;

        }
        for (int ind = 1; ind <n ; ind++) {
            for (int target = 0; target <= amount; target++) {
                int nottake = 0 + dp[ind -1][target] ;
                int take = (int) Math.pow(10 ,9) ;
                if (coins[ind] <= target){
                    take = 1 + dp[ind][target- coins[ind]] ;
                }
                dp[ind][target] = Math.min(nottake , take) ;
            }

        }
        int ans = dp[n-1][amount] ;
        if (ans >=(int)Math.pow(10 , 9)) return  -1  ;
        return  ans ;



    }
}
