package edu.miracosta.cs113;

public class CoinCombinations {
	public static void main(String[] args){
		System.out.println(countCombinations(75, 0, 0, 0, 0, true));
	}
	
	public static int countCombinations(int change, int quarters, int dimes, int nickles, int pennies, boolean first){
		if (change == pennies){
			System.out.printf("%3d %3d %3d %3d\n", quarters, dimes, nickles, pennies);
			return 1;
		}else{
			int oldChange = change;
			//First time
			if(first == true){
				System.out.printf("%3s %3s %3s %3s\n", "Q", "D", "N", "P");
				quarters = change / 25;
				change -= quarters * 25;
				dimes = change / 10;
				change -= dimes * 10;
				nickles = change / 5;
				change -= nickles * 5;
				pennies += change;
				first = false;
				return countCombinations(oldChange, quarters, dimes, nickles, pennies, false);
			//Every other time
			}else{
				System.out.printf("%3d %3d %3d %3d\n", quarters, dimes, nickles, pennies);
				if (nickles > 0){
					nickles -= 1;
					pennies += 5;
					return 1 + countCombinations(oldChange, quarters, dimes, nickles, pennies, false);
				}
				else if (dimes > 0){
					dimes -= 1;
					nickles += 2;
					//Nickels is 0 and there are dimes left
					int remNickles = pennies / 5;
					pennies -= remNickles * 5;
					nickles += remNickles;
					return 1 + countCombinations(oldChange, quarters, dimes, nickles, pennies, false);
				}
				//Both dimes and nickels are zero but there are quarters left
				else if (quarters > 0){
					quarters -= 1;
					dimes += 2;
					nickles += 1;
					//Nickels is 0 and dimes is zero but there are quarters left
					
					//Re allocate pennies into nickels
					int remNickles = pennies / 5;
					pennies -= remNickles * 5;
					nickles += remNickles;

					//Re allocate nickels into dimes
					int remDimesOfNickles = nickles / 2;
					nickles -= remDimesOfNickles * 2;
					dimes += remDimesOfNickles;
					int remDimes = pennies / 10;
					pennies -= remDimes * 10;
					dimes += remDimes;
					
					return 1 + countCombinations(oldChange, quarters, dimes, nickles, pennies, false);
				}
			}
		}
		//Unreachable
		System.out.println("REACHED");
		return 0;
	}
}
