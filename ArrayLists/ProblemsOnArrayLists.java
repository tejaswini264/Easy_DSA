Question 1:

Implement a Java program that takes an ArrayList of integers as input and returns a new ArrayList containing only the unique elements in the original list.
Code: import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueElements {

    public static List<Integer> findUniqueElements(List<Integer> inputList) {
        Set<Integer> uniqueSet = new HashSet<>(inputList);
        return new ArrayList<>(uniqueSet);
    }

    public static void main(String[] args) {
        // Example usage
        List<Integer> inputList = new ArrayList<>();
        inputList.add(1);
        inputList.add(2);
        inputList.add(3);
        inputList.add(2);
        inputList.add(4);
        inputList.add(1);

        List<Integer> uniqueList = findUniqueElements(inputList);

        System.out.println("Original List: " + inputList);
        System.out.println("List with Unique Elements: " + uniqueList);
    }
}


Question 2:

Write a Java program that takes two ArrayLists of integers as input and returns a new ArrayList containing the common elements between the two input lists.

Code:
  import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonElements {

    public static List<Integer> findCommonElements(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);

        set1.retainAll(set2);

        return new ArrayList<>(set1);
    }

    public static void main(String[] args) {
        // Example usage
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);

        List<Integer> commonList = findCommonElements(list1, list2);

        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);
        System.out.println("Common Elements: " + commonList);
    }
}
