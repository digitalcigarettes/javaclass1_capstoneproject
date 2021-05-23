package lobby.yahtzee;
import java.util.Random;

import java.util.Scanner;

//this class represents the classic board game yahtzee
//determines the roll of all five dice
public class Yahtzee {
	public int moneyRemaining;
	private int bet;
	private String stringBet;
	private int winnings;
	private boolean moneyCheck;
	private Scanner keyboard = new Scanner (System.in);
	
	public Yahtzee(int money) {
		moneyRemaining = money;
		System.out.println("Enter your bet");
		stringBet = (keyboard.nextLine());
		bet = Integer.parseInt(stringBet.replaceAll("[^0-9]", "")); //remove all non digit characters 
		
		moneyRemaining -= bet;
		
		if (bet > moneyRemaining) {
			moneyCheck = false;
		} else moneyCheck = true;
		
		
		while (moneyCheck == false) {
			System.out.print("You are too broke to make that big of a bet. Please lower your bet amount: ");
			bet = (keyboard.nextInt());
			if (bet > moneyRemaining) {
				moneyCheck = false;
			} else moneyCheck = true;
		}
		
		Random rnd = new Random();
		System.out.print("dice rolled: ");
		int[] dice = new int[5];
		for (int i=0; i < dice.length; i++) {
			dice[i] = rnd.nextInt(6) + 1;;
			System.out.print(dice[i] + " ");
		}

	
	System.out.println();
	System.out.println("Score for each section:");
	System.out.println("Ones: " +ScoreNumber(dice, 1));
	System.out.println("Twos: " +ScoreNumber(dice, 2));
	System.out.println("Threes: " +ScoreNumber(dice, 3));
	System.out.println("Fours: " +ScoreNumber(dice, 4));
	System.out.println("Fives: " +ScoreNumber(dice, 5));
	System.out.println("Sixes: " +ScoreNumber(dice, 6));
	System.out.println("3 of a kind: " +NumOfAKind(dice, 3));
	System.out.println("4 of a kind: " +NumOfAKind(dice, 4));
	System.out.println("Full house: " +House(dice));
	System.out.println("Small Straight: " +Straight(dice,4));
	System.out.println("Large Straight: " +Straight(dice,5));
	System.out.println("Yahtzee: " +Straight(dice,5));
	System.out.println("Chance: " +Chance(dice));
	winnings = 0;
	if (NumOfAKind(dice, 3) >0) {
		winnings += bet*2;
	}
	if (NumOfAKind(dice, 4) >0) {
		winnings += bet*3;
	}
	if (House(dice) >0) {
		winnings += bet*4;
	}
	if (Straight(dice, 4) >0) {
		winnings += bet*5;
	}
	if (Straight(dice, 5) >0) {
		winnings += bet*6;
	}
	if (Straight(dice, 5) >0) {
		winnings += bet*7;
	}
	System.out.println("Winnings:" + winnings);
	moneyRemaining += winnings;

	
	}

	
	
	//calculates the score number for the dice rolled (all the numbers of the same kind added together)
	public static int ScoreNumber(int[] dice, int num) {
			int count = 0;
				for (int i=0; i < dice.length; i++) {
						if (dice[i] == num) {
							count++;
						}
				}
				return count * num;
		}
	//calculates if there are a certain amounts of the same number and the sum of the numbers
	public static int NumOfAKind(int[] dice, int number) {
		int[] counts =  new int[6];
		for (int i=0; i< dice.length; i++) {
			counts[dice[i]-1]++;
		}
		for (int i=0; i<counts.length; i++) {
			if (counts[i] == number) {
				if (number == 5) {
					return 50;
				}
				int sum = 0;
				for (int j=0; j<dice.length; j++) {
					sum = dice[j]+sum;
				}
				return sum;
			}
		}
		return 0;
		}
	
	//calculates if there is a full house and the sum of the numbers together
	public static int House(int[] dice) {
		int[] counts =  new int[6];
		for (int i=0; i< dice.length; i++) {
			counts[dice[i]-1]++;
		}
		boolean hasPair = false;
		boolean hasThree = false;
		for (int i=0; i<counts.length; i++) {
			if (counts[i] == 2) {
				hasPair = true;
			} else if (counts[i] == 3) {
				hasThree = true;
			} else {
				continue;
			}
		}
		if (hasPair==true && hasThree==true) {
			return 25;
		}
		return 0;
		}
	
	//determines if there is a consecutive sequence in the dice and if it is a small or large straight or yahtzee
	//also calculates the sum of the numbers if there is a straight
		public static int Straight(int[]dice, int number) {
			int[] counts =  new int[6];
			for (int i=0; i< dice.length; i++) {
				counts[dice[i]-1]++;
			}
			int numInRow = 0;
			for (int i=0; i<=counts.length; i++) {
				if (i==counts.length || counts[i]==0) {
					if (numInRow==number) {
						if (number==4) {
							return 30;
						} else if (number==5) {
							return 40;
						} else {
							return 0;
						}
					}
					numInRow = 0;
				}
				else {
					numInRow++;
				}
			}
			return 0;
		}
		
	//determines how many extra points are received from chance (the sum of all dices rolled)
	public static int Chance(int[]dice) {
		int sum = 0;
		for (int j=0; j<dice.length; j++) {
			sum = dice[j]+sum;
		}
		return sum;
		}
}
	
	
