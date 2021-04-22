
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