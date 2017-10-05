package edu.miracosta.cs113;

public class LinkedStackTest {
	public static void main(String[] args){
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		System.out.println("Check if the stack is empty at the start");
		System.out.println("Stack is empty : " + stack.empty());
		stack.push(3);
		System.out.println("Added 3 to the stack");
		stack.push(2);
		System.out.println("Added 2 to the stack");
		stack.push(1);
		System.out.println("Added 1 to the stack");
		System.out.println("Stack is empty : " + stack.empty());
		System.out.println("Added 3 - 2 - 1, now peeking at top");
		System.out.println("Item at top of stack is - " + stack.peek());
		System.out.println("Popping - " + stack.pop());
		System.out.println("Popping - " + stack.pop());
		System.out.println("Popping - " + stack.pop());	
	}
}
