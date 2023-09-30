/*
 *              HashMap Operation
 */

import java.util.HashMap;

public class HashMapOperations {
    public static void main(String[] args) {
        // create
        HashMap<String, Integer> hm = new HashMap<>();

        // Insert - 0(1)
        hm.put("India", 100);
        hm.put("Chaina", 150);
        hm.put("US", 95);

        System.out.println(hm);
        hm.put("India", 120);
        System.out.println(hm);

        // Get - O(1)
        int population = hm.get("India");
        System.out.println(population);
        System.out.println(hm.get("Indonesia"));

        // ContainsKey -O(1)
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Indonesia"));

        // remove -O(1)
        hm.remove("Chaina");
        System.out.println(hm);

        // size
        System.out.println(hm.size());

        // clear
        hm.clear();

        // is Empty
        System.out.println(hm.isEmpty());
    }
}

/*
 * Output:
 * {Chaina=150, US=95, India=100}
 * {Chaina=150, US=95, India=120}
 * 120
 * null
 * true
 * false
 * {US=95, India=120}
 * 2
 * true
 */

/*
This Java code demonstrates various operations on a `HashMap`:

1. **Creation**: A `HashMap` called `hm` is created, which stores key-value pairs of country names and their corresponding populations.

2. **Insertion**: Key-value pairs (country names and populations) are added to the `HashMap` using the `put` method. It's noted that if a key already exists, the new value will replace the old value.

3. **Get**: The `get` method is used to retrieve the population of a specific country (e.g., "India"). It returns the value associated with the key.

4. **ContainsKey**: The `containsKey` method checks whether a key exists in the `HashMap` or not. It returns `true` if the key is found and `false` otherwise.

5. **Remove**: The `remove` method is used to remove a key-value pair from the `HashMap`. In this case, "China" is removed.

6. **Size**: The `size` method is used to determine the number of key-value pairs in the `HashMap`.

7. **Clear**: The `clear` method removes all key-value pairs from the `HashMap`.

8. **IsEmpty**: The `isEmpty` method checks if the `HashMap` is empty (contains no key-value pairs).

The code prints the results of these operations, and the output is explained as follows:

- After insertion, the `HashMap` contains three key-value pairs.
- The population of "India" is retrieved (120), and the population of "Indonesia" (which doesn't exist) returns `null`.
- The `containsKey` method confirms the presence of "India" but not "Indonesia."
- "China" is removed from the `HashMap`, resulting in two remaining key-value pairs.
- The size of the `HashMap` is 2.
- The `HashMap` is cleared, making it empty.
- Finally, the `isEmpty` method confirms that the `HashMap` is empty (true).

The code demonstrates the basic usage of `HashMap` operations in Java.
    */
