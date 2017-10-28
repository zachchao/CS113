package edu.miracosta.cs113;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MorseTree {
	private BinaryTree<Character> tree = new BinaryTree<Character>();
	private HashMap<String, Character> morseMapping = new HashMap<String, Character>();
	public final String FILE_NAME = "src/MorseCode";
	
	public MorseTree() throws IOException {
		//Read the values in from the file
		File directory = new File(FILE_NAME);
		FileReader in = new FileReader(directory);
		BufferedReader br = new BufferedReader(in);
		String line;
		
		while((line = br.readLine()) != null)
		{
			String[] lineRay = line.split(" ");
			morseMapping.put(lineRay[1], lineRay[0].charAt(0));
		}
		tree = constructTree("", null, null);
		System.out.println(tree.getLeftSubtree());
	}
	
	//Construct the tree
	//Left is *, right is -
	//Invoked with the first left value of '*'
	//Left and right are the left and rights of the tree which are to be set 
	private BinaryTree<Character> constructTree(String val, BinaryTree<Character> left, BinaryTree<Character> right){
		System.out.println(val);
		Character leftVal = morseMapping.get(val + "*");
		Character rightVal = morseMapping.get(val + "-");
		
		//Stopping case if you are in a leaf and its not the first case
		if(morseMapping.get(val) == null && val != ""){
			return new BinaryTree<Character>();
		}
		//Stopping case is when you reach a leaf
		if(leftVal == null && rightVal == null){
			return new BinaryTree<Character>(morseMapping.get(val), null, null);
		}
		//Stopping case if left is leaf but right is not leaf
		if(leftVal == null){
			left = new BinaryTree<Character>(null, new BinaryTree<Character>(), new BinaryTree<Character>());
			right = constructTree(val += "-", new BinaryTree<Character>(), new BinaryTree<Character>());
			return new BinaryTree<Character>(morseMapping.get(val), left, right);
		}
		//Stopping case if right is leaf but left is not leaf
		if(right == null){
			left = constructTree(val += "*", new BinaryTree<Character>(), new BinaryTree<Character>());
			right = new BinaryTree<Character>(null, new BinaryTree<Character>(), new BinaryTree<Character>());
			return new BinaryTree<Character>(morseMapping.get(val), left, right);
		}
		//Else
		left = constructTree(val + "*", null, null);
		right = constructTree(val += "-", null, null);
		return new BinaryTree<Character>(morseMapping.get(val), left, right);
	}
	
	
	
	
}
