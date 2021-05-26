package lobby.blackJack;

import java.io.File;
import static java.lang.System.out;
import java.util.Random;
import java.util.*;
import java.util.stream.*;
import java.lang.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;


@SuppressWarnings("serial")
public class Run extends JFrame{

    public Run(int bankVal) {
        initUI(bankVal);
    }

    private void initUI(int bankVal) {
        setTitle("BlackJack");
        setResizable(true);
        setPreferredSize(new Dimension(550, 650));

        add(new JpanelController(bankVal));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }   
}


class JpanelController extends JPanel{
    private JButton hit = new JButton("HIT"), stand = new JButton("STAND");
    private JButton confirm = new JButton("CONFIRM");
    public Dimension screenSize;
    public static int betAmount = 0, bank = 0, w, h, xx = 360, xz = 360, card, bResult, pResult;

    public static Player player;
    public static Bot bot;

    public static boolean drawAgain = true;

    public static int[] standard52 = {1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
    public static java.util.List<Integer> deck = Arrays.stream(standard52).boxed().collect(Collectors.toList());
  

    private JLabel betLabel, bankLabel, botBankLabel, playerBankLabel;
    private JTextArea placeBet, placeMoney;
    public static ArrayList<String> cardCodes = new ArrayList<>(Arrays.asList("AC.png", "AD.png", "AH.png", "AS.png","2C.png", "2D.png", "2H.png", "2S.png", "3C.png", "3D.png", "3H.png", "3S.png", "4C.png", "4D.png", "4H.png", "4S.png", "5C.png", "5D.png", "5H.png", "5S.png", "6C.png", "6D.png", "6H.png", "6S.png", "7C.png", "7D.png", "7H.png","7S.png", "8C.png", "8D.png", "8H.png", "8S.png", "9C.png", "9D.png","9H.png", "9S.png","10C.png", "10D.png", "10H.png", "10S.png","JC.png","JD.png", "JH.png", "JS.png", "KC.png", "KD.png", "KH.png", "KS.png","QC.png", "QD.png", "QH.png", "QS.png"));
    public static ArrayList<String> cardVals = new ArrayList<>(Arrays.asList("AC.png", "AD.png", "AH.png", "AS.png","2C.png", "2D.png", "2H.png", "2S.png", "3C.png", "3D.png", "3H.png", "3S.png", "4C.png", "4D.png", "4H.png", "4S.png", "5C.png", "5D.png", "5H.png", "5S.png", "6C.png", "6D.png", "6H.png", "6S.png", "7C.png", "7D.png", "7H.png","7S.png", "8C.png", "8D.png", "8H.png", "8S.png", "9C.png", "9D.png","9H.png", "9S.png","10C.png", "10D.png", "10H.png", "10S.png","JC.png","JD.png", "JH.png", "JS.png", "KC.png", "KD.png", "KH.png", "KS.png","QC.png", "QD.png", "QH.png", "QS.png"));
    public static String mainPath;

    public JpanelController(int bankAmount){
        mainPath = loadPath();
        bank = bankAmount;
        boolean first= true;
        setLayout(null);
        setBackground(Color.decode("#35654d"));
        iNit(first);
        placeBet.setText("1000");
    }

    private String loadPath(){
        String ender = "\\lobby\\imgs\\cards\\JPEG\\";
        String curpath = System.getProperty("user.dir");
        System.out.println(curpath);
        String out = curpath+ender;
    	

       return out;
   }

    private void iNit(boolean first){


        initBet();

        Dimension bcSize = confirm.getPreferredSize();

        confirm.setBackground(Color.RED);
        confirm.setForeground(Color.YELLOW);
        confirm.setMargin(new Insets(0, 0, 0, 0));
        confirm.setBounds(225,250,bcSize.width, bcSize.height);

        add(confirm);

        betLabel = new JLabel();
        betLabel.setText("BET AMOUNT");
        betLabel.setBounds(100,150,100,33);
        add(betLabel);

        revalidate();
        repaint();

        confirm.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                try {
                    betAmount = Integer.valueOf(placeBet.getText());
                    System.out.println("BETTT AMOUNT: "+betAmount);
                } catch (NumberFormatException er) {
                    System.out.println(er);
                }

                if(bank > betAmount){
                    if(first){
                        bot = new Bot("Bot",bank);
                        player = new Player("PLAYER",bank);
                    }
                    revalidate();
                    repaint();
                    removeAll();
                    initBlackJack();
                }
            }
        });
    }

    private void initBet(){

        placeBet = new JTextArea(1, 13);
        Font courier = new Font("Courier", Font.PLAIN, 20);
        placeBet.setFont(courier);
        placeBet.setLineWrap(true);
        placeBet.setWrapStyleWord(true);

        placeBet.setBounds(200,150,150,33);

        add(placeBet);
    }
    
    public static ImageIcon loadImg(String path, int x, int y, double scale) throws IOException {
        Image newImg;

        BufferedImage bI = ImageIO.read(new File(path));
        ImageIcon imageIcon = new ImageIcon(bI);
        w = (int)(bI.getWidth());
        h = (int)(bI.getHeight());

        Image image = imageIcon.getImage(); // transform it 

        if(x > 0 && y > 0){
            newImg = image.getScaledInstance(x, y,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            w = x;
            h = y;
        }else{
            newImg = image.getScaledInstance((int)(w*scale),(int)(h*scale),  java.awt.Image.SCALE_SMOOTH);
            w = (int)(w*scale);
            h = (int)(h*scale);
        }

        imageIcon = new ImageIcon(newImg);

        return imageIcon;
    }

    private static int hitOrMiss(java.util.List<Integer> hand){        
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

        //Change manually right nw C:\Users\kids\Documents\GitHub\capstoneproject\lobby\imgs\cards\JPEG
        //String pathOfBOC = System.getProperty("user.dir")+"\\backofcard.png";

        try{
            //begin
            add(draw(false));
            player.hit(card);
            add(draw(false));
            player.hit(card);
            add(draw(true));
            bot.hit(card);
            add(draw(true));
            bot.hit(card);

            System.out.println("W:    "+w+"  h: "+h);
        }catch(IOException x){
            x.printStackTrace();
        }


        
//      sizeThread.start();
        Dimension btnsize = hit.getPreferredSize();
        //Dimension cardSize = playerCard1.getPreferredSize();

        int height = (int)(screenSize.getWidth())-btnsize.width;
        int width = (int)(screenSize.getHeight())-btnsize.height;
        width = 100;
        height = 600-(int)(btnsize.getHeight())-50;

        

        
        //playerCard1.setBounds(width+100, height+100, cardSize.width, cardSize.height);
        
        hit.setBounds(width, height , btnsize.width, btnsize.height);
        hit.setBackground(Color.RED);
        hit.setForeground(Color.YELLOW);

        stand.setMargin(new Insets(0, 0, 0, 0));
        stand.setBackground(Color.RED);
        stand.setForeground(Color.YELLOW);
        stand.setBounds(width+300, height , btnsize.width, btnsize.height);
        
        botBankLabel = new JLabel();
        botBankLabel.setText("BOT BANK:  "+bot.bank);
        botBankLabel.setForeground(Color.RED);
        botBankLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        botBankLabel.setBounds(370,5,200,33);
        add(botBankLabel);

        playerBankLabel = new JLabel();
        playerBankLabel.setText("Player BANK:  "+player.bank);
        playerBankLabel.setForeground(Color.RED);
        playerBankLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        playerBankLabel.setBounds(370,25,200,33);
        add(playerBankLabel);

        System.out.println("w "+width);
        System.out.println("h "+height);

        System.out.println("height "+screenSize.getHeight());
        System.out.println("weidth "+screenSize.getWidth());

        //setLayout(null);
        //add(playerCard1);
        add(hit);
        add(stand);
        //setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        hit.setVisible(true);
        stand.setVisible(true);
        
        revalidate();
        repaint();

        hit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    revalidate();
                    repaint();
                    add(draw(false));
                    player.hit(card);
                }catch(IOException x1){
                    x1.printStackTrace();
                }

                pResult = hitOrMiss(player.hand);

                if(pResult == 0){
                    bot.win(betAmount);
                    player.loss(betAmount);
                    System.out.println("1");
                    fin(true);
                }else if(pResult == 1){
                    player.win(betAmount);
                    bot.loss(betAmount);
                    System.out.println("2");
                    fin(false);
                }

                if(bot.drawAgain(hitOrMiss(bot.hand))){
                    try{
                        revalidate();
                        repaint();
                        add(draw(true));
                        bot.hit(card);
                    }catch(IOException x2){
                        x2.printStackTrace();
                    }

                    bResult = hitOrMiss(bot.hand);
                    if(bResult == 1){
                        bot.win(betAmount);
                        player.loss(betAmount);
                        System.out.println("3");
                        fin(true);
                    }else if(bResult == 0){
                        player.win(betAmount);
                        bot.loss(betAmount);
                        System.out.println("4");
                        fin(false);
                    }

                } 

                if(!bot.drawAgain(hitOrMiss(bot.hand)) && !drawAgain){
                    if(pResult > bResult){
                        player.win(betAmount);
                        bot.loss(betAmount);
                        System.out.println("5");
                        fin(false);
                    }else if(pResult < bResult){
                        player.loss(betAmount);
                        bot.win(betAmount);  
                        System.out.println("6");
                        fin(true); 
                    }else{
                        bot.win(betAmount);
                        player.loss(betAmount);
                        System.out.println("7");
                        fin(true);
                    }
                }

            }
        });

        stand.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                pResult = hitOrMiss(player.hand);
                drawAgain = false;
                System.out.println("bot.hand: "+bot.hand);
                
                bResult = hitOrMiss(bot.hand);
                while(bot.drawAgain(bResult)){
                    System.out.println(bot.drawAgain(bResult));
                    System.out.println("bot.hand: "+bot.hand);
                    System.out.println(hitOrMiss(bot.hand));
                    try{
                        revalidate();
                        repaint();
                        add(draw(true));
                        bot.hit(card);
                    }catch(IOException x2){
                        x2.printStackTrace();
                    }

                    bResult = hitOrMiss(bot.hand);

                } 

                bResult = hitOrMiss(bot.hand);
                System.out.println("pResult: "+pResult);
                System.out.println("bResult: "+bResult);

                if(pResult > bResult){
                    player.win(betAmount);
                    bot.loss(betAmount);
                    System.out.println("10");
                    fin(false);
                }else if(pResult < bResult){
                    player.loss(betAmount);
                    bot.win(betAmount);
                    System.out.println("11");
                    fin(true);
                }else{
                    bot.win(betAmount);
                    player.loss(betAmount);
                    System.out.println("12");
                    fin(true);
                }

            }
        });
        

    }

    public void refresh(){
        player.refresh();
        bot.refresh();
        deck = Arrays.stream(standard52).boxed().collect(Collectors.toList());
        cardVals = cardCodes;
        xx = 360;
        xz = 360;
    }



    public void fin(boolean pl){

        System.out.println("pResult: "+pResult);
        System.out.println("bResult: "+bResult);
        hit.setVisible(false);
        stand.setVisible(false);

        if(pl){
            System.out.println("INNNNN Player loss");
            JLabel playerLoss = new JLabel();
            playerLoss.setText("PLAYER LOSS");
            playerLoss.setForeground(Color.RED);
            playerLoss.setFont(new Font("Serif", Font.PLAIN, 30));

            playerLoss.setBounds(80,175,200,133);
            add(playerLoss);
        }else{
            System.out.println("INNNNN BotLoss");
            JLabel botLoss = new JLabel();
            botLoss.setText("BOT LOSS");
            botLoss.setForeground(Color.RED);
            botLoss.setFont(new Font("Serif", Font.PLAIN, 30));
            botLoss.setBounds(80,175,200,133);
            add(botLoss);
        }

        botBankLabel.setText("BOT BANK:  "+bot.bank);
        playerBankLabel.setText("Player BANK:  "+player.bank);


        System.out.println("Player Lose: "+pl);
        System.out.println("PB: "+player.bank);
        System.out.println("PH: "+player.hand);
        System.out.println("BB: "+bot.bank);
        System.out.println("Bh: "+bot.hand);


        revalidate();
        repaint();
        refresh();

        FileController whydoesjavanothaveglobalvaribles = new FileController("storage.bank");
        System.out.println("it works");
        whydoesjavanothaveglobalvaribles.write(String.valueOf(player.bank));

    }


    public static JLabel draw(boolean flipped) throws IOException{  
        JLabel label;
        Random random = new Random(); 
        int i = random.nextInt(deck.size());
        card = deck.get(i);
        deck.remove(i);

        String pth = "src//" + cardVals.get(i);
        System.out.println("CARD: "+card);
        System.out.println("BOT: "+flipped);

        cardVals.remove(i);
        if(flipped){
            pth = "src//backofcard.png";
            label = new JLabel(loadImg(pth,0,0,0.5));
            label.setBounds(xx,75,w,h);
            xx -= 20;
            System.out.println("xx: "+xx);
        }else{
            label = new JLabel(loadImg(pth,118,165,0));
            label.setBounds(xz,300,w,h);
            xz-=20;
            System.out.println("xz: "+xz);
        }

        return label;

    }


}
