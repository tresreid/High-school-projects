import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

  public class Key{
    private int xPos,yPos;
    private boolean obtained;
    BufferedImage img;
    
    public Key(int xPos, int yPos){
    super();
    this.xPos = xPos;
    this.yPos = yPos;
    try {
      img = ImageIO.read(new File("sprites/key.png"));
    } catch (IOException e) {
      System.out.println("cant read file");
    }
    }
    
    public int getXPos(){
      return xPos;
    }
    public int getYPos(){
     return yPos; 
    }
    public boolean getObtained(){
      return obtained;
    }
    public void setObtained(boolean obtained){
      this.obtained=obtained;
    }
    public BufferedImage getImg(){
      return img;
    }
  }
    
      