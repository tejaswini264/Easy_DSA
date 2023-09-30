/*Given the following input (4322, 1334, 1471, 9679, 1989, 6171, 6173, 4199) and the hash function x mod 10*/
class MyHashMap {
    private int[] data;

    /** Initialize your data structure here. */
    public MyHashMap() {
        data = new int[10]; // Assuming a hash map with 10 buckets
    }

    /** Insert a key-value pair into the hash map. */
    public void put(int key, int value) {
        int index = key % 10; // Calculate the index using the hash function
        data[index] = value; // Store the value in the corresponding bucket
    }

    /** Retrieve the value associated with a given key. */
    public int get(int key) {
        int index = key % 10; // Calculate the index using the hash function
        return data[index]; // Retrieve the value from the corresponding bucket
    }

    /** Remove the key-value pair associated with the given key. */
    public void remove(int key) {
        int index = key % 10; // Calculate the index using the hash function
        data[index] = -1; // Remove the value by marking it as -1
    }
}

public class Main {
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();

        // Insert key-value pairs into the hash map
        hashMap.put(4322, 10);
        hashMap.put(1334, 20);
        hashMap.put(1471, 30);
        hashMap.put(9679, 40);
        hashMap.put(1989, 50);
        hashMap.put(6171, 60);
        hashMap.put(6173, 70);
        hashMap.put(4199, 80);

        // Retrieve and print values associated with keys
        System.out.println("Value for key 4322: " + hashMap.get(4322));
        System.out.println("Value for key 1471: " + hashMap.get(1471));

        // Remove a key-value pair
        hashMap.remove(1334);

        // Try to retrieve a removed key
        System.out.println("Value for key 1334 (after removal): " + hashMap.get(1334));
    }
}
