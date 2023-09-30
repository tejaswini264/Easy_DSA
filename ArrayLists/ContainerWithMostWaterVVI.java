/*
 *    Container with Most Water
 *   -> For given n lines on x-axis, use 2 lines to form a container such that it holds
 *      maximum water.
 *    height= [1,8,6,2,5,4,8,3,7]
 */

 import java.util.ArrayList;

public class ContainerWithMostWaterVVI {
    public static int storeWater(ArrayList<Integer> height) {
        int maxWater = 0;
        for(int i=0; i<height.size(); i++){
            for(int j=i+1; j<height.size(); j++){
                int ht=Math.min(height.get(i), height.get(j));
                int width = j-i;
                int currWater = ht * width;
                maxWater = Math.max(maxWater , currWater);
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {

        ArrayList<Integer> height= new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(storeWater(height));
    }
}
/*storeWater Method:

This method takes an ArrayList of integers named height as input.
It uses two nested loops to iterate through all possible pairs of vertical lines (represented by the indices i and j) within the ArrayList.
For each pair of lines, it calculates the potential water trapped between them using the formula min(height[i], height[j]) * (j - i). Here, min(height[i], height[j]) represents the height of the shorter line, and (j - i) represents the width between the lines.
It keeps track of the maximum water calculated among all pairs.
Finally, it returns the maximum water value.
main Method:

In the main method, an ArrayList named height is created and populated with a series of integers representing the heights of vertical lines.
These height values represent the heights of the vertical lines in a container.
The storeWater method is called with the height ArrayList as input, and the maximum trapped water is calculated and printed to the console.
Overall, this code demonstrates a brute-force approach to find the maximum water that can be trapped between two vertical lines in a container by considering all possible pairs of lines and calculating the water trapped between them.
*/



