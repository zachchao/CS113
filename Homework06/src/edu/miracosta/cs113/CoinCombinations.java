package edu.miracosta.cs113;
/**
 * CoinCombinations.java
 * 
 * Class Invariant: 
 * 
 * @author Zachary Chao <zach.chao@yahoo.com>
 * @version 1.0
 * 
 * Algorithm - 
 * 
 */
public class CoinCombinations {
	/**
	 * Calls the method
	 * @param args Command Line arguments not used
	 */
	public static void main(String[] args){
		int change = 32;
		System.out.println(countCombinations(change, 0, 0, 0, 0));
	}
	
	/**
	 * Finds the amount of combinations of coins given a change to be given
	 * Begins by giving the biggest denominations
	 * We simply whittle down in the order of
	 * Nickels - 1 to 5 pennies
	 * Then when all nickels are gone
	 * Dimes - 1 to 2 nickels
	 * Then when all nickels and dimes are gone
	 * Quarters - 1 to 2 dimes and 1 nickel
	 * We simply recurse with new combinations, continually
	 * converting coins down to the next denomination in the aforementioned order
	 * Once all coins have become pennies we are done
	 * 
	 * Through these conversions we must never forget to return pennies to nickels
	 * so we are sure to hit ever combination
	 * 
	 * @param change The amount of change to give
	 * @param quarters The amount of quarters to return
	 * @param dimes The amount of dimes to return
	 * @param nickles The amount of nickels to return
	 * @param pennies The amount of pennies to return
	 * @return The amount of combinations of change
	 */
	public static int countCombinations(int change, int quarters, int dimes, int nickels, int pennies){
		//The stopping case, when all coins have been whittled down to only pennies
		//Then we are done and we return 1 because it is one more case
		if (change == pennies){
			System.out.printf("%3d %3d %3d %3d\n", quarters, dimes, nickels, pennies);
			return 1;
		}else{
			//Hold the original change we are to give back so we can
			//manipulate the change variable 
			int oldChange = change;
			//The first time the method is called we have to start with
			//The largest denominations then continue to call ourself
			//until the change is held in all pennies
			if(quarters == 0 && dimes == 0 && nickels == 0 && pennies == 0){
				//Output the top
				System.out.printf("%3s %3s %3s %3s\n", "Q", "D", "N", "P");
				//Set the amount of quarters
				quarters = change / 25;
				//Subtract the change put into quarters from the change
				change -= quarters * 25;
				//Set the amount of dimes
				dimes = change / 10;
				//Subtract the change put into dimes from the change
				change -= dimes * 10;
				//Set the amount of nickels
				nickels = change / 5;
				//Subtract the change put into nickels from the change
				change -= nickels * 5;
				//Set the amount of pennies
				pennies += change;
				//Begin the recursion
				return countCombinations(oldChange, quarters, dimes, nickels, pennies);
			//Every other time
			}else{
				//Print out the previous combination
				System.out.printf("%3d %3d %3d %3d\n", quarters, dimes, nickels, pennies);
				//We whittle down nickels first because there is a one to five conversion
				//Nothing else, for all other coins there is more than one conversion
				//ie, dimes can be 2 nickels OR 1 nickel and 5 pennies
				//whilst nickels can only be five pennies
				//we cannot call return twice so we must whittle down nickels first.
				if (nickels > 0){
					//Convert nickels into pennies
					nickels -= 1;
					pennies += 5;
					//Recurse with the new combination
					return 1 + countCombinations(oldChange, quarters, dimes, nickels, pennies);
				}
				//The second to whittle down is dimes, we can do a direct conversion because
				//we always whittle down nickels after this call
				//Nickels is 0 and there are dimes left
				else if (dimes > 0){
					//Convert one dime to two nickels
					dimes -= 1;
					nickels += 2;
					//Convert all pennies into nickels to reset and make sure
					//we hit all cases
					int remNickles = pennies / 5;
					pennies -= remNickles * 5;
					nickels += remNickles;
					//Recurse with the new combination
					return 1 + countCombinations(oldChange, quarters, dimes, nickels, pennies);
				}
				//Both dimes and nickels are zero but there are quarters left
				//Lastly if they are both zero we reduce the quarter
				else if (quarters > 0){
					//Reduce a quarter into two dimes and a nickel
					quarters -= 1;
					dimes += 2;
					nickels += 1;
					
					//Re allocate pennies into nickels
					int remNickles = pennies / 5;
					pennies -= remNickles * 5;
					nickels += remNickles;

					//Re allocate nickels into dimes
					int remDimesOfNickles = nickels / 2;
					nickels -= remDimesOfNickles * 2;
					dimes += remDimesOfNickles;
					//Recurse with the new combination
					return 1 + countCombinations(oldChange, quarters, dimes, nickels, pennies);
				}
			}
		}
		//Unreachable
		return 0;
	}
}
