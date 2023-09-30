/*
 *       Counting Sort
 */

public class CountingSort {
    
    public static void sortArray(int array[]) {
        int largest=Integer.MIN_VALUE;
        for(int i=0; i<array.length; i++){
            largest=Math.max(array[i],largest);
        }
        int count[] = new int[largest+1];
        for(int i=0; i<array.length; i++){
            count[array[i]]++;
        }
        // sorting
        int j=0;
        for(int i=0; i<count.length; i++){
            while(count[i]>0){
                array[j]=i;
                j++;
                count[i]--;
            }
        }

    }

    public static void main(String[] args) {
        int array[]={1,4,1,3,2,4,3,7};
        sortArray(array);
        
        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}

/*
 *   Output:
 *   1 1 2 3 3 4 4 7
 */
/*Counting sort is an example of a non-comparison-based sorting algorithm —  it sorts by mapping the value of each array element as an index of the auxiliary array.*/
