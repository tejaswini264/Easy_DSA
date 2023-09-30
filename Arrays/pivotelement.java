/*  find pivot element  */

public class binarysearchrotated {
    public static void main(String[] args){
        int[] arr={4,5,6,7,0,1,2,3};
        int ans= findpivot(arr);
        System.out.println(ans);
        int ans1=search(arr,2);
        System.out.println(ans1);

    }
    public static int findpivot(int[] arr){ // note for duplicate values it will not work
        int start=0;                        //because lat 2 condition will fail
        int end=arr.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            // 4 cases here
            if(mid<end && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(mid>start && arr[mid]<arr[mid-1]){
                return mid-1;
            }
            if(arr[mid]<=arr[start]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
}
