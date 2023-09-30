/* Problem Statement: Given a set of strings, find the longest common prefix.
Examples:

Input: {“geeksforgeeks”, “geeks”, “geek”, “geezer”}
Output: “gee” */

// Java program to find longest common prefix of
// given array of words.
import java.util.*;

public class GFG
{
	public String longestCommonPrefix(String[] a)
	{
		int size = a.length;

		/* if size is 0, return empty string */
		if (size == 0)
			return "";

		if (size == 1)
			return a[0];

		/* sort the array of strings */
		Arrays.sort(a);

		/* find the minimum length from first and last string */
		int end = Math.min(a[0].length(), a[size-1].length());

		/* find the common prefix between the first and
		last string */
		int i = 0;
		while (i < end && a[0].charAt(i) == a[size-1].charAt(i) )
			i++;

		String pre = a[0].substring(0, i);
		return pre;
	}

	/* Driver Function to test other function */
	public static void main(String[] args)
	{
		GFG gfg = new GFG();
		String[] input = {"geeksforgeeks", "geeks", "geek", "geezer"};
		System.out.println( "The longest Common Prefix is : " +
								gfg.longestCommonPrefix(input));
	}
}
