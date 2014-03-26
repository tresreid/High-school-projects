import java.awt.*;
  public class Enemy{
    private int xPos,yPos;
    private int damage;
    
    public Enemy(int xPos, int yPos){
    super();
    this.xPos = xPos;
    this.yPos = yPos;
    this.damage = damage;
    }
    
    public int getXPos(){
      return xPos;
    }
    public int getYPos(){
     return yPos; 
    }
  }