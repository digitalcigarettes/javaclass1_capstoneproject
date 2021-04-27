//Currently and Extra thing
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Lobby extends JFrame{
    public void startUp(){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                StartUp sp = new StartUp();
                sp.setVisible(true);

                //DUnno why I did this but it works
                ActionListener actionListener = new ActionListener(){
                    public void actionPerformed(ActionEvent ae){
                        sp.dispose();
                    }
                };


                Timer timer = new Timer(3000, actionListener);
                timer.start(); 
                timer.setRepeats(false);
            };
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
        try {
            Thread.sleep(4000);
         } catch (Exception e) {
            System.out.println(e);
            System.exit(-1);
         }
        System.out.println("test");
    }
}