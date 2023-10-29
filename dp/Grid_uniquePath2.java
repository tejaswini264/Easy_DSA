package DP;

import java.util.Arrays;

public class Grid_uniquePath2 {
    // what if obstracel compes in to the path
    // todo recursion
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int  i = obstacleGrid.length ;
        int j  = obstacleGrid[0].length ;
        int dp[][]=new int[i][j];
        for(int row[]: dp)
            Arrays.fill(row,-1) ;
        return mazeObstaclesUtil(i-1 , j -1 , obstacleGrid , dp ) ;

    }
    static  int mazeObstaclesUtil(int i , int j , int[][] maze , int[][] dp ){
        // base case if some stoppage is come between them
        if (i > 0 && j > 0  && maze[i][j] == -1) return  0 ;
        if (i == 0 && j ==0 ) return  1 ;
        if (i  <  0 || j < 0) return  0 ;

        if (dp[i][j] != -1) return  dp[i][j] ;

        int up = mazeObstaclesUtil(i -1 , j , maze , dp) ;
        int left = mazeObstaclesUtil(i , j -1 , maze , dp ) ;
        return dp[i][j] = up + left ;

    }

}
