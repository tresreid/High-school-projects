public class DrunkenTurtle extends Turtle
{
  
  public DrunkenTurtle(World w)
  { 
    super(w);
  }
  
  public void forward()
  {
    turn(5);
    super.forward();
  }
  
   public static void main(String[] args)
  {
    World earth = new World();
    Turtle t1 = new Turtle(earth);
    DrunkenTurtle t2 = new DrunkenTurtle(earth);
    t1.forward();
    t1.turnRight();
    t2.turnRight();
    t1.forward();
    t2.forward();
  }
}