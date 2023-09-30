import javax.print.StreamPrintService;

/*
 *                String Compression   
 *     "aaabbcccdd"        - >  "a3b2c3d2"
 *     "aaaaabbbcccccc"    - >  "a5b3c6"
 */

public class compressionString {
    public static String compress(String str){
        StringBuilder sb=new StringBuilder("");
        for(int i=0; i<str.length(); i++){
            int count=1;
            while (i<str.length()-1 && str.charAt(i)== str.charAt(i+1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if (count>1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }
  
    public static void main(String[] args) {
        System.out.println(compress("aaabbcccdd"));
    }

}

/*The provided Java code is an implementation of a string compression algorithm. It takes an input string and compresses it by representing consecutive repeating characters as the character followed by the count of repetitions. Here's a description of the code:

1. **`compress` Method**: This method takes a string `str` as input and returns a compressed version of the input string. It uses a `StringBuilder` (`sb`) to build the compressed string.

2. Inside the method, there is a `for` loop that iterates through the characters of the input string.

3. A variable `count` is initialized to 1, representing the count of consecutive repeating characters.

4. Within a `while` loop, the code checks if the current character is the same as the next character. If they are the same, the `count` is incremented, and the loop advances to the next character. This loop continues until the characters are different.

5. The character at the current position is appended to the `StringBuilder` `sb`.

6. If the `count` is greater than 1 (indicating consecutive repeating characters), the count is also appended to `sb`.

7. The method continues processing the characters in the input string, repeating the above steps until all characters are processed.

8. The compressed string is constructed in `sb`, and the method returns it as a string.

9. **`main` Method**: In the `main` method, an example string "aaabbcccdd" is passed to the `compress` method, and the compressed result is printed to the console.

**Output**:
For the input "aaabbcccdd," the code will produce the compressed string "a3b2c3d2."

The code efficiently compresses strings with consecutive repeating characters, reducing the overall length of the string while retaining the original information.*/
