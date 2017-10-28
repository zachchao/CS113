package edu.miracosta.cs113;

import java.util.HashMap;

public class Test {
	
	private static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	public static void main(String[] args){
		map.put(5, 4);
		map.put(5, 3);
		System.out.println(map.get(5));
	}
}
