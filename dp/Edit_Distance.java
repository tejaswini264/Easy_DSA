package DP;

public class Edit_Distance {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        System.out.println(minDistance(s1 , s2));
    }
    public int minDistance(int ind1 , int ind2 , String word1, String word2) {
        // base  case
        // when ever some of the sting is exuceated then we have to convert it to then empty string ind +1
        if (ind1 < 0) return  ind2 +1 ;
        if (ind2 < 0) return  ind1 + 1 ;

        // if the String match
        if (word1.charAt(ind1) == word2.charAt(ind2)) return  0 + minDistance(ind1-1 , ind2 -1 , word1 , word2) ;


        // if the string does not match then  there are 3 possible way to do that
        // REMOVE , INSERT  , REPLACE
        else {
            int remove = 1 + minDistance(ind1 -1, ind2   , word1 , word2) ;
            int insert = 1 + minDistance(ind1 , ind2 -1 , word1 , word2) ;
            int replace = 1 + minDistance(ind1 -1 , ind2 -1 , word1 , word2) ;
            return Math.min(insert , Math.min(remove ,replace));
        }
    }
    public int minDistance(int ind1 , int ind2 , String word1, String word2 , int[][] dp ) {
        // base  case
        // when ever some of the sting is exuceated then we have to convert it to then empty string ind +1
        if (ind1 < 0) return  ind2 +1 ;
        if (ind2 < 0) return  ind1 + 1 ;
        if (dp[ind1][ind2] != -1) return  dp[ind1][ind2] ;

        // if the String match
        if (word1.charAt(ind1) == word2.charAt(ind2)) return dp[ind1][ind2] = 0 + minDistance(ind1-1 , ind2 -1 , word1 , word2,dp) ;


            // if the string does not match then  there are 3 possible way to do that
            // REMOVE , INSERT  , REPLACE
        else {
            int remove = 1 + minDistance(ind1 -1, ind2   , word1 , word2,dp) ;
            int insert = 1 + minDistance(ind1 , ind2 -1 , word1 , word2,dp) ;
            int replace = 1 + minDistance(ind1 -1 , ind2 -1 , word1 , word2,dp) ;
            return dp[ind1][ind2] = Math.min(insert , Math.min(remove ,replace));
        }
    }

    // TODO tabulation
    public  static int minDistance(String word1, String word2) {
        int n = word1.length() ;
        int m = word2.length()  ;
        
        // create a 2D DP array 
        int[][] dp = new int[n+1][m+1] ;
        
        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i ;

        }
        for (int j = 0; j <= m ; j++) {
            dp[0][j] = j ;

        }
        for (int i = 1; i <n+1 ; i++) {
            for (int j = 1; j <m+1 ; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] =  0 + dp[i-1][j-1] ;
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1] , Math.min(dp[i-1][j] , dp[i][j-1])) ;
                }

            }
            
        }
        return dp[n][m] ;

    }


}
