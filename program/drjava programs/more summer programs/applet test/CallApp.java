import javax.swing.*;
import java.applet.*;
public class CallApp
{   public static void main(String args[]){
//     { 
//     App a = new App(); 
//     }
 JFrame frame = new JFrame();
    frame.add(new App());
    frame.setVisible(true);  // don't even need to call repaint() on the Applet
  
 }
}