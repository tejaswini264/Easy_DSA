Question 1:

Implement a Java program to find the first non-repeating character in a string using Hashing.

Code:
import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static char findFirstNonRepeatingChar(String s) {
        Map<Character, Integer> charCount = new HashMap<>();

        // Count the occurrences of each character
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Find the first non-repeating character
        for (char c : s.toCharArray()) {
            if (charCount.get(c) == 1) {
                return c;
            }
        }

        return '\0'; // If no non-repeating character is found
    }

    public static void main(String[] args) {
        // Example usage
        String input = "leetcode";
        char result = findFirstNonRepeatingChar(input);

        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}



Question 2:

Write a Java program to check if two strings are anagrams using Hashing. Two strings are considered anagrams if they have the same characters with the same 
frequencies.

Code: 
import java.util.HashMap;
import java.util.Map;

public class AnagramCheck {

    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<>();

        // Count the occurrences of characters in the first string
        for (char c : str1.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Compare with the second string
        for (char c : str2.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return false; // Character not present in the first string or frequency is different
            }
            charCount.put(c, charCount.get(c) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        // Example usage
        String str1 = "listen";
        String str2 = "silent";

        if (areAnagrams(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }
    }
}
