import java.util.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
	
	private int moneyRemaining;
	private int[] theBet;
	private int whichBet = 0;
	private int[] winningNumbers; //use array
	private boolean winOrNot = false;
	public JFrame rouletteBoard;
	public JPanel rouletteNumbers;
	public Image rouletteBoardFile;
	public JLabel rouletteBoardImage;
	Scanner userBet = new Scanner(System.in);
	
	
	
	public RouletteWheel(int money)
	{
		moneyRemaining = money;
		
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

		

	
	public void Bet() {
		
		System.out.println("text");
		whichBet = (userBet.nextInt());

		
	}
	
	public int spinWheel() {
		//do the random to spin the wheel
		return 1;
	}
	
	public boolean checkBet(){		
		 for (int i = 0; i < winningNumbers.length; i++) {
			 if (winningNumbers[i] == this.spinWheel()) {
				 winOrNot = true;
			 } else {
				 winOrNot = false;
			 }
		 }
		return winOrNot;
		// pay out money in the player after checking bet
	}
	
	public int payOutMoney(){
		
		//use switch case statement to check which bet is made and pay out the money
//		switch (whichBet)
			
		return 1;		
	}



}
