
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


    @Override
    public static void paintComponent(Graphics g){
        super.paintComponent(g);
        //func(g)
    }

    public static Graphics2D initG2d(Graphics g, int stroke, String color/*hexcode*/){
        Graphics2D g2d = (Graphics2D) g;
        g2d = render(g2d);
        g2d.setStroke(new BasicStroke(stroke));
        g2d.setColor(Color.parseColor(color));
        //modify for usages
        return g2d;
    }

    public static void screenDimensionInit (){

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

    public static void drawEllipse(Graphics g){
        e = ellipse(0,0,80,130);
        g2d = initG2d(g,1,"#808080");
        for (double deg = 0; deg < 360; deg += 5) {
            AffineTransform at = AffineTransform.getTranslateInstance(w/2, h/2);
            at.rotate(Math.toRadians(deg));
            g2d.draw(at.createTransformedShape(e));
        }
    }

}