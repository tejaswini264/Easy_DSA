// Java implementation to construct a BST
// from its level order traversal

import java.io.*;

class GFG {

	// node of a BST
	static class Node {
		int data;
		Node left, right;
	};

	// function to get a new node
	static Node getNode(int data)
	{
		// Allocate memory
		Node newNode = new Node();

		// put in the data
		newNode.data = data;
		newNode.left = newNode.right = null;
		return newNode;
	}

	// function to construct a BST from
	// its level order traversal
	static Node LevelOrder(Node root, int data)
	{
		if (root == null) {
			root = getNode(data);
			return root;
		}
		if (data <= root.data)
			root.left = LevelOrder(root.left, data);
		else
			root.right = LevelOrder(root.right, data);
		return root;
	}

	static Node constructBst(int arr[], int n)
	{
		if (n == 0)
			return null;
		Node root = null;

		for (int i = 0; i < n; i++)
			root = LevelOrder(root, arr[i]);

		return root;
	}

	// function to print the inorder traversal
	static void inorderTraversal(Node root)
	{
		if (root == null)
			return;

		inorderTraversal(root.left);
		System.out.print(root.data + " ");
		inorderTraversal(root.right);
	}

	// Driver code
	public static void main(String args[])
	{
		int arr[] = { 7, 4, 12, 3, 6, 8, 1, 5, 10 };
		int n = arr.length;

		Node root = constructBst(arr, n);

		System.out.print("Inorder Traversal: ");
		inorderTraversal(root);
	}
}

// This code is contributed by Arnab Kundu
