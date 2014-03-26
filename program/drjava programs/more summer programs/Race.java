import java.util.ArrayList;
public class Race {
  
  
  public static void main(String[] args) { 
    int x=1;
    int y=1;
  ArrayList<Racecar> racecars = new ArrayList<Racecar>();
 Racecar car;
 if(x==0){
 car= new RabbitRacecar();
   System.out.println(car.getName());
   System.out.println(car.getSpeed());
   System.out.println(car.getTraction());
 }
 else if (x==1){
   car= new TurtleRacecar();
   System.out.println(car.getName());
   System.out.println(car.getSpeed());
   System.out.println(car.getTraction());
 }
 else{ car= new RabbitRacecar();}
 
 ArrayList<Field> fields = new ArrayList<Field>();
 Field field;
 if (y==0){
   field= new PlainField();
 }
 else if (y==1){
 field= new SnowField();
 }
 else {field= new PlainField();}
 
 double time;
 time= field.getDistance() / car.getSpeed() ;
 System.out.println(time);
 time+= field.getBends() * 3.0 /car.getTurning();
 System.out.println(time);
 time+=field.getSlips() / car.getTraction();
  System.out.println(time);

 
  } 
}
