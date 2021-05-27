
public class RouletteWheel extends RouletteRules{

	public RouletteWheel(int money) {
		super(money, 1);
        super.theRouletteWindow();
        super.Bet();
        super.payOutMoney();
        super.moneyRemaining += super.moneyWon * super.betMultiplier;
        money = super.moneyRemaining;
        
        super.timeTypeMM(25, "Money Remaining: " + money);
        super.closeTheWindow();
	}

}
