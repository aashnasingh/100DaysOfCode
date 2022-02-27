package com.javabasics.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	
	BinaryTreeNode root;
	
	public BinaryTree() {
		BinaryTreeNode a = new BinaryTreeNode(3);
		BinaryTreeNode b = new BinaryTreeNode(2);	
		BinaryTreeNode c = new BinaryTreeNode(7);	
		BinaryTreeNode d = new BinaryTreeNode(4);	
		BinaryTreeNode e = new BinaryTreeNode(-2);	
		BinaryTreeNode f = new BinaryTreeNode(5);	
		
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.right = f;
		this.root = a;
	}
	
	public void bfsPrint() {
		if (root == null) {
			return;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (queue.size() > 0) {
			BinaryTreeNode temp = queue.remove();
			System.out.println(temp.val);
			BinaryTreeNode left = temp.left;
			BinaryTreeNode right = temp.right;
			if (left != null) {
				queue.add(left);							
			}
			if (right != null) {
				queue.add(right);
			}
		}
		
	}
	
	private <T> boolean bfsContains(T target) {
		if (root == null) {
			return false;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (queue.size() > 0) {
			BinaryTreeNode temp = queue.remove();
			if (temp.val == target) {
				return true;
			}
			BinaryTreeNode left = temp.left;
			BinaryTreeNode right = temp.right;
			if (left != null) {
				if (left.val == target) {
					return true;
				}
				queue.add(left);										
			}
			if (right != null) {
				if (right.val == target) {
					return true;
				}
				queue.add(right);
			}
		}
		return false;
	}
	
	private int sumNodes() {
		int sum = 0;
		if (root == null) {
			return 0;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (queue.size() > 0) {
			BinaryTreeNode temp = queue.remove();
			if (temp.val instanceof Integer) {
				sum += (int) temp.val;
			}
			BinaryTreeNode left = temp.left;
			BinaryTreeNode right = temp.right;
			if (left != null) {
				queue.add(left);
			}
			if (right != null) {
				queue.add(right);
			}
		}
		return sum;
	}
	
	private void dfsPrint() {
		Stack<BinaryTreeNode> s = new Stack<>();
		s.push(root);
		while (s.size() > 0) {
			BinaryTreeNode temp = s.pop();
			System.out.println(temp.val);
			BinaryTreeNode left = temp.left;
			BinaryTreeNode right = temp.right;
			if (right != null) {
				s.push(right);
			}
			if (left != null) {// b at top of stack, hence b's children would be explored first
				s.push(left);
			}			
		}
		
	}
	
	//Also Pre Order Traversal as print parent before children
	private void dfsRecPrint(BinaryTreeNode root) {
		
		System.out.println("PreOrder - " + root.val);
		BinaryTreeNode left = root.left;
		if (left != null) {
			dfsRecPrint(left);
		}
		BinaryTreeNode right = root.right;
		if (right != null) {
			dfsRecPrint(right);
		}	
	}
	
	//Post order as children are printed before parent
	private void dfsPostOrderPrint(BinaryTreeNode root) {
		
		BinaryTreeNode left = root.left;
		if (left != null) {
			dfsPostOrderPrint(left);
		}		
		BinaryTreeNode right = root.right;
		if (right != null) {
			dfsPostOrderPrint(right);
		}	
		System.out.println("PostOrder - " + root.val);
	}
	
	//In order as order is left child, root and then right child
	private void dfsInOrderPrint(BinaryTreeNode root) {
		
		BinaryTreeNode left = root.left;
		if (left != null) {
			dfsInOrderPrint(left);
		}		
		System.out.println("InOrder - " + root.val);
		BinaryTreeNode right = root.right;
		if (right != null) {
			dfsInOrderPrint(right);
		}			
	}

	int sum = 0;
	private int dfsRecPreOSum(BinaryTreeNode root) {

		sum = sum + (int) root.val;
		BinaryTreeNode left = root.left;
		if (left != null) {
			dfsRecPreOSum(left);
		}
		BinaryTreeNode right = root.right;
		if (right != null) {
			dfsRecPreOSum(right);
		}
		
		return sum;				
	}
	
	private int dfsRecPreOSumConcise(BinaryTreeNode root) { //https://www.youtube.com/watch?v=fPz40W9mfCg&list=PLxQ8cCJ6LyOZHhAjIYrEFWcfYdyJl5VYf&index=18 at 26:44

		if (root == null) {return 0;}
		return dfsRecPreOSumConcise(root.left) + (int) root.val + dfsRecPreOSumConcise(root.right);
	}
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.bfsPrint();
		boolean ans = binaryTree.bfsContains("e");
		System.out.println(ans);
//		int sum = binaryTree.sumNodes();
//		System.out.println("Sum is : " + sum);
		binaryTree.dfsPrint();
		binaryTree.dfsRecPrint(binaryTree.root);
		binaryTree.dfsPostOrderPrint(binaryTree.root);
		binaryTree.dfsInOrderPrint(binaryTree.root);
//		int sumDFS = binaryTree.dfsRecPreOSum(binaryTree.root);
//		System.out.println("Sum is : " + sumDFS);
//		int sumDFScons = binaryTree.dfsRecPreOSumConcise(binaryTree.root);
//		System.out.println("Sum is : " + sumDFScons);
	}		

}

class BinaryTreeNode<T> {
	T val;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	public BinaryTreeNode(T val, BinaryTreeNode left, BinaryTreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public BinaryTreeNode() {
	}

	public BinaryTreeNode(T val) {
		this.val = val;
	}
	
}
