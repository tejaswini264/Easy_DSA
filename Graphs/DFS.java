/*Given an array arr[] of size N, the task is to find the minimum number of jumps to reach the last index of the array starting from index 0.In one jump you can move from current index i to index j, if arr[i] = arr[j] and i != j or you can jump to (i + 1) or (i – 1).*/
// Java code for the above approach
import java.io.*;
import java.util.*;

class GFG {

// Function to find the minimum
// number of jumps required
static int minimizeJumps(int[] arr)
{
	int n = arr.length;

	// Initialize a map for mapping element
	// with indices of all similar value
	// occurrences in array
	HashMap<Integer, List<Integer> > unmap
	= new HashMap<>();

	// Mapping element with indices
	for (int i = 0; i < n; i++) {
	if (unmap.containsKey(arr[i])) {
		unmap.get(arr[i]).add(i);
	}
	else {
		List<Integer> temp = new ArrayList<>();
		temp.add(i);
		unmap.put(arr[i], temp);
	}
	}

	Queue<Integer> q = new LinkedList<>();
	boolean[] visited = new boolean[n];
	Arrays.fill(visited, false);

	// Push starting element into queue
	// and mark it visited
	q.add(0);
	visited[0] = true;

	// Initialize a variable count for
	// counting the minimum number number
	// of valid jump to reach at last index
	int count = 0;

	// Do while queue size is
	// greater than 0
	while (q.size() > 0) {
	int size = q.size();

	// Iterate on all the
	// elements of queue
	for (int i = 0; i < size; i++) {

		// Fetch the front element and
		// pop out from queue
		int curr = q.poll();

		// Check if we reach at the
		// last index or not if true,
		// then return the count
		if (curr == n - 1) {
		return count / 2;
		}

		// Check if curr + 1 is valid
		// position to visit or not
		if (curr + 1 < n
			&& visited[curr + 1] == false) {
		// If true, push curr + 1
		// into queue and mark
		// it as visited
		q.add(curr + 1);
		visited[curr + 1] = true;
		}

		// Check if curr - 1 is valid
		// position to visit or not
		if (curr - 1 >= 0
			&& visited[curr - 1] == false) {

		// If true, push curr - 1
		// into queue and mark
		// it as visited
		q.add(curr - 1);
		visited[curr - 1] = true;
		}

		// Now, Iterate over all the
		// element that are similar
		// to curr
		if (unmap.containsKey(arr[i])) {
		for (int j = 0;
			j < unmap.get(arr[curr]).size();
			j++) {
			int child
			= unmap.get(arr[curr]).get(j);
			if (curr == child) {
			continue;
			}
			// Check if child is valid
			// position to visit or not
			if (visited[child] == false) {

			// If true, push child
			// into queue and mark
			// it as visited
			q.add(child);
			visited[child] = true;
			}
		}
		}
		// Erase all the occurrences
		// of curr from map. Because
		// we already considered these
		// element for valid jump
		// in above step
		unmap.remove(arr[curr]);
	}
	// Increment the count of jump
	count++;
	}
	// Finally, return the count.
	return count / 2;
}

public static void main(String[] args)
{
	int[] arr = { 100, -23, -23, 404, 100,
				23, 23, 23, 3, 404 };

	// Function call
	System.out.print(minimizeJumps(arr));
}
}

// This code is contributed by lokesh
