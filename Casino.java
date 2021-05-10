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
        String bank = scans.nextLine();
        //NOT COMPLETED YET
    }
}