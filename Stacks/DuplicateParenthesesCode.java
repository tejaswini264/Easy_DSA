/*
 *   @Duplicate Parentheses
 *   Givee a balanced expression, find if contains duplicate parentheses or not. A  set of 
 *   parentheses are duplicate if the same subexpression is surrounded by multiple parentheses.
 * 
 *    -> Return a true if it contains duplicates else return false.
 * 
 *   example:  
 *            (i)  -> (((a+(b)))+(c+d))  => true
 *            (ii) -> ((((a)+(b))+c+d))  => true
 *            (iii)-> ((a+b)+(c+d))      => false
 *            (iv) -> (((a+b))+c)        => true
 */

import java.util.Stack;;

public class DuplicateParenthesesCode {

    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // closing
            if (ch == ')') {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count < 1) {
                    return true; // duplicate
                } else {
                    s.pop(); // opening pair
                }
            } else {
                // opening
                s.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str1 = "(((a+(b)))+(c+d))";
        System.out.println(isDuplicate(str1)); // false
        String str2 = "((a+b)+(c+d))";
        System.out.println(isDuplicate(str2)); // true

    }
}


/*isDuplicate method:

The isDuplicate method takes a string str as input and checks for duplicate parentheses.
It uses a stack (Stack<Character> s) to keep track of opening and closing parentheses.
It iterates through the characters of the input string from left to right.
When an opening parenthesis '(' is encountered, it is pushed onto the stack.
When a closing parenthesis ')' is encountered, it checks for the presence of duplicate parentheses by counting the number of characters between the current closing parenthesis and the nearest opening parenthesis. It keeps popping characters from the stack until an opening parenthesis is encountered.
If the count of characters between the opening and closing parentheses is less than 1 (indicating no characters in between), it returns true to indicate the presence of duplicate parentheses. Otherwise, it proceeds by popping the opening parenthesis from the stack.
Finally, if the loop completes without finding duplicate parentheses, the method returns false.
main method:

In the main method, two example strings str1 and str2 are defined.
The isDuplicate method is called with each string as input.
The program prints the result, where true indicates the presence of duplicate parentheses, and false indicates the absence of duplicate parentheses.
Output:

The program checks and prints whether each input string contains duplicate parentheses.*/
