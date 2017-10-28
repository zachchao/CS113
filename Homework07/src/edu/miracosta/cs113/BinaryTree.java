package edu.miracosta.cs113;

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
		return new BinaryTree(this.root.left);
	}
	
	public BinaryTree<E> getRightSubtree(){
		return new BinaryTree(this.root.right);
	}
	
	public E getData(){
		return this.root.data;
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
		return null;
		
	}
	
	
	protected class Node<E>{
		protected E data;
		protected Node<E> left;
		protected Node<E> right;
		
		public Node(E data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
		public String toString(){
			return this.data.toString();
		}
		
	}
}
