
/*
 *   Given are N ropes of different lengths, the task is to connect there ropes into 
 *   one rope with minimum cost, such that the cost to connect two ropes is equal to
 *   the sum of their lengths.
 */
import java.util.PriorityQueue;

public class Connect_N_Ropes {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ropes[] = { 4, 3, 2, 6 };
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }
        int cost = 0;
        while (pq.size() > 1) {
            int num1 = pq.remove();
            int num2 = pq.remove();
            cost += num1 + num2;
            pq.add(num1 + num2);
        }
        System.out.println("Minimum cost: " + cost);
    }
}

/*
 * Output:
 * Minimum cost: 29
 */

/*The Java program aims to minimize the cost of connecting N ropes of different lengths into a single rope. The approach involves using a PriorityQueue to efficiently retrieve and merge the two smallest ropes at each step. The program initializes a PriorityQueue, `pq`, and populates it with the lengths of the given ropes. The PriorityQueue automatically arranges elements in ascending order.

Subsequently, the program enters a loop where it repeatedly extracts the two smallest ropes from the PriorityQueue, connects them, adds the cost of connection to the total cost, and inserts the resulting combined rope length back into the PriorityQueue. This process continues until only one rope remains in the PriorityQueue.

The output of the program represents the minimum cost required to connect all the given ropes. In the provided example with rope lengths {4, 3, 2, 6}, the minimum cost is calculated as follows:

1. Connect ropes of length 2 and 3 (Cost: 2 + 3 = 5).
2. Connect ropes of length 4 and 5 (Cost: 4 + 5 = 9).
3. Connect ropes of length 9 and 6 (Cost: 9 + 6 = 15).

The final connected rope has a length of 29, and the output of the program is "Minimum cost: 29."

In summary, the program demonstrates an efficient algorithm to minimize the cost of connecting N ropes using a PriorityQueue, which ensures that the smallest ropes are always prioritized for merging, resulting in an optimal solution.*/
