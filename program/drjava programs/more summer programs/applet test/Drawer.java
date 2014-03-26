import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.Random;
public class Drawer extends JApplet {
//    BufferedImage img = ImageIO.read(new File("portal.png"));
  public static void main(String s[]) {
        BufferedImage img = ImageIO.read(new File("portal.png"));
  }
  public void paint(Graphics g) {
    
    g.drawImage(img,
                0, 0, 50, 50,
                0, 0, 50, 50,
                null);
  }
}
