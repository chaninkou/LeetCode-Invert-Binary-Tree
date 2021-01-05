package leetcode226;

import java.util.LinkedList;
import java.util.Queue;

public class FindInvertTree {
	// Using level order traversal or BFS
	public TreeNode invertTree(TreeNode root) {

		// Always do error checking first
		if (root == null) {
			return null;
		}

		// FIFO
		Queue<TreeNode> queue = new LinkedList<>();

		// offer is the same as add
		queue.offer(root);

		// While its not empty
		while (!queue.isEmpty()) {
			// poll() is the same thing as remove() the first element(FIFO)
			final TreeNode node = queue.poll();

			// Swap left to right
			// Swap right to left
			final TreeNode left = node.left;

			node.left = node.right;

			node.right = left;

			// Not done yet cause we have to do it for each level
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}

		// Since this is like the pointer
		return root;
	}

	// Using stack data structure
	// public TreeNode invertTree(TreeNode root){

	// if(root == null){
	// return null;
	// }

	// final Deque<TreeNode> stack = new LinkedList<>();

	// stack.push(root);

	// while(!stack.isEmpty()){
	// final TreeNode node = stack.pop();

	// final TreeNode left = node.left;

	// node.left = node.right;

	// node.right = left;

	// if(node.left != null){
	// stack.push(node.left);
	// }

	// if(node.right != null){
	// stack.push(node.right);
	// }
	// }

	// return root;
	// }

	// Recursive dfs, easy, but might overflow
	// public TreeNode invertTree(TreeNode root) {

	// if(root == null){
	// return null;
	// }

	// final TreeNode left = root.left;

	// final TreeNode right = root.right;

	// root.left = invertTree(right);

	// root.right = invertTree(left);

	// return root;
	// }
}
