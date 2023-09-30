/*
 *                    Determine if 2 Strings are anagrams of each other.
 */

import java.util.Arrays;

public class anagrams {
    public static void main(String[] args) {
        String str1 = "rajkishorbgp";
        String str2 = "kishorbgpraj";
        if (anagrams(str1, str2)) {
            System.out.println("Strings are anagrams.");
        } else {
            System.out.println("Strings are not anagrams.");
        }
    }

    public static Boolean anagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char str3[] = str1.toCharArray();
        char str4[] = str2.toCharArray();
        Arrays.sort(str3);
        Arrays.sort(str4);
        for (int i = 0; i < str3.length; i++) {
            if (str3[i] != str4[i]) {
                return false;
            }
        }
        return true;
    }
}

/*
 * Output:
 * Strings are anagrams.
 */


/*main method:

In the main method, two strings str1 and str2 are defined as "rajkishorbgp" and "kishorbgpraj," respectively.
The program then calls the anagrams function to check if str1 and str2 are anagrams.
Depending on the result, the program prints either "Strings are anagrams" or "Strings are not anagrams."
anagrams method:

The anagrams method takes two strings, str1 and str2, as input and returns a Boolean value indicating whether they are anagrams.
First, it checks if the lengths of the two strings are different. If they have different lengths, they cannot be anagrams, so the method returns false.
The characters of both strings are converted to character arrays (str3 and str4).
The Arrays.sort method is used to sort both character arrays.
Then, the method iterates through the sorted character arrays and compares the characters at each position. If any pair of characters is not equal, the method returns false.
If the loop completes without finding any unequal characters, the method returns true, indicating that the two strings are anagrams.
Output:

The program outputs either "Strings are anagrams" or "Strings are not anagrams" based on the result of the anagrams method.*/
