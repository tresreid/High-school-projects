import java.applet.Applet;
import java.awt.*;

public class Einstein extends Applet{
  public void paint (Graphics page){
    page.drawRect (50, 50, 40, 40);
    page.drawRect (60, 80, 300, 30);
    page.drawOval (75, 65, 20, 20);
    page.drawLine ( 35, 60, 100, 120);
    page.drawString("Look at this shit",110, 70);
    page.drawString("AWWW SHIT. I'm in a GOD DAMN BOX",130, 100);
  }
}