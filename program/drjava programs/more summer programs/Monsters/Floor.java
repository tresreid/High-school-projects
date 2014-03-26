import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
public class Floor{
  private int xPos,yPos;
  BufferedImage img;
  
  public Floor(int xPos, int yPos){
    super();
    this.xPos = xPos;
    this.yPos = yPos;
     try {
      img = ImageIO.read(new File("sprites/dungeon floor tile.jpg"));
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
  public BufferedImage getImg(){
      return img;
    }
  
}