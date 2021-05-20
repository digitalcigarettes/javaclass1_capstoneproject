import java.util.*;  
import java.util.concurrent.TimeUnit;
import static java.lang.System.out;

public class Casino {

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

    public static void main(String[] args) {
        Scanner scans = new Scanner(System.in);    
        int money = 0;
        
        timeTypeMM(37,"Welcome to the:");
        timeTypeMM(1,"      ___           ___           ___                       ___           ___        ");
        timeTypeMM(1,"     /\\  \\         /\\  \\         /\\  \\          ___        /\\__\\         /\\  \\       ");
        timeTypeMM(1,"    /::\\  \\       /::\\  \\       /::\\  \\        /\\  \\      /::|  |       /::\\  \\      ");
        timeTypeMM(1,"   /:/\\:\\  \\     /:/\\:\\  \\     /:/\\ \\  \\       \\:\\  \\    /:|:|  |      /:/\\:\\  \\     ");
        timeTypeMM(1,"  /:/  \\:\\  \\   /::\\~\\:\\  \\   _\\:\\~\\ \\  \\      /::\\__\\  /:/|:|  |__   /:/  \\:\\  \\    ");
        timeTypeMM(1," /:/__/ \\:\\__\\ /:/\\:\\ \\:\\__\\ /\\ \\:\\ \\ \\__\\  __/:/\\/__/ /:/ |:| /\\__\\ /:/__/ \\:\\__\\   ");
        timeTypeMM(1," \\:\\  \\  \\/__/ \\/__\\:\\/:/  / \\:\\ \\:\\ \\/__/ /\\/:/  /    \\/__|:|/:/  / \\:\\  \\ /:/  /   ");
        timeTypeMM(1,"  \\:\\  \\            \\::/  /   \\:\\ \\:\\__\\   \\::/__/         |:/:/  /   \\:\\  /:/  /    ");
        timeTypeMM(1,"   \\:\\  \\           /:/  /     \\:\\/:/  /    \\:\\__\\         |::/  /     \\:\\/:/  /     ");
        timeTypeMM(1,"    \\:\\__\\         /:/  /       \\::/  /      \\/__/         /:/  /       \\::/  /      ");
        timeTypeMM(1,"     \\/__/         \\/__/         \\/__/                     \\/__/         \\/__/       ");
        out.println();
        timeTypeMM(1,"_____________________________________________________________________________________");
        timeTypeMM(37,"Please answer some questions to earn money: ");
        Question question1 = new Question("What is the Capital of the California", "Sacramento");
        if (question1.askQuestion() == true) money += 1000;
        
        Question question2 = new Question("What is 2 to the power of 3/2", "3");
        if (question2.askQuestion() == true) money += 1000;
        
        Question question3 = new Question("What is the height of the Empire State Building to the tip in feet?", "1454");
        if (question3.askQuestion() == true) money += 1000;
        
        Question question4 = new Question("Which Capstone Project team coded this casino? (Answer with team number only)", "7");
        if (question4.askQuestion() == true) money += 1000;
       
        Question question5 = new Question("Do you admit that spending your time playing this imaginary casino and budget betting simulator might not be the best use of your time? Y/N", "Y");
        if (question5.askQuestion() == true) money += 1000;  
       
        Question question6 = new Question("What is the full name of our java teacher?", "Ed Taylor");
        if (question6.askQuestion() == true) money += 1000;
        
        Question question7 = new Question("log(1000)", "3");
        if (question7.askQuestion() == true) money += 1000;
        
        Question question8 = new Question("(5/x) - (1/3) = (1/x). Find x ", "12");
        if (question8.askQuestion() == true) money += 1000;
        
        Question question9 = new Question("Should you wear a mask? Y/N", "Y");
        if (question9.askQuestion() == true) money += 1000;
        
        Question question10 = new Question("Is our team the best? Y/N", "Y");
        if (question10.askQuestion() == true) money += 1000;

        
        boolean quitCasino = false;
        
        do {
            out.println();
            timeTypeMM(37, "What would you like to do?");
            out.println();
            out.println("---------------------");
            timeTypeMM(20, "1. Play BlackJack");
            out.println();
            out.println("---------------------");
            timeTypeMM(20, "2. Play Roulette");
            out.println();
            out.println("---------------------");
            timeTypeMM(20, "3. Play Yahtzee");
            out.println();
            out.println("---------------------");
            timeTypeMM(20, "4. Quit the Casino");
            out.println("");
            out.println(">>: ");
        int whichGame = scans.nextInt();
        switch (whichGame) {
        case 1:
        	break;
        case 2:
    		RouletteWheel theEpicWheel = new RouletteWheel(money);
    		theEpicWheel.theRouletteWindow();
    		theEpicWheel.Bet();
    		theEpicWheel.payOutMoney();
    		theEpicWheel.moneyRemaining += theEpicWheel.moneyWon;
    		money = theEpicWheel.moneyRemaining;
    		
    		timeTypeMM(25, "Money Remaining: " + money);
    		theEpicWheel.closeTheWindow();
    		
        	break;
        case 3:
    		Yahtzee theEpicYahtzee = new Yahtzee(money);
    		money = theEpicYahtzee.moneyRemaining;  		
    		timeTypeMM(25, "Money Remaining: " + money);
    		System.exit(-1);
        case 4: 
        	quitCasino = true;
        	System.out.println("Bye");
        	System.exit(-1);
        }        
        
        } while (quitCasino == false);
        
        
    }
}