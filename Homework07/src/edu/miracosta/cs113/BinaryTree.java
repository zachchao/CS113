package edu.miracosta.cs113;

import java.io.Serializable;
import java.util.Scanner;

public class BinaryTree<E> {
	protected Node<E> root;
	
	public BinaryTree(){
		this.root = null;
	}
	
	protected BinaryTree(Node<E> root){
		this.root = root;
	}
	
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
		this.root = new Node<E>(data);
		if(leftTree != null){
			root.left = leftTree.root;
		}else{
			root.left = null;
		}
		if(rightTree != null){
			root.right = rightTree.root;
		}else{
			root.right = null;
		}
	}
	
	public BinaryTree<E> getLeftSubtree(){
		if(root != null && root.left !=null){
			return new BinaryTree<E>(this.root.left);
		}
		return null;
	}
	
	public BinaryTree<E> getRightSubtree(){
		if(root != null && root.right !=null){
			return new BinaryTree<E>(this.root.right);
		}
		return null;
	}
	
	public E getData(){
		if(root != null){
			return this.root.data;
		}
		return null;
	}
	
	public boolean isLeaf(){
		return this.root.left == null && this.root.right == null;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root, 1, sb);
		return sb.toString();
	}
	
	public void preOrderTraverse(Node<E> node, int depth, StringBuilder sb){
		for(int i = 1; i < depth; i++){
			sb.append("   ");
		}
		if(node == null){
			sb.append("null\n");
		}else{
			sb.append(node.toString() + "\n");
			preOrderTraverse(node.left, depth + 1, sb);
			preOrderTraverse(node.right, depth + 1, sb);
		}
	}
	
	public BinaryTree<E> readBinaryTree(Scanner scan){
		String data = scan.next();
		if(data == null){
			return null;
		}
		BinaryTree<E> leftTree = readBinaryTree(scan);
		BinaryTree<E> rightTree = readBinaryTree(scan);
		return new BinaryTree<E>((E) data, leftTree, rightTree);
	}
	
	
	protected class Node<E> implements Serializable{
		protected E data;
		protected Node<E> left;
		protected Node<E> right;
		
		public Node(E data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		public String toString(){
			if (data == null){
				return "null";
			}
			return this.data.toString();
		}
		
	}
}
