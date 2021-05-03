import java.lang.*;
import java.awt.Component;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 


@SuppressWarnings("serial")
public class Gui2 extends JFrame{

    public Gui2() {

        initUI();
    }

    private void initUI() {
        setTitle("BlackJack");
        setResizable(true);
        setPreferredSize(new Dimension(550, 650));

        add(new JpanelController());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }   

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Gui2 gui = new Gui2();
            gui.setVisible(true);
        });
    }
}

class JpanelController extends JPanel{
    private JButton hit = new JButton("HIT"), stand = new JButton("STAND");
    private JButton moneyConfirm = new JButton("CONFIRM MONEY"), betConfirm = new JButton("CONFIRM BET");
    public Dimension screenSize;
    public int betAmount = 0, bank = 0;
    private JTextArea placeBet, placeMoney;

    public JpanelController(){
        setLayout(null);
        setBackground(Color.decode("#35654d"));
        initialInit();
        placeBet.setText("0");
        placeMoney.setText("0");
    }

    private void initialInit(){
        initBet();

        Dimension bcSize = moneyConfirm.getPreferredSize();

        moneyConfirm.setBackground(Color.RED);
        moneyConfirm.setForeground(Color.YELLOW);
        moneyConfirm.setMargin(new Insets(0, 0, 0, 0));
        moneyConfirm.setBounds(100+150+10,200+5,bcSize.width, bcSize.height);

        add(moneyConfirm);

        placeMoney = new JTextArea(1, 13);
        Font courier = new Font("Courier", Font.PLAIN, 20);
        placeMoney.setFont(courier);
        placeMoney.setLineWrap(true);
        placeMoney.setWrapStyleWord(true);

        placeMoney.setBounds(100,200,150,33);

        add(placeMoney);

        moneyConfirm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                bank = Integer.parseInt(placeMoney.getText());
                System.out.println(bank);
                if(betAmount!=0){
                    revalidate();
                    repaint();
                    removeAll();
                    initBlackJack();
                }
            }
        });
    }

    private void initBet(){
        Dimension bcSize = betConfirm.getPreferredSize();

        betConfirm.setBackground(Color.RED);
        betConfirm.setForeground(Color.YELLOW);
        betConfirm.setMargin(new Insets(0, 0, 0, 0));
        betConfirm.setBounds(100+150+10,150+5,bcSize.width, bcSize.height);

        add(betConfirm);

        placeBet = new JTextArea(1, 13);
        Font courier = new Font("Courier", Font.PLAIN, 20);
        placeBet.setFont(courier);
        placeBet.setLineWrap(true);
        placeBet.setWrapStyleWord(true);

        placeBet.setBounds(100,150,150,33);

        add(placeBet);

        betConfirm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                betAmount = Integer.parseInt(placeBet.getText());
                System.out.println(betAmount);     
                if(bank!=0){
                    revalidate();
                    repaint();
                    removeAll();
                    initBlackJack();      
                }  
            }
        });

    }

    public void initBlackJack(){

        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        Thread sizeThread = new Thread(){

            public void run(){
                while(true){
                    screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    System.out.println(screenSize.getHeight());
                    System.out.println(screenSize.getWidth());
                    try{
                        Thread.sleep(100);
                    } catch (Exception e) {
                        System.exit(-1);
                    }
                }
            }
        };


        //sizeThread.start();
        Dimension btnsize = hit.getPreferredSize();

        int height = (int)(screenSize.getWidth())-btnsize.width;
        int width = (int)(screenSize.getHeight())-btnsize.height;
        width = 100;
        height = 600-(int)(btnsize.getHeight())-50;


        hit.setBounds(width, height , btnsize.width, btnsize.height);
        hit.setBackground(Color.RED);
        hit.setForeground(Color.YELLOW);

        stand.setMargin(new Insets(0, 0, 0, 0));
        stand.setBackground(Color.RED);
        stand.setForeground(Color.YELLOW);
        stand.setBounds(width+300, height , btnsize.width, btnsize.height);

        System.out.println("w "+width);
        System.out.println("h "+height);

        System.out.println("height "+screenSize.getHeight());
        System.out.println("weidth "+screenSize.getWidth());

        setLayout(null);
        add(hit);
        add(stand);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }




}