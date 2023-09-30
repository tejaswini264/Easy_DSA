/*Find the largest BST subtree in a given Binary Tree*/

import java.util.*;

class Main {
	public static int[] largestBSTBT(Node root)
	{

		if (root == null)
			return new int[] { Integer.MAX_VALUE,
							Integer.MIN_VALUE, 0 };
		if (root.left == null && root.right == null)
			return new int[] { root.data, root.data, 1 };


		int[] left = largestBSTBT(root.left);
		int[] right = largestBSTBT(root.right);


		int[] ans = new int[3];


		if ((left[1] < root.data)
			&& (right[0] > root.data)) {
			ans[0] = Math.min(
				left[0], Math.min(right[0], root.data));
			ans[1] = Math.max(right[1],
							Math.max(left[1], root.data));

			ans[2] = 1 + left[2] + right[2];
			return ans;
		}


		ans[0] = Integer.MIN_VALUE;
		ans[1] = Integer.MAX_VALUE;
		ans[2] = Math.max(left[2], right[2]);

		return ans;
	}

	public static int largestBSTBTutil(Node root)
	{
		return largestBSTBT(root)[2];
	}

	public static void main(String[] args)
	{

		Node root = new Node(50);
		root.left = new Node(75);
		root.right = new Node(45);
		root.left.left = new Node(40);
		System.out.println("Size of the largest BST is "
						+ largestBSTBTutil(root));
	}
}

class Node {
	int data;
	Node left, right;

	Node(int val)
	{
		this.data = val;
		left = null;
		right = null;
	}
}
