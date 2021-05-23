
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import static java.lang.System.out;

import java.awt.*;


/*https://www.mastersofgames.com/rules/roulette-rules.htm
 *https://stackoverflow.com/questions/32103252/expect-arrays-to-be-equal-ignoring-order to check arrays
 
1 to 1 bets
Red: a red number
Black: a black number
Even: an even number
Odd: an odd number
Low bet: numbers 1 - 18
High bet: numbers 19 - 36

2 to 1

First dozen: numbers 1 - 12
Middle dozen: numbers 13 - 24 
Last dozen: numbers 25 - 36

5 to 1: Line bet: 6 numbers - 2 rows of numbers
8 to 1: Corner bet: 4 numbers - a square of 4 numbers
11 to 1: Street bet: a row of 3 numbers 
17 to 1: Split bet: a pair of numbers 
35 to 1: Straight up: a single number

https://www.mastersofgames.com/images/casino/dn-roulette-mat-english-0.jpg 
^ display this image on the main class for RoulettePlayer.java

*/



public class RouletteWheel {
	
	public int moneyRemaining;
	private int whichBet;
	private int betAmount;
	private String stringBetAmount;
	private int whichLine, whichSquare, whichStreet, whichSplit1, whichSplit2, whichStraight;
	private int[] winningNumbers = {}; //use array
	public int moneyWon;
	private boolean winOrNot = false;
	private boolean moneyCheck = false;
	private int wheelSpinner;
	public JFrame rouletteBoard;
	public JPanel rouletteNumbers;
	public Image rouletteBoardFile;
	public JLabel rouletteBoardImage;
	Scanner userBet = new Scanner(System.in);
	
	//copied from edwards casino code
    public static void timeType(int ibtw, String text) throws InterruptedException{
        for(int i = 0; i<text.length(); i++){
            out.print(text.substring(i,i+1));
            TimeUnit.MILLISECONDS.sleep(ibtw);
        }
        TimeUnit.MILLISECONDS.sleep(50);
        out.println("");

    }

    public static void timeTypeMM(int ibtw,String text){
        try {
            timeType(ibtw,text);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
	
	
	
	public RouletteWheel(int money)
	{
		moneyRemaining = money; //money for paying out



	}
	
	public void theRouletteWindow() {
		//create the picture displaying the roulette board
		rouletteBoard = new JFrame("Roulette Board");
	    rouletteBoard.setResizable(false);
	    rouletteBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    rouletteBoard.setSize(500, 800);
	  
	    
	    rouletteNumbers = new JPanel();
	    rouletteBoardFile = new ImageIcon(this.getClass().getResource("rouletteBoard.png")).getImage();
        rouletteBoardFile = rouletteBoardFile.getScaledInstance(500, 750, Image.SCALE_DEFAULT);
	    
	    rouletteBoardImage = new JLabel();
	    rouletteBoardImage.setIcon(new ImageIcon(rouletteBoardFile));
	    rouletteNumbers.add(rouletteBoardImage);
	    rouletteBoard.getContentPane().add(BorderLayout.CENTER, rouletteNumbers);
	    
	    rouletteBoard.setVisible(true);
	}
	
	public void closeTheWindow() {//close and delete the frame
		rouletteBoard.setVisible(false); 
		rouletteBoard.dispose();
		
	}
		

	
	public void Bet() {
		//take user input for bet amount
		System.out.println("How much money would you like to bet?");
		
		stringBetAmount = (userBet.nextLine());
		betAmount = Integer.parseInt(stringBetAmount.replaceAll("[^0-9]", "")); //remove all non digit characters 
		
		
		
		if (betAmount > moneyRemaining) {
			moneyCheck = false;
		} else moneyCheck = true;
		
		
		while (moneyCheck == false) {
			System.out.print("You are too broke to make that big of a bet. Please lower your bet amount: ");
			betAmount = (userBet.nextInt());
			if (betAmount > moneyRemaining) {
				moneyCheck = false;
			} else moneyCheck = true;
		}
		//take money from user to throw into the bet
		moneyRemaining -= betAmount;

		
		//get bet type 
		System.out.println("Which bet would you like to make? (Reference Graphics window)\r\n" 	+ 	
		"1 to 1\r\n" + 
		"\t1. Red: a red number\r\n" + 
		"\t2. Black: a black number\r\n" + 
		"\t3. Even: an even number\r\n" + 
		"\t4. Odd: an odd number\r\n" + 
		"\t5. Low bet: numbers 1 - 18\r\n" + 
		"\t6. High bet: numbers 19 - 36\r\n" +
		"2 to 1\r\n" + 
		"\t7. First dozen: numbers 1 - 12\r\n" + 
		"\t8. Middle dozen: numbers 13 - 24 \r\n" + 
		"\t9. Last dozen: numbers 25 - 36\r\n" +
		"5 to 1: \r\n" +
		"\t10. Line bet: 2 adjacent rows of numbers\r\n" + 
		"8 to 1: \r\n" +
		"\t11. Corner bet: a corner square of 4 numbers\r\n" + 
		"11 to 1: \r\n" +
		"\t12. Street bet: a row of 3 numbers \r\n" + 
		"17 to 1: \r\n" +
		"\t13. Split bet: a pair of numbers \r\n" + 
		"35 to 1: \r\n" + 
		"\t14. Straight up: a single number");
		
		whichBet = (int) userBet.nextInt();
		
		switch (whichBet) {
		case 1: 
			winningNumbers = new int[]{1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};			
			break;
		case 2: 
			winningNumbers = new int[]{2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
			break;
		case 3: 
			winningNumbers = new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36};
			break;
		case 4: 
			winningNumbers = new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35};
			break;
		case 5: 
			winningNumbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
			break;
		case 6: 
			winningNumbers = new int[] {19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
			break;
		case 7: 
			winningNumbers = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};			
			break;
		case 8: 
			winningNumbers = new int[] {13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
			break;
		case 9: 
			winningNumbers = new int[] {25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
			break;
		case 10:  //line bet
			System.out.println("Which line would you like to bet on? \r\n"
					+ "\t Line 1: 1, 2 ,3, 4, 5, 6\r\n"
					+ "\t Line 2: 4, 5, 6, 7, 8, 9\r\n"
					+ "\t Line 3: 7, 8 ,9, 10, 11, 12\r\n"
					+ "\t Line 4: 10, 11, 12, 13, 14, 15\r\n"
					+ "\t Line 5: 13, 14, 15, 16, 17, 18\r\n"
					+ "\t Line 6: 16, 17, 18, 19, 20, 21\r\n"
					+ "\t Line 7: 19, 20, 21, 22, 23, 24\r\n"
					+ "\t Line 8: 22, 23, 24, 25, 26, 27\r\n"
					+ "\t Line 9: 25, 26, 27, 28, 29, 30\r\n"
					+ "\t Line 10: 28, 29, 30, 31, 32, 33\r\n"
					+ "\t Line 11: 31, 32, 33, 34, 35, 36\r\n");
			whichLine = (userBet.nextInt());
			switch (whichLine) {
			case 1: winningNumbers = new int[] {1, 2 ,3, 4, 5, 6};
				break;
			case 2: winningNumbers = new int[] {4, 5, 6, 7, 8, 9};
				break;
			case 3: winningNumbers = new int[] {7, 8 ,9, 10, 11, 12};
				break;
			case 4: winningNumbers = new int[] {10, 11, 12, 13, 14, 15};
				break;
			case 5: winningNumbers = new int[] {13, 14, 15, 16, 17, 18};
				break;
			case 6: winningNumbers = new int[] {16, 17, 18, 19, 20, 21};
				break;
			case 7: winningNumbers = new int[] {19, 20, 21, 22, 23, 24};
				break;
			case 8: winningNumbers = new int[] {22, 23, 24, 25, 26, 27};
				break;
			case 9: winningNumbers = new int[] {25, 26, 27, 28, 29, 30};
				break;
			case 10: winningNumbers = new int[] {28, 29, 30, 31, 32, 33};
				break;
			case 11: winningNumbers = new int[] {31, 32, 33, 34, 35, 36};
				break;
			default: winningNumbers = new int[] {1, 2 ,3, 4, 5, 6}; //if mistake is entered, it will automatically do line 1 
			break;
			}
			break;
		case 11: //square bet
			System.out.println("Which square would you like to bet on? \r\n"
					+ "\t square 1: 1, 2, 4, 5\r\n"
					+ "\t square 2: 2, 3, 5, 6\r\n"
					+ "\t square 3: 4, 5 ,7, 8\r\n"
					+ "\t square 4: 5, 6, 8, 9\r\n"
					+ "\t square 5: 7, 8, 10, 11\r\n"
					+ "\t square 6: 8, 9, 11, 12\r\n"
					+ "\t square 7: 10, 11, 13, 14\r\n"
					+ "\t square 8: 11, 12, 14, 15\r\n"
					+ "\t square 9: 13, 14, 16, 17\r\n"
					+ "\t square 10: 14, 15, 17, 18\r\n"
					+ "\t square 11: 16, 17, 19, 20\r\n"
					+ "\t square 12: 17, 18, 20, 21\r\n"
					+ "\t square 13: 19, 20, 22, 23\r\n"
					+ "\t square 14: 20, 21, 23, 24\r\n"
					+ "\t square 15: 22, 23, 25, 26\r\n"
					+ "\t square 16: 23, 24, 26, 27\r\n"
					+ "\t square 17: 25, 26, 28, 29\r\n"
					+ "\t square 18: 26, 27, 29, 30\r\n"
					+ "\t square 19: 28, 29, 31, 32\r\n"
					+ "\t square 20: 29, 30, 32, 33\r\n"
					+ "\t square 21: 31, 32, 34, 35\r\n"
					+ "\t square 22: 32, 33, 35, 36\r\n");
			whichSquare = (userBet.nextInt());
			switch (whichSquare) {
			case 1: winningNumbers = new int[] {1, 2, 4, 5};
			break;
			case 2: winningNumbers = new int[] {2, 3, 5, 6};
			break;
			case 3: winningNumbers = new int[] {4, 5 ,7, 8};
			break;
			case 4: winningNumbers = new int[] {5, 6, 8, 9};
			break;
			case 5: winningNumbers = new int[] {7, 8, 10, 11};
			break;
			case 6: winningNumbers = new int[] {8, 9, 11, 12};
			break;
			case 7: winningNumbers = new int[] {10, 11, 13, 14};
			break;
			case 8: winningNumbers = new int[] {11, 12, 14, 15};
			break;
			case 9: winningNumbers = new int[] {13, 14, 16, 17};
			break;
			case 10: winningNumbers = new int[] {14, 15, 17, 18};
			break;
			case 11: winningNumbers = new int[] {16, 17, 19, 20};
			break;
			case 12: winningNumbers = new int[] {17, 18, 20, 21};
			break;
			case 13: winningNumbers = new int[] {19, 20, 22, 23};
			break;
			case 14: winningNumbers = new int[] {20, 21, 23, 24};
			break;
			case 15: winningNumbers = new int[] {22, 23, 25, 26};
			break;
			case 16: winningNumbers = new int[] {23, 24, 26, 27};
			break;
			case 17: winningNumbers = new int[] {25, 26, 28, 29};
			break;
			case 18: winningNumbers = new int[] {26, 27, 29, 30};
			break;
			case 19: winningNumbers = new int[] {28, 29, 31, 32};
			break;
			case 20: winningNumbers = new int[] {29, 30, 32, 33};
			break;
			case 21: winningNumbers = new int[] {31, 32, 34, 35};
			break;
			case 22: winningNumbers = new int[] {32, 33, 35, 36};
			break;
			default: winningNumbers = new int[] {1, 2 ,4, 5}; //if mistake is entered, it will automatically do square 1
			break;
			}
			break;
			
		case 12: //street bet
			System.out.println("Which street would you like to bet on? \r\n"
					+ "\t Street 1: 1, 2 ,3\r\n"
					+ "\t Street 2: 4, 5, 6\r\n"
					+ "\t Street 3: 7, 8 ,9\r\n"
					+ "\t Street 4: 10, 11, 12\r\n"
					+ "\t Street 5: 13, 14, 15\r\n"
					+ "\t Street 6: 16, 17, 18\r\n"
					+ "\t Street 7: 19, 20, 21\r\n"
					+ "\t Street 8: 22, 23, 24\r\n"
					+ "\t Street 9: 25, 26, 27\r\n"
					+ "\t Street 10: 28, 29, 30\r\n"
					+ "\t Street 11: 31, 32, 33\r\n"
					+ "\t Street 12: 34, 35, 36\r\n");
			whichStreet = (userBet.nextInt());
			switch (whichStreet) {
			case 1: winningNumbers = new int[] {1, 2 ,3};
				break;
			case 2: winningNumbers = new int[] {4, 5, 6};
				break;
			case 3: winningNumbers = new int[] {7, 8 ,9};
				break;
			case 4: winningNumbers = new int[] {10, 11, 12};
				break;
			case 5: winningNumbers = new int[] {13, 14, 15};
				break;
			case 6: winningNumbers = new int[] {16, 17, 18};
				break;
			case 7: winningNumbers = new int[] {19, 20, 21};
				break;
			case 8: winningNumbers = new int[] {22, 23, 24};
				break;
			case 9: winningNumbers = new int[] {25, 26, 27};
				break;
			case 10: winningNumbers = new int[] {28, 29, 30};
				break;
			case 11: winningNumbers = new int[] {31, 32, 33,};
				break;
			case 12: winningNumbers = new int[] {34, 35, 36};
				break;
			default: winningNumbers = new int[] {1, 2 ,3, 4, 5, 6}; //if mistake is entered, it will automatically do line 1 
			break;
			}
			break; 
		case 13: //split bet
			System.out.print("Enter the first number you would like to bet on between 0 and 36: "); 
			whichSplit1 = (userBet.nextInt());
			
			System.out.print("Enter the Second number you would like to bet on between 0 and 36: "); 
			whichSplit2 = (userBet.nextInt());			
			if (whichSplit1 == whichSplit2) {
				System.out.println("Your number is invalid, default betting on the first number +/- 18"); //default will bet first Number + or - 18)
				if (whichSplit2 > 18) whichSplit2 -= 18;
				else if (whichSplit2 < 18) whichSplit2 += 18;		
			} 
			winningNumbers = new int[] {whichSplit1, whichSplit2};
			break;
		case 14:  //straight up
			System.out.print("Enter the number you would like to bet on between 0 and 36: "); 
			whichStraight = (userBet.nextInt());
			if (whichStraight > 36 || whichStraight < 0) {
				winningNumbers = new int[] {0}; //default will bet 0
				System.out.println("Your number is invalid, default betting on 0");
			} else winningNumbers = new int[] {whichStraight};
			break;
		default: System.out.println("The input is invalid. Default Bet Red is made");
				  winningNumbers = new int[]{1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
         break;
			
		}
//		System.out.println("Bet test");
		
	}
	//spin the wheel and get a number
	public int spinWheel() {
//		System.out.println("wheel test");
		//do the random to spin the wheel
		wheelSpinner = (int) Math.floor(Math.random()*(36-0+1)+0); //used to create a random number from 1 to 36 inclusive 
		timeTypeMM(50, "The wheel landed on: " + wheelSpinner);
		
		return wheelSpinner;
	}
	
	public boolean checkBet(final int[] array, final int number) 	{
//		System.out.println("checkBet test");
		 	 
		
//		 for (int i = 0; i < winningNumbers.length; i++) {
//			 if (winningNumbers[i] == theRouletteSpin) {
//				 winOrNot = true;
//			 } else {
//				 winOrNot = false;
//			 }
//		 }
		
		 winOrNot = Arrays.stream(array).anyMatch(i -> i == number);		 
		 timeTypeMM(50, "The bet win status is: " + winOrNot);
		return winOrNot;
		// pay out money in the player after checking bet
	}
	
	

	
	public int payOutMoney(){
	//	System.out.println("pay test");
		int theRouletteSpin = spinWheel();
		if (this.checkBet(winningNumbers, theRouletteSpin) == false) {
			moneyWon = 0;
		} else {
			switch (whichBet) { //use switch case statement to check which bet is made and pay out the money
			case 1: //1 to 1 
				moneyWon = betAmount * 2;
				break;
			case 2:
				moneyWon = betAmount * 2;
				break;
			case 3:
				moneyWon = betAmount * 2;
				break;
			case 4:
				moneyWon = betAmount * 2;
				break;
			case 5:
				moneyWon = betAmount * 2;
				break;
			case 6:
				moneyWon = betAmount * 2;
				break;
			case 7: //2 to 1
				moneyWon = betAmount * 3;
				break;
			case 8:
				moneyWon = betAmount * 3;
				break;
			case 9:
				moneyWon = betAmount * 3;
				break;
			case 10: //5 to 1
				moneyWon = betAmount * 6;
				break;
			case 11: //8 to 1
				moneyWon = betAmount * 8;
				break;
			case 12: //11 to 1
				moneyWon = betAmount * 11;
				break;
			case 13: //17 to 1
				moneyWon = betAmount * 17;
				break;
			case 14: //35 to 1
				moneyWon = betAmount * 35;
				break;				
			}			
		}	
		timeTypeMM(50, "Amount of money won: " + moneyWon);
		return moneyWon;		
	}



}
