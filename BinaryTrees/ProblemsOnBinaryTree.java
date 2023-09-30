Question 1:

Implement a Java function to find the maximum depth (height) of a binary tree. The maximum depth is the length of the longest path from the root node to a leaf node.

  Code:
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class MaxDepthBinaryTree {

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int depth = maxDepth(root);
        System.out.println("Maximum depth of the binary tree: " + depth);
    }
}


Question 2:

Given a binary tree, implement a Java function to check whether it is a valid binary search tree (BST). A BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

  Code:
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class ValidateBST {

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private static boolean isValidBST(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        int val = node.val;

        if (lower != null && val <= lower) {
            return false;
        }

        if (upper != null && val >= upper) {
            return false;
        }

        if (!isValidBST(node.right, val, upper)) {
            return false;
        }

        if (!isValidBST(node.left, lower, val)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        boolean isValid = isValidBST(root);
        System.out.println("Is the binary tree a valid BST? " + isValid);
    }
}
