/*    peek element in mountain array  */

public class mountainarraybinarysearch {
    public static void main(String[] args){

    }

    public static int peakIndexInMountainArray(int[] arr) {
        int start=0;
        int end=arr.length-1;
        while (start < end) {
            /* int mid=(start+end)/2; */    // this might excced the value of int capacity resulting error
            int mid = start + (end - start) / 2;
            if (arr[mid]>arr[mid+1]) {   // you are in decreasing part of array this is a potential answer
                end = mid;           // so checking the next part this is why end is not mid -1
            }
            else  {
                start = mid + 1;    // we know that next element is greater than previous
            }
        }
        // in the end of while loop  start and end will point to largest element in the array
        return start;
    }
}
