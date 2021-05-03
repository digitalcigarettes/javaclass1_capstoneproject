
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 


public class BlackJack_GUI {
	public Image pCard1, pCard2, dCard1, dCard2; //EDWARD you need to set these variables to the correct card file name
	public JButton hit, stand, betConfirm;
	public int amountBet;
	public JFrame frame; 
	public JPanel dealerPanel, playerPanel, playerCardPanel;
	public JLabel dealer, player, betAmount, playerCard1, playerCard2, dealerCard1, dealerCard2;
	public boolean isBetGreater = true; //EDWARD use this boolean to test if the amount bet is within the money that the user owns
	
    //cards: {'AC.jpg', 'AD.jpg', 'AH.jpg', 'AS.jpg','2C.jpg', '2D.jpg', '2H.jpg', '2S.jpg', '3C.jpg', '3D.jpg', '3H.jpg', '3S.jpg', '4C.jpg', '4D.jpg', '4H.jpg', '4S.jpg', '5C.jpg', '5D.jpg', '5H.jpg', '5S.jpg', '6C.jpg', '6D.jpg', '6H.jpg', '6S.jpg', '7C.jpg', '7D.jpg', '7H.jpg','7S.jpg', '8C.jpg', '8D.jpg', '8H.jpg', '8S.jpg', '9C.jpg', '9D.jpg','9H.jpg', '9S.jpg','10C.jpg', '10D.jpg', '10H.jpg', '10S.jpg','JC.jpg','JD.jpg', 'JH.jpg', 'JS.jpg', 'KC.jpg', 'KD.jpg', 'KH.jpg', 'KS.jpg','QC.jpg', 'QD.jpg', 'QH.jpg', 'QS.jpg'}

    public BlackJack_GUI() {
    	

        //creating the Frame
        frame = new JFrame("BlackJack Player");
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 500);

        //creating the panels to put on the frame
        dealerPanel = new JPanel(); 
        playerPanel = new JPanel();
        playerCardPanel = new JPanel();
        
        
        //create buttons and text fields
        hit = new JButton("Hit");
        stand = new JButton("Stand");
        betConfirm = new JButton("Confirm Bet");
        hit.addActionListener(new ButtonListener());
        stand.addActionListener(new ButtonListener());

        
        JTextField betTextField = new JTextField("Enter Bet: ", 10);
        
        dealer = new JLabel("Dealer");
        player = new JLabel("Player");
        betAmount = new JLabel("Amount Bet: 0");
        betConfirm.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (isBetGreater == true) {
    		String input = betTextField.getText();
    		input = input.replaceAll("[^\\d.]", ""); // remove all letters from input
    		amountBet = Integer.parseInt(input); // convert string to number
    		
    		betAmount.setText("Amount Bet: " + input);
        		}
        	}
        });
        
 
     
        
        
        
        //EDWARD change the image to be set to whatever card is drawn for all four cards
        // THE CARD FILES ARE NOT COMPATIBLE, THEY HAVE TO BE ALL CONVERTED TO PNG FORMAT, JAVA.AWT DOESNT SUPPORT JPG
        playerCard1 = new JLabel("");        
        pCard1 = new ImageIcon(this.getClass().getResource("backofcard.png")).getImage();
        pCard1 = pCard1.getScaledInstance(150, 200, Image.SCALE_DEFAULT);
        playerCard1.setIcon(new ImageIcon(pCard1));        
        
        playerCard2 = new JLabel("");
        pCard2 = new ImageIcon(this.getClass().getResource("backofcard.png")).getImage();
        pCard2 = pCard2.getScaledInstance(150, 200, Image.SCALE_DEFAULT);
        playerCard2.setIcon(new ImageIcon(pCard2));
        
        dealerCard1 = new JLabel("");
        dCard1 = new ImageIcon(this.getClass().getResource("backofcard.png")).getImage();
        dCard1 = dCard1.getScaledInstance(150, 200, Image.SCALE_DEFAULT);
        dealerCard1.setIcon(new ImageIcon(dCard1));
        
        dealerCard2 = new JLabel("");
        dCard2 = new ImageIcon(this.getClass().getResource("backofcard.png")).getImage();
        dCard2 = dCard2.getScaledInstance(150, 200, Image.SCALE_DEFAULT);
        dealerCard2.setIcon(new ImageIcon(dCard2));

        
        playerCardPanel.add(player);
        playerCardPanel.add(playerCard1);
        playerCardPanel.add(playerCard2);
       
       	playerPanel.add(hit);
        playerPanel.add(stand);
        playerPanel.add(betTextField);
        playerPanel.add(betConfirm);       
        playerPanel.add(betAmount);  
        
        dealerPanel.add(dealer);
        dealerPanel.add(dealerCard1);
        dealerPanel.add(dealerCard2);
        

        //adding panels and buttons and stuff to the frame
        frame.getContentPane().add(BorderLayout.NORTH, dealerPanel);
        frame.getContentPane().add(BorderLayout.CENTER, playerCardPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, playerPanel);

        frame.setVisible(true);
        
    
        
    }
    
    private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == hit) {
		// stand()
				//get the new card file and add it onto the playerCardPanel and redraw the playerCardPanel
			} else if (e.getSource() == stand){
				//hit()
			}
			
			
		}
    	
    }
    
    public static void main(String args[]) {
    	new BlackJack_GUI();
    	
    }
    

    
}
