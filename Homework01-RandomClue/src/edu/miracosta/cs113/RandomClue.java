package edu.miracosta.cs113;
/**
 * RandomClue.java : Random solver for the Clue problem
 * 
 * @author Zachary Chao
 * @version 1.0
 *
 */

import java.util.Scanner;

public class RandomClue {

	/**
	 * Tester for theory algorithm
	 * 
	 * @param args
	 *            command line arguments (unnused)
	 */
	public static void main(String[] args) {
		int answerSet, solution, murder, weapon, location;
		Scanner keyboard = new Scanner(System.in);
		Theory answer = null;
		AssistantJack jack;

		System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");
		answerSet = keyboard.nextInt();
		keyboard.close();

		jack = new AssistantJack(answerSet);
		int answerList[] = {1,1,1};
		
		do {
			solution = jack.checkAnswer(answerList[0],answerList[1],answerList[2]);
			if(solution != 0){
				answerList[solution-1] += 1;
			}
		} while (solution != 0);
		
		answer = new Theory(answerList[0],answerList[1],answerList[2]);
		System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution = " + answer);

		if (jack.getTimesAsked() > 20) {
			System.out.println("FAILED!! You're a horrible Detective...");
		} else {
			System.out.println("WOW! You might as well be called Batman!");
		}
	}

}