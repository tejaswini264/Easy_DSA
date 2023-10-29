package DP;

import java.util.List;

public class triangle {

    private Integer[][] memo;
    public int minimumTotal(List<List<Integer>> triangle){
        int n = triangle.size();
        memo = new Integer[n][n];
        return dfs(0,0,triangle);
    }

    private int dfs(int level, int i, List<List<Integer>> triangle) {
        if (memo[level][i] != null) return memo[level][i];

        int path = triangle.get(level).get(i);
        if (path < triangle.size()-1){
            path += Math.min(dfs(level+1 , i , triangle),dfs(level+1,i+1,triangle));
        }
        return memo[level][i] = path;
    }

    // tabulation
    static int minimumPathSum(int[][] triangle, int n) {
        int dp[][]= new int[n][n];
        // base case when we reach to the end we have 4 possiablity

        for (int j = 0; j < n; j++) {
            dp[n-1][j] = triangle[n-1][j];
        }
        for (int i = n-2; i >= 0 ; i--) {
            for (int j = i; j >=0; j--) {
                int down = triangle[i][j] + dp[i+1][j];
                int digonal = triangle[i][j] + dp[i+1][j+1];

                dp[i][j] = Math.min(down,digonal);

            }

        }
        return dp[0][0];
    }
}
