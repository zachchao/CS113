package edu.miracosta.cs113;


public class Test{
	public static void main(String[] args){
		HashtableChain<String, String> test = new HashtableChain<String, String>();
		
		test.put("Hello", "World");
		test.put("Goodbye", "World");
		test.put("Bitcoin", "Good");
		
		System.out.println(test.get("Hello"));
		test.remove("Hello");
		System.out.println(test.get("Hello"));
	}
}


