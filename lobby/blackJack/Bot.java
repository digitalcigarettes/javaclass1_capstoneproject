import java.util.*;
import java.util.stream.*;
import java.util.Random;

public class Bot {
    String username;
    int draws, bank;
    public List<Integer> hand = new ArrayList<Integer>();


    public Bot(String username, int bank){
        this.username = username;
        this.draws = 0;
        this.bank = bank;
    }

    public boolean drawAgain(int sum){
        if(sum<17){
            return true;
        }else if(sum == 0){
            return false;
        }
        return false;
    }

    public void hit(int card){
        this.hand.add(card);
        this.draws++;
    }

    public void win(int money){
        this.bank+=money;
    }

    public void loss(int money){
        this.bank -= money;
    }
    public void refresh(){
        this.hand.removeAll(this.hand);
    }


}
