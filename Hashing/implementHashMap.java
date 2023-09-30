import java.util.*;

public class implementHashMap {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // n
        private int N;
        private LinkedList<Node> buckets[];// N = buckets.length

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % buckets.length;
        }

        private int SearchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;

            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LinkedList[N * 2];
            N = 2 * N;
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            // nodes -> add in bucket
            for (int i = 0; i < oldBuck.length; i++) {
                LinkedList<Node> ll = oldBuck[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key); // 0 to 3
            int di = SearchInLL(key, bi); // valid; -1

            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }
            double lambda = n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {

            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);
            if (di != -1) {
                return true;
            } else {
                return false;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);

            if (di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);

            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Nepal", 5);
        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key);
        }

        System.out.println(hm.get("India"));
        System.out.println(hm.remove("India"));
        System.out.println(hm.get("India"));

        // System.out.println(hm.N); // how to get private data
        // System.out.println(hm.n);
    }
}


/*
HashMap Class:


The HashMap constructor initializes the HashMap with an initial size of 4 (N = 4) and creates an array of linked lists to store the data.
For each index in the buckets array, a new linked list is created.
hashFunction Method:

This method takes a key as input and calculates a hash code for the key using its hashCode method.
It then converts the hash code to a non-negative index within the buckets array using the modulo operation.
SearchInLL Method:

This method takes a key and an index (bi) as input and searches for the key within the linked list at the specified index.
If the key is found in the linked list, the method returns the position (distance) of the key within the list. If not found, it returns -1.
rehash Method:

This method is called when the load factor (ratio of stored elements to the number of buckets) exceeds 2.0.
It creates a new, larger array of linked lists and rehashes all existing key-value pairs into the new array.
This operation effectively increases the capacity of the HashMap and helps maintain a low load factor for better performance.
put Method:

The put method allows you to add a key-value pair to the HashMap.
It calculates the hash code of the key to determine the bucket index.
If the key already exists in the bucket, it updates the corresponding value. If not, it adds a new Node to the linked list.
After adding a key-value pair, it checks if the load factor exceeds 2.0 and triggers a rehash if necessary.
containsKey Method:

This method checks if a given key exists in the HashMap by searching the appropriate linked list at the calculated bucket index.
remove Method:

The remove method removes a key-value pair from the HashMap based on the provided key.
It calculates the bucket index for the key, searches for the key in the linked list at that index, and removes it if found.
After removal, it decrements the count of stored elements.
get Method:

The get method retrieves the value associated with a given key from the HashMap.
It calculates the bucket index for the key, searches for the key in the linked list at that index, and returns the associated value if found.
keySet Method:

This method returns an ArrayList of all keys present in the HashMap by iterating through each bucket and linked list.
isEmpty Method:

This method checks if the HashMap is empty by examining whether the count of stored elements (n) is zero.
main Method:

In the main method, an instance of the custom HashMap class is created, and key-value pairs are added using the put method.


 * Output:
 * Nepal
 * US
 * India
 * China
 * 100
 * 100
 * null
 */
