import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.text.*;

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  public void drawSun() {
    Graphics picG = this.getGraphics();
    
    picG.setColor(Color.YELLOW);
    picG.drawOval(130, 60, 50, 50);
    picG.fillOval(130, 60, 50, 50);
    
    // draw a mouth
    picG.setColor(Color.BLACK);
    picG.drawOval(142, 87, 25, 10);
    
    picG.setColor(Color.YELLOW);
    picG.fillOval(135, 80, 39, 12);

    // draw eyes and a nose
    picG.setColor(Color.BLACK);
    picG.fillOval(142, 70, 8, 4);
    picG.fillOval(160, 70, 8, 4);
    picG.fillOval(153, 78, 5, 10);
    
  }

  // have a nice day
  public void haveANiceDay() {
    Graphics picG = this.getGraphics();
    picG.setColor(Color.YELLOW);

    Font labelFont = new Font("Verdana", Font.PLAIN, 20);
    picG.setFont(labelFont);
    picG.drawString("Have a nice day!", 180, 115);
  }
  
  public void drawX(Color xColor) {
    Graphics g = this.getGraphics();
    Graphics2D g2 = (Graphics2D) g;
    g2.setColor(xColor);
    g2.setStroke(new BasicStroke(10));
    
    // need to know some stuff about the picture
    int w = this.getWidth();
    int h = this.getHeight();
    
    // draw upper left to lower right line
    g2.drawLine(0, 0, w-1, h-1);
    
    // draw lower left to upper right line
    g2.drawLine(0, h-1, w-1, 0);
  }
  
  public void drawGunSight(int x, int y, int size) {
    //Graphics g = this.getGraphics();
    //Graphics2D g2 = (Graphics2D) g;
    Graphics2D g2 = (Graphics2D) this.getGraphics();
    g2.setColor(Color.RED);
    g2.setStroke(new BasicStroke(3));
    
    // the position we're given is the center, so we need to figure
    //  out the top left corner of the circle
    int topLeftX = x - (size / 2);
    int topLeftY = y - (size / 2);
    if (topLeftX < 0) { topLeftX = 0; }
    if (topLeftY < 0) { topLeftY = 0; }
    
    // draw the circle
    g2.drawOval(topLeftX, topLeftY, size, size);
    
    // now, draw the crosshairs
    g2.drawLine(x, y - (size / 2), x, y + (size / 2));
    g2.drawLine(x - (size / 2), y, x + (size / 2), y);
    
  }
  
  public void drawFace() {
    Graphics picG = this.getGraphics();
    
    // basic face
    picG.setColor(Color.BLACK);
    picG.drawOval(60, 60, 180, 180);
    picG.setColor(Color.LIGHT_GRAY);
    picG.fillOval(60, 60, 180, 180);

    // eyes
    picG.setColor(Color.BLACK);
    picG.drawOval(100, 100, 30, 30);
    picG.drawOval(170, 100, 30, 30);
    picG.setColor(Color.WHITE);
    picG.fillOval(100, 100, 30, 30);
    picG.fillOval(170, 100, 30, 30);
    picG.setColor(Color.BLUE);
    picG.fillOval(103, 107, 24, 16);
    picG.fillOval(173, 107, 24, 16);
    picG.setColor(Color.BLACK);
    picG.fillOval(110, 110, 10, 10);
    picG.fillOval(180, 110, 10, 10);

    // eyebrows
    picG.setColor(Color.BLACK);
    picG.drawArc(90, 90, 50, 50, 45, 90);
    picG.drawArc(160, 90, 50, 50, 45, 90);
    
    // nose
    picG.setColor(Color.BLACK);
    picG.fillArc(125, 100, 50, 70, 270, 45);
    
    // mouth
    picG.setColor(Color.RED);
    picG.drawOval(115, 180, 80, 25);
    
    // tie
    picG.setColor(Color.MAGENTA);
    int[] xArray = { 130, 170, 190, 150, 110, 130 };
    int[] yArray = { 237, 237, 345, 380, 345, 237 };
    picG.fillPolygon(xArray, yArray, 6);
    picG.setColor(Color.BLACK);
    picG.drawPolygon(xArray, yArray, 6);

  }
  
  public void copy2D(Picture source, int x, int y)
  {
    Graphics2D g2 = (Graphics2D) this.getGraphics();
    
    // copy the image
    g2.drawImage(source.getImage(),x,y,null);
  }

  public void makeWhiteTransparent() {
    Pixel[] pixelArray = this.getPixels();
    
    // loop through all the pixels
    for (Pixel pixelObj : pixelArray) 
    {
      if (pixelObj.getRed() > 235 && pixelObj.getGreen() > 235 && pixelObj.getBlue() > 235) {
        pixelObj.setRed(0);
        pixelObj.setAlpha(255);
      }
    }
  }   
  
    /**
   * This is the method that is called when you run java Picture.
   * It can be used to test methods in this class
   */
  public static void main(String[] args)
  {
    // set default media path
    FileChooser.setMediaPath("C:\\users\\joconnor\\documents\\AP Comp Sci\\intro-prog-java\\mediasources\\");
    
    // for picking a file at run time
    //Picture p = new Picture(FileChooser.pickAFile());
    
    // hardcoding a specific file
    Picture p = new Picture(FileChooser.getMediaPath("beach.jpg"));
    Picture t = new Picture(FileChooser.getMediaPath("turtle.jpg"));
                            
    // for drawing picture
    //p.drawX(Color.RED);
    //p.drawGunSight(532,189,50);
   
    t.makeWhiteTransparent();
    p.copy2D(t,194,304);
    p.explore();
    
  }

} // this } is the end of class Picture, put all new methods before this
 