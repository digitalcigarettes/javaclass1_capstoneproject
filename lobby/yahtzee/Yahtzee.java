import java.util.Random;

public class Yahtzee {
	public static int ScoreNumber(int[] dice, int num) {
			int count = 0;
				for (int i=0; i < dice.length; i++) {
						if (dice[i] == num) {
							count++;
						}
				}
				return count * num;
		}

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

public static int Chance(int[]dice) {
	int sum = 0;
	for (int j=0; j<dice.length; j++) {
		sum = dice[j]+sum;
	}
	return sum;
	}


	public static void main(String[] args) {
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
	}
}