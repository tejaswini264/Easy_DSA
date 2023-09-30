/*
 *       Reverse a stack
 */

import java.util.Stack;

public class ReverseStack {

    public static void pushBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int pop = s.pop();
        pushBottom(s, data);
        s.push(pop);
    }

    public static void isReverse(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int data = s.pop();
        isReverse(s);
        pushBottom(s, data);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        isReverse(s);
        while (!s.empty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}

/*
 * output:
 * 1
 * 2
 * 3
 */


/*The provided Java code defines a class named `ReverseStack` that reverses the order of elements in a Stack using recursion. Here's a short description of the code:

1. `pushBottom` Method:
   - This method takes a Stack of integers `s` and an integer `data` as input.
   - It recursively pops elements from the Stack until it reaches an empty Stack.
   - During the recursion, it temporarily stores each popped element and pushes it back onto the Stack, effectively pushing the new `data` to the bottom of the Stack.

2. `isReverse` Method:
   - This method takes a Stack of integers `s` as input.
   - It recursively pops elements from the Stack and then uses the `pushBottom` method to push each element back onto the Stack in reversed order.
   - As a result of this process, the Stack is reversed in-place.

3. `main` Method:
   - In the `main` method, an example Stack `s` is created with elements {1, 2, 3}.
   - The `isReverse` method is called to reverse the order of elements in the Stack.
   - The reversed Stack is then printed to the console using a loop, demonstrating the reversed order of elements.

When you run this code, it will output:
```
1
2
3
```
indicating that the original Stack {1, 2, 3} has been reversed to {3, 2, 1}.*/
