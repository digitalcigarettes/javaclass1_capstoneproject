//A ton of packages
import java.io.File;
import java.io.FileInputStream;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Board extends JPanel{
    double w, h;
    boolean img,bg;
    public static int imgW,imgH;
    public Image image; 
    private static final long serialVersionUID = 13092; //Fk serializable things @SuppressWarnings("serial")
    private BufferedImage initialImage;

    public Board(boolean img){
        this.img = img;
        this.bg = true;
        init(img);
    }


    private void init(boolean img){
        if(img){
            try{
                loadImage("C:\\Users\\____\\Documents\\GitHub\\capstoneproject\\lobby\\blackJack\\startupScreen.png"); //for some reason the image has problems if i aquire it from the imgs folder
            }catch(IOException e){
                e.printStackTrace();
                System.exit(-1);
            }

            imgW = image.getWidth(this);
            imgH = image.getHeight(this);

            setPreferredSize(new Dimension(imgW,imgH));
        }
    }

    public void loadImage(String path) throws IOException {
        File imgPath = new File(path);
        //URL url = new URL(path);
        initialImage = ImageIO.read(imgPath);
        image = initialImage.getScaledInstance((int)(initialImage.getWidth()/3.5), (int)(initialImage.getHeight()/3.5), Image.SCALE_SMOOTH);
        
    }



    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        if(img){
            if(bg){
                BufferedImage background = new BufferedImage(imgW, imgH, BufferedImage.TYPE_INT_RGB);
                //g = background.createGraphics();
                g.setColor(Color.BLACK);
                g.fillRect(0,0,background.getWidth(),background.getHeight());
                
                g.drawImage(image, 0, 0, null);
                g.dispose();
            }

        }else{
            drawEllipse(g); //testing purposes
        }
    }





    public static Graphics2D initG2d(Graphics g, int stroke /*String color*/){
        Graphics2D g2d = (Graphics2D) g;
        g2d = render(g2d);
        g2d.setStroke(new BasicStroke(stroke));
        g2d.setColor(Color.BLACK);
        //modify for usages
        return g2d;
    }

    public void screenDimensionInit (){

        Dimension size = getSize();
        this.w = size.getWidth();
        this.h = size.getHeight();

    }

    public static Graphics2D render(Graphics2D g){
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHints(rh);

        return g;
    }

    public static Ellipse2D ellipse(double h, double w, double x, double y){Ellipse2D e = new Ellipse2D.Double(h,w,x,y); return e;}

    //Example Shape
    public void drawEllipse/*Donut ellipse*/(Graphics g){
        Ellipse2D e = ellipse(0,0,80,130);
        Graphics2D g2d = initG2d(g,1);

        this.screenDimensionInit();

        for (double deg = 0; deg < 360; deg += 5) {
            AffineTransform at = AffineTransform.getTranslateInstance(this.w/2, this.h/2);
            at.rotate(Math.toRadians(deg));
            g2d.draw(at.createTransformedShape(e));
        }
    }

}
