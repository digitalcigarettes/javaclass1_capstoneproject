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
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;



public class Board extends JPanel{
    double w;
    double h;
    boolean img;
    public Image image;

    public Board(boolean img){
        this.img = img;
        init(img);
    }


    private void init(boolean img){
        if(img){
            loadImage("path");

            int w = image.getWidth(this);
            int h = image.getHeight(this);
            setPreferredSize(new Dimension(w,h));
        }
    }

    private void loadImage(String path){
        ImageIcon ii = new ImageIcon(path);
        image = ii.getImage();
    }


    @Override
    public void paintComponent(Graphics g){
        if(img){
            g.drawImage(image,0,0,null);
        }else{
            super.paintComponent(g);
            drawEllipse(g); //testing purposes
        }
    }



    public static Graphics2D initG2d(Graphics g, int stroke /*String color*/){
        Graphics2D g2d = (Graphics2D) g;
        g2d = render(g2d);
        g2d.setStroke(new BasicStroke(stroke));
        g2d.setColor(Color.gray);
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