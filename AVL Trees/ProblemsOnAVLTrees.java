Question 1:

Implement a Java program to insert a key into an AVL tree and ensure that the tree remains balanced after each insertion. An AVL tree is a self-balancing binary 
search tree where the heights of the two child subtrees of any node differ by at most one.

Code:
class TreeNode {
    int key, height;
    TreeNode left, right;

    TreeNode(int key) {
        this.key = key;
        this.height = 1;
    }
}

public class AVLTree {

    public static int height(TreeNode node) {
        return (node == null) ? 0 : node.height;
    }

    public static int balanceFactor(TreeNode node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    public static TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    public static TreeNode leftRotate(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public static TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }

        // Perform standard BST insertion
        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        } else {
            // Duplicate keys not allowed
            return root;
        }

        // Update height of current node
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Get the balance factor
        int balance = balanceFactor(root);

        // Left Left Case
        if (balance > 1 && key < root.left.key) {
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && key > root.right.key) {
            return leftRotate(root);
        }

        // Left Right Case
        if (balance > 1 && key > root.left.key) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case
        if (balance < -1 && key < root.right.key) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public static void preOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = null;
        int[] keys = {10, 20, 30, 40, 50, 25};

        for (int key : keys) {
            root = insert(root, key);
        }

        System.out.println("Pre-order traversal of the AVL tree:");
        preOrderTraversal(root);
    }
}


Question 2:

Write a Java program to delete a key from an AVL tree while maintaining the AVL property. Ensure that the tree remains balanced after each deletion.

Code:
class TreeNode {
    int key, height;
    TreeNode left, right;

    TreeNode(int key) {
        this.key = key;
        this.height = 1;
    }
}

public class AVLTreeDeletion {

    public static int height(TreeNode node) {
        return (node == null) ? 0 : node.height;
    }

    public static int balanceFactor(TreeNode node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    public static TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    public static TreeNode leftRotate(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public static TreeNode minValueNode(TreeNode node) {
        TreeNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        // Perform standard BST delete
        if (key < root.key) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.key) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null || root.right == null) {
                TreeNode temp = (root.left != null) ? root.left : root.right;

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else { // One child case
                    root = temp; // Copy the contents of the non-empty child
                }
            } else {
                // Node with two children: Get the inorder successor (smallest
                // in the right subtree)
                TreeNode temp = minValueNode(root.right);

                // Copy the inorder successor's data to this node
                root.key = temp.key;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.key);
            }
        }

        // If the tree had only one node then return
        if (root == null) {
            return root;
        }

        // Update height of the current node
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Get the balance factor
        int balance = balanceFactor(root);

        // Left Left Case
        if (balance > 1 && balanceFactor(root.left) >= 0) {
            return rightRotate(root);
        }

        // Left Right Case
        if (balance > 1 && balanceFactor(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && balanceFactor(root.right) <= 0) {
            return leftRotate(root);
        }

        // Right Left Case
        if (balance < -1
