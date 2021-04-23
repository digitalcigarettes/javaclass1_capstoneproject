//Currently and Extra thing
import javax.swing.Timer;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Lobby extends JFrame{
    public void startUp(){
        EventQueue.invokeLater(() -> {
            StartUp sp = new StartUp();
            sp.setVisible(true);
            Timer timer = new javax.swing.Timer(3000, event -> {sp.setVisible(false);});
            timer.setRepeats(false);
            timer.start(); 
        });
    }
    /*
    public Lobby(){
        init();
    }
    private void init(){
        add(new Board());
        setSize(250, 200);
        setTitle("Lobby");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
    }

    public static void main(String[] args){
        EventQueue.invokeLater(()->{
            Lobby ly = new Lobby();
            ly.setVisible(true);
        });
    }
    */
    public static void main(String[] args) {
        Lobby ly = new Lobby();
        ly.startUp();
    }
}