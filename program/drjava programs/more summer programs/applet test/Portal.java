  import java.awt.*;
  public class Portal{
    private int xPos,yPos;
    private int releasex,releasey;
    public Portal(int xPos, int yPos, int releasex, int releasey){
    super();
    this.xPos = xPos;
    this.yPos = yPos;
    this.releasex= releasex;
    this.releasey= releasey;
    }
    
    public int getXPos(){
      return xPos;
    }
    public int getYPos(){
     return yPos; 
    }
    public int getReleasex(){
      return releasex;
    }
    public int getReleasey(){
      return releasey;
    }
      
  }