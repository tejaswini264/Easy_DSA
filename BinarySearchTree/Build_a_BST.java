/*
 *      Build a Binary Search Tree
 *     [to Remember: BST makes search efficient]
 */

public class Build_a_BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildBST(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (root.data > value) {
            // left Subtree Search
            root.left = buildBST(root.left, value);
        } else {
            // right Subtree Search
            root.right = buildBST(root.right, value);
        }
        return root;
    }

    // inorder treversing
    public static void printTree(Node root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        int value[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;

        for (int i = 0; i < value.length; i++) {
            root = buildBST(root, value[i]);
        }

        printTree(root);
    }
}

/*
 * 1 2 3 4 5 7
 */

 /* Node class:

Defines a nested Node class to represent the nodes of the BST. Each node contains an integer value (data) and references to its left and right child nodes (left and right).
buildBST method:

This method takes as input the current root node of the BST and an integer value to insert into the BST.
If the root is null, it creates a new node with the given value and returns it as the new root of the BST.
If the root is not null, it compares the value with the data in the current root node and decides whether to insert the value into the left or right subtree accordingly, using a recursive call.
It returns the updated root after inserting the value.
printTree method (in-order traversal):

This method performs an in-order traversal of the BST, which visits the nodes in ascending order.
It takes the root of the BST as input and recursively traverses the left subtree, prints the data of the current node, and then recursively traverses the right subtree.
main method:

In the main method, an array value is defined, which contains integers to be inserted into the BST.
An initially null root node is created to represent the root of the BST.
Insertion into BST:

A for loop iterates through the elements of the value array and inserts each element into the BST using the buildBST method. This process builds the BST structure.
Printing the BST (in-order traversal):

After building the BST, the program calls the printTree method with the root of the BST to print the elements in ascending order.
When you run the program, it will construct a BST from the given values and then print the elements in ascending order, demonstrating that the BST maintains the property where elements to the left of a node are less than the node's value, and elements to the right are greater. */
