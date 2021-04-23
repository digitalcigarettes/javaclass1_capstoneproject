package BlackJack.GUI
//blackJack.java

/*
CURRENTLY A FULL SIMULATION OF A PROGRAM WITH A STUPID PLAYER
BOT IS BIG BRAIN SO IT SHOULD ALWAYS WIN
COMPILE:
javac blackJack.java
java blackjack
*/

import static java.lang.System.out;
import java.util.Random;
import java.util.*;
import java.util.stream.*;


public class BlackJack {

	public static int[] standard52 = {1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
    public static List<Integer> deck = Arrays.stream(standard52).boxed().collect(Collectors.toList());
    public static int pResult, bResult; //DUnno why i did this should change later
        

    public BlackJack(){

    }



    public static int hitOrMiss(List<Integer> hand){        
        int frequency = Collections.frequency(hand, 1);

        Collections.sort(hand);
        Collections.reverse(hand);

        int sum = 0;
        for (int i=0;i<hand.size();i++) {
            if(hand.get(i).equals(1)){
                if((sum+11+1*(frequency-1))<=21){
                    sum = sum+11+1*(frequency-1);
                    break;
                }
                sum += 1*frequency;
                break;
            }
            sum += (int)(hand.get(i)); //dunno why error here so need to be int
        }

        if(sum>21){
            return 0;
        }else if(sum<21){
            return sum;
        }else{
            return 1;
        }

    }

    public static int draw(){
        Random random = new Random();
        int i = random.nextInt(deck.size());
        int card = deck.get(i);
        deck.remove(i);
        return card;
    }


    public static void game(){
        int bet = 10;

        Player player = new Player("NAME",500);
        Bot bot = new Bot("Joe",500);

        while(bot.bank>0 && player.bank>0){

            player.hit(draw());
            player.hit(draw());
            bot.hit(draw());
            bot.hit(draw());
            pResult = hitOrMiss(player.hand);
            bResult = hitOrMiss(bot.hand);

            while(true){
                boolean drawAgain = false; //Suppose to be given from gui by the hit button

                if(drawAgain){
                    player.hit(draw());
                    pResult = hitOrMiss(player.hand);
                    if(pResult == 0){
                        bot.win(bet);
                        player.loss(bet);
                        break;
                    }else if(pResult == 1){
                        player.win(bet);
                        bot.loss(bet);
                        break;
                    }
                }

                if(bot.drawAgain(hitOrMiss(bot.hand))){
                    bot.hit(draw());
                    bResult = hitOrMiss(bot.hand);
                    if(bResult == 1){
                        bot.win(bet);
                        player.loss(bet);
                        break;
                    }else if(bResult == 0){
                        player.win(bet);
                        bot.loss(bet);
                        break;
                    }

                }

                if(!bot.drawAgain(hitOrMiss(bot.hand)) && !drawAgain){
                    if(pResult > bResult){
                        player.win(bet);
                        bot.loss(bet);
                        out.println("pwin"); //debug purposes
                        break;
                    }else if(pResult < bResult){
                        player.loss(bet);
                        bot.win(bet);  
                        out.println("bwin"); //debug purposes
                        break;          
                    }else{
                        bot.win(bet);
                        player.loss(bet);
                        out.println("np"); //debug purposes
                        break;
                    }
                }
            }
            out.println(player.hand); //debug purposes
            out.println(bot.hand); //debug purposes
            out.println(player.bank); //debug purposes
            out.println(bot.bank); //debug purposes
            player.refresh();
            bot.refresh();
            deck = Arrays.stream(standard52).boxed().collect(Collectors.toList());
        }
    }

    public static void main(String args[]){  
        game(); //begin
    }

}



