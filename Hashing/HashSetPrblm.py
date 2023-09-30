/* Adding Elements in HashSet /*

// Java program to Adding Elements to HashSet

// Importing required classes
import java.io.*;
import java.util.*;

// Main class
// AddingElementsToHashSet
class GFG {

	// Method 1
	// Main driver method
	public static void main(String[] args)
	{
		// Creating an empty HashSet of string entities
		HashSet<String> hs = new HashSet<String>();

		// Adding elements using add() method
		hs.add("Geek");
		hs.add("For");
		hs.add("Geeks");

		// Printing all string el=ntries inside the Set
		System.out.println("HashSet elements : " + hs);
	}
}
