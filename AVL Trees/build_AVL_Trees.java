import java.util.*;

public class build_AVL_Trees {
    static class Node {
        int data;
        int height;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.height = 1;
            this.left = null;
            this.right = null;
        }

    }

    public static Node root;

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    public static int getBalance(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right) + 1);
        x.height = Math.max(height(x.left), height(x.right) + 1);

        // Return new root
        return x;
    }

    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        } else {
            return root; // Duplicate keys not allowed
        }
        // update root height
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Get root's balance factor
        int bf = getBalance(root);

        // left left case
        if (bf > 1 && key < root.left.data) {
            return rightRotate(root);
        }

        // Right Right case
        if (bf < -1 && key > root.right.data) {
            return leftRotate(root);
        }

        // Left Right Case
        if (bf > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right left Case
        if (bf < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root; // returned if AVL balanced
    }

    // Left rotate subtree rooted with x
    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // perform rotation
        y.left = x;
        x.right = T2;

        // update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        levelOrder(root);
    }
}

/*
 * Output:
 * 40
 * 20 50
 * 10 30
 * 25
 */


/*Node class:

Defines a nested Node class to represent the nodes of the AVL tree.
Each node contains:
data: The integer value stored in the node.
height: The height of the node in the tree.
References to its left and right child nodes (left and right).
height method:

Computes and returns the height of a given node in the AVL tree.
If the node is null, it returns 0.
getBalance method:

Computes and returns the balance factor of a given node, which is the difference between the heights of its left and right subtrees.
rightRotate method:

Performs a right rotation on a given node (y) and returns the new root of the subtree.
This rotation is used to balance the AVL tree when the left subtree is taller than the right subtree.
insert method:

Inserts a new node with the specified key into the AVL tree.
Balances the tree using rotations if necessary to maintain the AVL property (balance factor of -1, 0, or 1 for each node).
Handles four possible unbalanced cases: left-left, right-right, left-right, and right-left.
leftRotate method:

Performs a left rotation on a given node (x) and returns the new root of the subtree.
This rotation is used to balance the AVL tree when the right subtree is taller than the left subtree.
levelOrder method:

Performs a level-order traversal of the AVL tree and prints the nodes level by level.
It uses a queue to keep track of nodes at each level.
main method:

In the main method, a series of integers (10, 20, 30, 40, 50, 25) are inserted into the AVL tree by repeatedly calling the insert method.
The program then calls the levelOrder method to print the tree level by level.*/
