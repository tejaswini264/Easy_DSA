/* Minimum number of deletions to make a string palindrome
Given a string of size ‘n’. The task is to remove or delete the minimum number of characters from the string so that the resultant string is a palindrome.*/

// Java program for above approach
import java.io.*;
import java.util.*;
 
class GFG{
 
// Function to return minimum
// Element between two values
public static int min(int x, int y)
{
    return (x < y) ? x : y;
}
  
// Utility function for calculating
// Minimum element to delete
public static int utility_fun_for_del(String str,
                                      int i, int j)
{
    if (i >= j)
        return 0;
  
    // Condition to compare characters
    if (str.charAt(i) == str.charAt(j))
    {
         
        // Recursive function call
        return utility_fun_for_del(str,
                                   i + 1, j - 1);
    }
  
    // Return value, incrementing by 1
    return 1 + Math.min(utility_fun_for_del(str, i + 1, j),
                        utility_fun_for_del(str, i, j - 1));
}
  
// Function to calculate the minimum
// Element required to delete for
// Making string palindrome
public static int min_ele_del(String str)
{
     
    // Utility function call
    return utility_fun_for_del(str, 0,
                               str.length() - 1);
}
 
// Driver Code
public static void main(String[] args)
{
    String str = "abefbac";
     
    System.out.println("Minimum element of deletions = " +
                       min_ele_del(str));
}
}
