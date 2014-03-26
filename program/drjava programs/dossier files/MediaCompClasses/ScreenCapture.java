import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

class ScreenCapture {
  public static void main(String args[]) throws
           AWTException, IOException {
     // capture the whole screen
     BufferedImage screencapture = new Robot().createScreenCapture(
           new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()) );

     // Save as JPEG
     File file = new File("screencapture.jpg");
     ImageIO.write(screencapture, "jpg", file);

  }
}
