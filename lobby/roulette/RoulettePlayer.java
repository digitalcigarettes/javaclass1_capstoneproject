
public class RoulettePlayer {

	public static void main(String[] args) {
		
		RouletteWheel theEpicWheel = new RouletteWheel(10000); //tester class, will not be necessary in the future
		theEpicWheel.theRouletteWindow();
		theEpicWheel.Bet();
		theEpicWheel.payOutMoney();
		theEpicWheel.moneyRemaining += theEpicWheel.moneyWon;
		System.out.println(theEpicWheel.moneyRemaining);
		
	}

}
