package edu.miracosta.cs113;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
/**
 * MorseTree.java
 * 
 * Class Invariant: Will just return null for any characters that are not A-Z or a-z
 * 
 * @author Zachary Chao <zach.chao@yahoo.com>
 * @version 1.0
 * 
 * Algorithm - 
 * 	Constructor will create a binary search tree which takes morse code
 * 		as directions to traverse the tree and holds the characters value
 * 		inside of each node.
 * 	The values will first be read in from a file and configured into a hashmap
 * 	I do this to get some practice with them before comp and because it seems appropriate
 * 	Then I have a private method called constructTree which is recursive and constructs the tree
 * 		This is done by simply calling the hashmap everytime I traverse left and right until
 * 		the value is null, then stopping the recursion and returning null for that node
 * 	Other methods include - 
 * 	encode and decode
 * 	In the prompt it is not specified to use the tree to encode
 * 		So I used the hashmap, a simple for loop on each word, searching the hashmap
 * 	Decode is very much like encode just instead of using the hashmap employs the tree
 * 		It uses a search method which is private
 * 			search recursively follows the morseCode string as directions to traverse the tree
 * 			when the string is exhausted it returns the node of the tree which it is currently in
 */
public class MorseTree {
	//The tree which will hold the binaryTree to decode morse code
	private BinaryTree<Character> tree = new BinaryTree<Character>();
	private HashMap<String, Character> decoderMap = new HashMap<String, Character>();
	private HashMap<Character, String> encoderMap = new HashMap<Character, String>();
	public final String FILE_NAME = "src/MorseCode";
	
	/**
     * Constructs the MorseTree by reading in from a file
     * and invoking the constructTree() method to construct the tree
     * @return none
     */
	public MorseTree() throws IOException {
		//Read the values in from the file
		File directory = new File(FILE_NAME);
		FileReader in = new FileReader(directory);
		BufferedReader br = new BufferedReader(in);
		String line;
		
		while((line = br.readLine()) != null)
		{
			String[] lineRay = line.split(" ");
			decoderMap.put(lineRay[1], lineRay[0].charAt(0));
			encoderMap.put(lineRay[0].charAt(0), lineRay[1]);
		}
		//After the hashmaps have been created, call the constructTree method
		tree = constructTree("");
		//For testing if the tree was appropriately constructed
		//System.out.println(tree);
		br.close();
	}
	
	/**
	 * Takes in a string of morse code delimited by spaces and
	 * decodes it back to alphabet using a tree
	 * @param toDecode The string to decode
	 * @return The decoded string in alphabet
	 */
	public String decode(String toDecode){
		String[] toDecodeArray = toDecode.split(" ");
		String returnString = "";
		//Use the tree instead of the hashmap
		for(String s : toDecodeArray){
			if(s.equals("")){
				returnString += " ";
			}else{
				//Call private search method
				returnString += String.valueOf(search(s, tree));
			}
		}
		return returnString;
	}
	
	/**
	 * Assumes valid morse code is passed
	 * Is recursive, just traverses the tree using morse code as its directions
	 * @param find The string to find
	 * @param searchTree The tree to traverse left or right
	 * @return The value of the morseCode
	 */
	private Character search(String find, BinaryTree<Character> searchTree){
		if(find.length() == 0){
			return searchTree.getData();
		}
		//If its a star go left, else go right
		//recursive so call yourself with the string truncated to cut off the start char which we just traversed
		//by calling getLeft or getRight
		if(find.charAt(0) == '*'){
			return search(find.substring(1), searchTree.getLeftSubtree());
		}
		return search(find.substring(1), searchTree.getRightSubtree());
	}
	
	
	/**
	 * Assumes no punctuation or numbers, if there are it will simply put null
	 * Takes in a string and encodes it to morse code, seperated by spaces
	 * Each space is delimited by a space so a space between words is represented
	 * by three spaces
	 * @param toEncode The string to encode
	 * @return The encoded morse code
	 */
	public String encode(String toEncode){
		String[] toEncodeArray = toEncode.toLowerCase().split("");
		String returnString = "";
		for(String s : toEncodeArray){
			if(s.equals(" ")){
				returnString += " ";
			}else{
				returnString += encoderMap.get(s.charAt(0)) + " ";
			}
		}
		return returnString;
	}
	
	/**
	 * Given a hashmap, construct a binary tree to decode morse code
	 * Recursive method with a stopping case of when the hashmap has no value 
	 * for the morse code
	 * @param encode The string to put into the tree
	 * @return The completed BinaryTree
	 */
	private BinaryTree<Character> constructTree(String encode){
		//Reached a leaf
		if(decoderMap.get(encode) == null && encode != ""){
			return null;
		}
		//System.out.println(decoderMap.get(encode));
		BinaryTree<Character> left = constructTree(encode + "*");
		BinaryTree<Character> right = constructTree(encode + "-");
		return new BinaryTree<Character>(decoderMap.get(encode), left, right);
	}
	
	public String toString(){
		return tree.toString();
	}
}
