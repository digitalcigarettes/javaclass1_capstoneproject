//Currently and Extra thing

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Lobby extends JFrame{
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
}