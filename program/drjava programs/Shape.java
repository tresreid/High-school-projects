// Draws a motherfuck'n hypercube.
import java.applet.Applet;
import java.awt.*;

public class Shape extends Applet{
  public void paint (Graphics page){
    int x=50;
    int y=200;
    int z=500; 
//    int i=1;
    final int length = z;   // keeps that bitch a square.
    final int sqrStart1= x;  // x-value = y-value. FUCK!
    final int sqrStart2=sqrStart1 + (length/2);//keeps dem squares together to make it cube-ish.
    final int sqrEnd1=sqrStart1 + length;// Coordinates for that bitch's ass.
    final int sqrEnd2=sqrStart2 + length;// Coordinates for that other bitch's ass.
    setBackground(Color.black);// puts this shit in Africa.
//    if(i<=300){
//    for (i=1; i<=150; i++){
    page.setColor(Color.red);
    page.drawRect (sqrStart1, sqrStart1, length, length);
    page.setColor(Color.blue);
    page.drawRect (sqrStart2, sqrStart2, length, length);
    page.setColor(Color.orange);
    page.drawLine (sqrStart1, sqrStart1, sqrStart2, sqrStart2);// connects these bitches and makes a cube.
    page.drawLine (sqrEnd1, sqrStart1, sqrEnd2, sqrStart2);
    page.drawLine (sqrStart1, sqrEnd1, sqrStart2, sqrEnd2);
    page.drawLine (sqrEnd1, sqrEnd1, sqrEnd2, sqrEnd2);
   
    final int length2 =750-z;//keeps that bitch thin. (length/2)
    final int sqrStart3= y;// same shit as before.
    final int sqrStart4=sqrStart3 + (length2/2);
    final int sqrEnd3=sqrStart3 + length2;
    final int sqrEnd4=sqrStart4 + length2;
    page.setColor(Color.cyan);
    page.drawRect (sqrStart3, sqrStart3, length2, length2);
    page.setColor(Color.green);
    page.drawRect (sqrStart4, sqrStart4, length2, length2);
    page.setColor(Color.yellow);
    page.drawLine (sqrStart3, sqrStart3, sqrStart4, sqrStart4);// connects these into a smaller cube.
    page.drawLine (sqrEnd3, sqrStart3, sqrEnd4, sqrStart4);
    page.drawLine (sqrStart3, sqrEnd3, sqrStart4, sqrEnd4);
    page.drawLine (sqrEnd3, sqrEnd3, sqrEnd4, sqrEnd4);
    page.setColor(Color.magenta);// connects the cubes into a hypercube.
    page.drawLine (sqrStart1, sqrStart1, sqrStart3, sqrStart3);
    page.drawLine (sqrEnd1, sqrStart1, sqrEnd3, sqrStart3);
    page.drawLine (sqrStart1, sqrEnd1, sqrStart3, sqrEnd3);
    page.drawLine (sqrEnd1, sqrEnd1, sqrEnd3, sqrEnd3);
    page.drawLine (sqrStart2, sqrStart2, sqrStart4, sqrStart4);
    page.drawLine (sqrEnd2, sqrStart2, sqrEnd4, sqrStart4);
    page.drawLine (sqrStart2, sqrEnd2, sqrStart4, sqrEnd4);
    page.drawLine (sqrEnd2, sqrEnd2, sqrEnd4, sqrEnd4); 
//    x++; 
//    y--; 
//    z--;
  }
/*    for(i=151;i>150; i++){
    page.setColor(Color.red);
    page.drawRect (sqrStart1, sqrStart1, length, length);
    page.setColor(Color.blue);
    page.drawRect (sqrStart2, sqrStart2, length, length);
    page.setColor(Color.orange);
    page.drawLine (sqrStart1, sqrStart1, sqrStart2, sqrStart2);// connects these bitches and makes a cube.
    page.drawLine (sqrEnd1, sqrStart1, sqrEnd2, sqrStart2);
    page.drawLine (sqrStart1, sqrEnd1, sqrStart2, sqrEnd2);
    page.drawLine (sqrEnd1, sqrEnd1, sqrEnd2, sqrEnd2);
   
    final int length2 =750-z;//keeps that bitch thin. (length/2)
    final int sqrStart3= y;// same shit as before.
    final int sqrStart4=sqrStart3 + (length2/2);
    final int sqrEnd3=sqrStart3 + length2;
    final int sqrEnd4=sqrStart4 + length2;
    page.setColor(Color.cyan);
    page.drawRect (sqrStart3, sqrStart3, length2, length2);
    page.setColor(Color.green);
    page.drawRect (sqrStart4, sqrStart4, length2, length2);
    page.setColor(Color.yellow);
    page.drawLine (sqrStart3, sqrStart3, sqrStart4, sqrStart4);// connects these into a smaller cube.
    page.drawLine (sqrEnd3, sqrStart3, sqrEnd4, sqrStart4);
    page.drawLine (sqrStart3, sqrEnd3, sqrStart4, sqrEnd4);
    page.drawLine (sqrEnd3, sqrEnd3, sqrEnd4, sqrEnd4);
    page.setColor(Color.magenta);// connects the cubes into a hypercube.
    page.drawLine (sqrStart1, sqrStart1, sqrStart3, sqrStart3);
    page.drawLine (sqrEnd1, sqrStart1, sqrEnd3, sqrStart3);
    page.drawLine (sqrStart1, sqrEnd1, sqrStart3, sqrEnd3);
    page.drawLine (sqrEnd1, sqrEnd1, sqrEnd3, sqrEnd3);
    page.drawLine (sqrStart2, sqrStart2, sqrStart4, sqrStart4);
    page.drawLine (sqrEnd2, sqrStart2, sqrEnd4, sqrStart4);
    page.drawLine (sqrStart2, sqrEnd2, sqrStart4, sqrEnd4);
    page.drawLine (sqrEnd2, sqrEnd2, sqrEnd4, sqrEnd4);
    x--;
    y++;
    z++;
    }
  }
    else{
      i=1;}*/ 
}