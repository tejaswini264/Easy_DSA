/*
 *    Insertion Sort
 *    idea -> pick an element (from unsorted part) & place in the right par in sorted part
 */

public class InsertionSort {

    public static void sortArray(int array[]) {
        for(int i=1; i<array.length; i++){
            int curr=array[i];
            int prev=i-1;
            while(prev>=0 && array[prev]>curr){
                array[prev+1]=array[prev];
                prev--;
            }
            // insertion
            array[prev+1]=curr;
        }
        
    }
    public static void main(String[] args) {
        int array[]={5,4,1,3,2};
        sortArray(array);
        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
/*sortArray Method:

The sortArray method takes an integer array as input and sorts it using the insertion sort algorithm.
It starts iterating through the array from the second element (index 1) to the end.
For each element at index i, it compares it with the previous elements (from index i-1 down to 0) and shifts elements to the right until it finds the correct position for the current element in the sorted portion of the array.
The inner while loop continues to shift elements to the right until it reaches the correct position for the curr element.
Once the correct position is found, the curr element is inserted into the array at the appropriate index.
main Method:

In the main method, an integer array array is declared and initialized with values [5, 4, 1, 3, 2].
The sortArray method is called to sort the array in ascending order using the insertion sort algorithm.
After sorting, a loop is used to iterate through the sorted array, and each element is printed to the console separated by spaces.
Overall, this code demonstrates the insertion sort algorithm, which is a simple sorting algorithm that builds the final sorted array one item at a time. It iterates through the elements, moving them into their correct positions within the sorted portion of the array.
*/





/*
 *    Output:
 *    1 2 3 4 5
 */
