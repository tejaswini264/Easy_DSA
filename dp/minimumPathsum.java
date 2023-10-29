package DP;

import java.util.Arrays;

public class minimumPathsum {
    public static void main(String[] args) {
        int [][] grid = {{1,3,1} ,{1,5,1} , {4,2,1} } ;

        System.out.println(minPathSum(grid)) ;


    }

    public static int minPathSum(int[][] grid) {
        // row
        int n =  grid.length ;
        //col
        int m = grid[0].length ;
        int dp[][] = new int[n][m] ;
//        for (int row[] : dp){
//            Arrays.fill(row ,-1);
//        }

        return minPathSum_tab(n, m  , grid , dp );


    }
    public static int minPathSum(int i , int  j , int[][] grid){
        // base  case
        if (i  == 0 && j == 0) return  grid[0][0] ;
        // edge case to  avoid if we go outsideof the matrix
        if (i < 0 || j < 0) return (int) Math.pow(10 , 9) ;

        int up =  grid[i][j] + minPathSum(i-1 , j ,  grid) ;
        int left  = grid[i][j] + minPathSum(i , j-1 ,  grid) ;

        return Math.min(up , left ) ;
    }
    public static int minPathSum_memo(int i , int  j , int[][] grid  , int[][] dp ){
        // base  case
        if (i  == 0 && j == 0) return  grid[0][0] ;
        // edge case to  avoid if we go outsideof the matrix
        if (i < 0 || j < 0) return (int) Math.pow(10 , 9) ;

        if(dp[i][j] != -1) return  dp[i][j] ;
        int up =  grid[i][j] + minPathSum_memo(i-1 , j ,  grid , dp) ;
        int left  = grid[i][j] + minPathSum_memo(i , j-1 ,  grid , dp ) ;

        return dp[i][j] =  Math.min(up , left ) ;
    }
    // tabulation
    public static int minPathSum_tab(int n , int  m , int[][] grid  , int[][] dp ){
        // base case

        int  up = 0 ;
        int left = 0 ;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0)  {
                    dp[i][j] = grid[i][j] ;
                }
                else
                {
                    up = grid[i][j] ;
                    if( i > 0)  up += dp[i-1][j] ;
                    else up += (int)Math.pow(10,9);

                    left = grid[i][j] ;
                    if (j > 0) left +=  dp[i][j-1] ;
                    else  left += (int)Math.pow(10,9);
                    dp[i][j] = Math.min(up , left) ;

                }

            }

        }
        return dp[n-1][m-1] ;
    }


}
