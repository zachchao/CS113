package edu.miracosta.cs113;

import java.io.IOException;

public class MorseTest {
	public static void main(String[] args) throws IOException{
		MorseTree tree = new MorseTree();
		String encodedString = tree.encode("hello how are you");
		System.out.println(encodedString);
		System.out.println(tree.decode(encodedString));
	}
}
