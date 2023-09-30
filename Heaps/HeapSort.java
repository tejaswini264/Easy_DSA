/*
 *            Heap Sort
 */

public class HeapSort {

    public static void heapSort(int arr[]) {
        // step1: build maxHeap
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // step2: push largest at end
        for (int i = n - 1; i > 0; i--) {
            // swap (largest-first with last)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
    }

    public static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx != i) {
            // swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
            heapify(arr, maxIdx, size);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 8, 7, 65, 5, 4, 3, 2 };
        heapSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

/*
 * Output:
 * 2 3 4 5 7 8 65
 */

/*The provided code is an implementation of the Heap Sort algorithm in Java for sorting an array of integers in ascending order. Here's a short explanation of the key components and the sorting process:

1. **Heapify Method**: The `heapify` method is used to maintain the max-heap property. It takes an array, an index `i`, and the size of the heap as parameters. It recursively compares elements with their left and right children to find the maximum and swaps them if necessary to maintain the max-heap property.

2. **Heap Sort Method**: The `heapSort` method performs the heap sort algorithm. It first builds a max-heap by calling `heapify` on the array elements starting from the middle and moving towards the beginning. Then, it repeatedly swaps the largest element (the root of the max-heap) with the last element of the unsorted portion of the array and calls `heapify` to restore the max-heap property.

3. **Main Method**: In the `main` method, an array of integers is initialized. The `heapSort` method is called to sort the array in ascending order.

4. **Output**: The sorted array is printed to the console.

The code efficiently sorts the input array using the Heap Sort algorithm, and the sorted result is printed as the output. In this example, the input array {8, 7, 65, 5, 4, 3, 2} is sorted in ascending order, resulting in the output: "2 3 4 5 7 8 65."*/
