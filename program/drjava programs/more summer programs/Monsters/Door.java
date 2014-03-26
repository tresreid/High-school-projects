  import java.awt.*;
  public class Door{
    private int xPos,yPos;
    private boolean locked;
    
    public Door(int xPos, int yPos, boolean locked){
    super();
    this.xPos = xPos;
    this.yPos = yPos;
    this.locked=locked;
    }
    
    public int getXPos(){
      return xPos;
    }
    public int getYPos(){
     return yPos; 
    }
    public boolean getLocked(){
      return locked;
    }
    public void setLocked(boolean locked){
      this.locked=locked;
    }
  }
    
      