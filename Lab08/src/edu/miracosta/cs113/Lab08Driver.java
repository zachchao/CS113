package edu.miracosta.cs113;
/**
* Lab08Driver.java
* 
* Class Invariant: 
* 
* @author Zachary Chao <zach.chao@yahoo.com>
* @version 1.0
* 
* Problem - 
* 	1. Write a main function that creates two stacks of Integer objects
* 		and a queue of Integer objects. Store the numbers -1, 15, 23, 44, 4, 99
* 		in the first stack. The top of the stack should store 99.
* 	2. Write a loop to get each number from the first stack and store
* 		it in the second stack and in the queue.
* 	3. Write a second loop to remove a value from the second stack and 
* 		from the queue and display each pair fo values on a seperate output
* 		line. Continue until the data structures are empty. Show the output.
*/
public class Lab08Driver {
	private static ArrayStack<Integer> stack1 = new ArrayStack<Integer>();
	private static ArrayStack<Integer> stack2 = new ArrayStack<Integer>();
	private static LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
	private static Integer[] integers = {-1, 15, 23, 44, 4, 99};
	
	public static void main(String[] args){
		//Problem 1
		for (Integer i : integers){
			stack1.push(i);
		}
		System.out.println("The top of the stack is - " + stack1.peek());
		
		//Problem 2
		for(int i = 0; i < integers.length; i++){
			Integer temp = stack1.pop();
			stack2.push(temp);
			queue.offer(temp);
		}
		
		//Problem 3
		String outputStack = "";
		String outputQueue = "";
		//No need to check both as they will always
		// be the exact same size
		while (queue.poll() != null){
			outputStack += stack2.pop() + " ";
			outputQueue += queue.remove() + " ";
		}
		System.out.println("The data stored into the second stack was - ");
		System.out.println(outputStack);
		System.out.println("The data stored into the queue was - ");
		System.out.println(outputQueue);
	}
}
