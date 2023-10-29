package DP;

public class max_product_subarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        // we have to  check for both -ve and +ve so we have to  calulate from both of the end
        int perfix = 1 ;
        int sufix =  1  ;
        int ans = Integer.MIN_VALUE  ;

        for (int i = 0; i <  n  ; i++) {
            // when ever ther is zero we have to skip that part and start from  Zero
            if (perfix == 0) perfix = 1 ;
            if (sufix == 0) sufix = 1 ;

            perfix = perfix * nums[i] ;
            sufix = sufix * nums[n-i -1 ] ;
            ans = Math.max(ans , Math.max(perfix , sufix)) ;
        }
     return  ans ;
    }
}
