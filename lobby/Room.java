//Fancy sht and credits
import javax.swing.Timer;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


@SuppressWarnings("serial")
public class Room extends JFrame {


    public Room() {

        initUI();
    }

    private void initUI() {

        add(new Board(true));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLUE);
        setUndecorated(true);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}