// java Program to create a simple JInternalFrame
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class test extends JFrame {
 
  public static void main(String args[]) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

      JInternalFrame internalFrame = new JInternalFrame("Test Internal Frame", true, false, true, true);
      internalFrame.setSize(200, 150);
      internalFrame.setVisible(true);

      frame.setSize(800, 600);
      frame.setVisible(true);
    });
  }
}