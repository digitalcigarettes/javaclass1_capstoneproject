package lobby.blackJack;

import java.util.*;
import java.util.stream.*;
import java.util.Random;

public class Player {
	String username;
	int draws, bank;
	public List<Integer> hand = new ArrayList<Integer>();


    public Player(String username, int bank){
        this.username = username;
        this.draws = 0;
        this.bank = bank;
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