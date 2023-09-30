import java.util.HashSet;

public class HashSet1 {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(2);
        hs.add(3);
        System.out.println(hs);
        hs.remove(3);
        System.out.println(hs);
        System.out.println(hs.contains(3));
        System.out.println(hs.size());
        System.out.println(hs.isEmpty());
    }
}

/*The Java program demonstrates the usage of a `HashSet`, a collection that does not allow duplicate elements. In this example, a `HashSet` named `hs` is created, and integers 1, 2, and 3 are added to it. Due to the nature of `HashSet`, duplicate elements are automatically eliminated, resulting in the set containing only distinct values. The program then prints the contents of the `HashSet`.

Following this, the program removes the element 3 from the `HashSet` using the `remove` method and prints the updated set. It subsequently checks whether the set contains the element 3, printing `false` since it was removed.

The program also prints the size of the `HashSet` using the `size` method, which indicates the number of unique elements in the set. Finally, it checks if the `HashSet` is empty using the `isEmpty` method, printing `false` since the set contains elements.

In summary, the program showcases the fundamental operations of a `HashSet`, including adding elements, automatic removal of duplicates, removing elements, checking for element existence, determining the size, and verifying if the set is empty. The output provided demonstrates the expected behavior of these operations on the `HashSet`.*/
/*
 * Output:
 * [1, 2, 3]
 * [1, 2]
 * false
 * 2
 * false
 */
