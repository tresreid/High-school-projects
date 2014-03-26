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
  
  public void keepOnlyBlue()
  {
    Pixel[] pixelArray = this.getPixels();
    
    // loop through all the pixels
    for (Pixel pixelObj : pixelArray) 
    {
      pixelObj.setRed(0);
      pixelObj.setGreen(0);
    }
  }   
  
  public void keepOnlyRed()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixelObj = null;
    int i = 0;
    
    // loop through all the pixels
    //for (Pixel pixelObj : pixelArray)
    while (i < pixelArray.length)
    {
      pixelObj = pixelArray[i];
      pixelObj.setBlue(0);
      pixelObj.setGreen(0);
      i++;
    }
  }   
  
  public void keepOnlyGreen()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixelObj = null;
    
    // loop through all the pixels
    //for (Pixel pixelObj : pixelArray)
    //while (i < pixelArray.length)
    for (int i = 0; i <pixelArray.length; i++)
    {
      pixelObj = pixelArray[i];
      pixelObj.setBlue(0);
      pixelObj.setRed(0);
    }
  }   

  public void scaleUp(Picture sourcePicture)
  {
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    for (double sourceX = 0, targetX = 0;
         sourceX < sourcePicture.getWidth();
         sourceX = sourceX + 0.5, targetX++)
    {
      for (double sourceY = 0, targetY = 0;
           sourceY < sourcePicture.getHeight();
           sourceY = sourceY + 0.5, targetY++)
      {
        sourcePixel = sourcePicture.getPixel((int) sourceX, (int) sourceY);
        targetPixel = this.getPixel((int) targetX, (int) targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }
  }

  public void highlightLightAndDark(double amount, 
                                    Color replacementColor) {
    Pixel pixel = null;
    
    // loop through all the pixels in the x direction
    for (int x = 0; x < getWidth(); x++) {
      
      // loop through all the pixels in the y direction
      for (int y = 0; y < getHeight(); y++) {
        
        // get the current pixel
        pixel = getPixel(x,y);
        
        // if the distance from white or black is less than the 
        // passed amount use the replace color instead
        if (pixel.colorDistance(Color.white) < amount ||
            pixel.colorDistance(Color.black) < amount) {
          pixel.setColor(replacementColor);
        }
      }
    }
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
    Graphics picG = this.getGraphics();
    picG.setColor(xColor);
    
    // need to know some stuff about the picture
    int w = this.getWidth();
    int h = this.getHeight();
    
    // draw upper left to lower right line
    picG.drawLine(0, 0, w-1, h-1);
    
    // draw lower left to upper right line
    picG.drawLine(0, h-1, w-1, 0);
  }
  
  public void drawGunSight(int x, int y, int size) {
    Graphics picG = this.getGraphics();
    picG.setColor(Color.RED);
    
    // the position we're given is the center, so we need to figure
    //  out the top left corner of the circle
    int topLeftX = x - (size / 2);
    int topLeftY = y - (size / 2);
    if (topLeftX < 0) { topLeftX = 0; }
    if (topLeftY < 0) { topLeftY = 0; }
    
    // draw the circle
    picG.drawOval(topLeftX, topLeftY, size, size);
    
    // now, draw the crosshairs
    picG.drawLine(x, y - (size / 2), x, y + (size / 2));
    picG.drawLine(x - (size / 2), y, x + (size / 2), y);
    
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
                            
    // for scaling stuff
    //Picture pUp = new Picture(p.getWidth() * 2, p.getHeight() * 2);

    // for color stuff
    //Picture pBlue = new Picture(p);
    //Picture pRed = new Picture(p);
    //Picture pGreen = new Picture(p);

    // for Highlight Extremes
    //Picture pHighlight = new Picture(p);
    
    // for drawing sun
    Picture pSun = new Picture(p);
    
    //p.explore();
    
    // for color stuff
    //pRed.keepOnlyRed();
    //pRed.explore();
    //pBlue.keepOnlyBlue();
    //pBlue.explore();
    //pGreen.keepOnlyGreen();
    //pGreen.explore();
    
    // for scaling stuff
    //pUp.explore();
    //pUp.scaleUp(p);
    //pUp.explore();
    
    // for Highlight Extremes
    //pHighlight.highlightLightAndDark(60, ColorChooser.pickAColor());
    //pHighlight.explore();
    
    // for drawing sun
    pSun.drawSun();
    pSun.haveANiceDay();
    //pSun.drawX(Color.RED);
    pSun.drawGunSight(300, 250, 60);
    pSun.show();
    pSun.drawGunSight(500, 300, 90);
    //pSun.explore();
    pSun.show();
    
  }

} // this } is the end of class Picture, put all new methods before this
 