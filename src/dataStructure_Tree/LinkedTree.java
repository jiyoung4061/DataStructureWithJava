package dataStructure_Tree;

import java.util.List;

public class LinkedTree<E> {

	private TreeNode<E> root; // root노드 저장할 변수

	public LinkedTree(E data) { // 생성자 함수
		root = new TreeNode<E>(data);
	}

	public TreeNode<E> getRoot() {
		return root;
	}

	public TreeNode<E> insertLeft(TreeNode<E> node, E data) {
		TreeNode<E> leftNode = new TreeNode<E>(data);
		node.left = leftNode;
		return leftNode;
	}

	public TreeNode<E> insertRight(TreeNode<E> node, E data) {
		TreeNode<E> rightNode = new TreeNode<E>(data);
		node.right = rightNode;
		return rightNode;
	}

	public void traversalPostorder(List<E> result) {
		traversalPostorder(root, result);
	}

	public void traversalPostorder(TreeNode<E> node, List<E> result) {

		if (node.left != null) {
			traversalPostorder(node.left, result);
		}

		if (node.right != null) {
			traversalPostorder(node.right, result);
		}

		result.add(node.data);

	}

	public void traversalInorder(List<E> result) {
		traversalInorder(root, result);
	}

	public void traversalInorder(TreeNode<E> node, List<E> result) {
		if(node.left != null) {
			traversalInorder(node.left, result);
		}
		result.add(node.data);
		if(node.right != null) {
			traversalInorder(node.right, result);
		}
	}

	public void traversalPreorder(List<E> result) {
		traversalPreorder(root, result);
	}

	public void traversalPreorder(TreeNode<E> node, List<E> result) {
		result.add(node.data);
		if(node.left != null) {
			traversalPreorder(node.left, result);
		}
		if(node.right != null) {
			traversalPreorder(node.right, result);
		}
	}

	// innerclass로 트리노드 선언
	public static class TreeNode<E> {
		private TreeNode<E> left;
		private TreeNode<E> right;
		private E data;

		public TreeNode(E data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
}
