package blackJack.BlackJack_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlackJack_GUI {
	private JButton hit, stand;
	private JTextArea amountBet;
	private JFrame frame;
	private JPanel panel, dealerLabel, playerLabel;
	private JLabel dealer, player;
    //cards: {'AC.jpg', 'AD.jpg', 'AH.jpg', 'AS.jpg','2C.jpg', '2D.jpg', '2H.jpg', '2S.jpg', '3C.jpg', '3D.jpg', '3H.jpg', '3S.jpg', '4C.jpg', '4D.jpg', '4H.jpg', '4S.jpg', '5C.jpg', '5D.jpg', '5H.jpg', '5S.jpg', '6C.jpg', '6D.jpg', '6H.jpg', '6S.jpg', '7C.jpg', '7D.jpg', '7H.jpg','7S.jpg', '8C.jpg', '8D.jpg', '8H.jpg', '8S.jpg', '9C.jpg', '9D.jpg','9H.jpg', '9S.jpg','10C.jpg', '10D.jpg', '10H.jpg', '10S.jpg','JC.jpg','JD.jpg', 'JH.jpg', 'JS.jpg', 'KC.jpg', 'KD.jpg', 'KH.jpg', 'KS.jpg','QC.jpg', 'QD.jpg', 'QH.jpg', 'QS.jpg'}

    public BlackJack_GUI() {
    	

        //Creating the Frame
        frame = new JFrame("BlackJack Player");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        //Creating the panel at bottom and adding components
        panel = new JPanel(); 
        dealerLabel = new JPanel(); 
        playerLabel = new JPanel();
 
        hit = new JButton("Hit");
        stand = new JButton("Stand");
 //       amountBet = new JTextArea("Delete this and enter the bet:");
        hit.addActionListener(new ButtonListener());
        stand.addActionListener(new ButtonListener());
        
        dealer = new JLabel("Dealer's Cards");
        player = new JLabel("Player's Cards");
        
  //      panel.add(amountBet);
        panel.add(hit);
        panel.add(stand);
        
        dealerLabel.add(dealer);
        playerLabel.add(player);
        
        

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, dealerLabel);
        frame.getContentPane().add(BorderLayout.NORTH, playerLabel);
        frame.setVisible(true);
        
    
        
    }
    
    private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == hit) {
		// stand()
			} else if (e.getSource() == stand){
				//hit()
			}
			
			
		}
    	
    }
    
    public static void main(String args[]) {
    	new BlackJack_GUI();
    	
    }
    

    
}
