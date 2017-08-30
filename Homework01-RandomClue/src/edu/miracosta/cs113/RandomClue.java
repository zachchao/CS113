package edu.miracosta.cs113;
/**
 *RandomClue.java
 *
 *Class Invariant : Assumes user inputs number
 *
 *@author   Zachary Chao <zach.chao@yahoo.com>
 *@version  1.0
 *   
 * Algorithm - 
 * 	creates theory and AssistantJack the same as before
 * 	The change in algorithm exists in how the guesses are made
 *  The changes used to only check if the solution was correct,
 *  if they were it would stop, if not, continue until the solutionw as correct
 *  this is theoretically infinite, if by some chance it never hit the correct solution.
 *  The new algorithm begins at the lowest guesses possible, [1,1,1]
 *  It then takes the feedback from AssistantJack, telling us which 
 *  guess is incorrect and iterating that by one and then checking
 *  the solution set until it is correct. At maximum this will take 20 tries
 *  as it is 5 guesses for the murderer, 5 for the weapon and 10 for the location.
 */
import java.util.Scanner;

public class RandomClue {

	/**
	 * Tester for theory algorithm
	 * 
	 * @param args command line arguments (unnused)
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