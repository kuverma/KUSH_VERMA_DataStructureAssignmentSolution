package ques2;

public class BSTtoRSkewedTree {

	public static class Node {
		// Node class
		int data;
		Node left, right;

		Node(int key) {
			data = key;
			left = right = null;
		}
	};

	private Node creatTree() {
		// this return a tree whose all values are hardcoded below for now.

		Node root = new Node(50);
		root.left = new Node(30);
		root.right = new Node(60);
		root.left.left = new Node(10);
		root.right.left = new Node(55);
		// root.left.right = new Node(40);
		// root.right.right = new Node(70);
		return root;
	}

	private void treeTravel(Node tree) {
		// function to travel the right Skewed tree only.

		if (tree == null) {
			return;
		} else {
			System.out.print(tree.data + " ");
			if (tree.right != null)
				treeTravel(tree.right);
		}

	}

	private Node convertBSTtoSkewedTree(Node tree) {
		// function take a BST tree as parameter and return right Skewed tree

		if (tree == null)
			return null;

		if (tree.left == null && tree.right == null)
			return tree;

		Node root = null;
		if (tree.left != null)
			root = convertBSTtoSkewedTree(tree.left);

		Node temp = root;
		while (temp.right != null)
			temp = temp.right;
		temp.right = tree;
		tree.left = null;

		if (tree.right != null)
			tree.right = convertBSTtoSkewedTree(tree.right);

		return root;
	}

	public static void main(String[] args) {

		BSTtoRSkewedTree brst = new BSTtoRSkewedTree();

		Node tree = brst.creatTree();

		tree = brst.convertBSTtoSkewedTree(tree);

		brst.treeTravel(tree);

	}

}
