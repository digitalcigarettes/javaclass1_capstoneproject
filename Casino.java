import java.util.*;  
import lobby.rouletteWheel.*;
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
        timeTypeMM(37,"How much money would you like to start with: ");
        out.println();
        String bank = scans.nextLine();
        int money = Integer.parseInt(bank.replaceAll("[^0-9]", ""));
        
        boolean quitCasino = false;
        
        do {
            out.println();
            timeTypeMM(37, "What would you like to do?");
            out.println();
            timeTypeMM(20, "1. Play BlackJack");
            out.println();
            timeTypeMM(20, "2. Play Roulette");
            out.println();
            timeTypeMM(20, "3. Play Yahtzee");
            out.println();
            timeTypeMM(20, "4. Quit the Casino");
            int whichGame = scans.nextInt();
            switch (whichGame) {
                case 1:
                	break;
                case 2:
            		RouletteWheel theEpicWheel = new RouletteWheel(money);
            		theEpicWheel.Bet();
            		theEpicWheel.payOutMoney();
            		theEpicWheel.moneyRemaining += theEpicWheel.moneyWon;
            		money = theEpicWheel.moneyRemaining;
            		
            		timeTypeMM(25, "Money Remaining: " + money);
            		
                	break;
                case 3:
                	break;
                case 4: 
                	quitCasino = true;
                	System.out.println("Bye");
                	break;
            }        
        
        } while (quitCasino == false);
        
        
        //NOT COMPLETED YET
        
    }
}