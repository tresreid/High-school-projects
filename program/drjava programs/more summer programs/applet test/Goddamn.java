import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Goddamn extends Applet implements ActionListener{
  Button butt;
  Button butt2;
  int count1=100;
  int count2=100;
  int width, height;
    
    public void init(){
    System.out.println("Yo i'm starting up");
    setSize(600,500);
    width = getSize().width;
    height = getSize().height;
    butt= new Button("click me bitch");
    butt2= new Button("click me too bitch");
    butt.addActionListener(this);
    butt2.addActionListener(this);
    add(butt);
    add(butt2);
  }
  public void start(){
        System.out.println("Yo i'm getting up");
        repaint();
  }
  public void stop(){
        System.out.println("Yo i'm getting down");
  }
  public void destroy(){
        System.out.println("Yo i'm headding off. laterz");
  }
  public void paint( Graphics g ) {
      System.out.println("paint()");
      g.setColor( Color.green );
      g.drawLine( 0, height/6, (width/2)-((100-count1)*((width/2))/100), height/6 );
      g.setColor(Color.red);
      g.drawLine( width, height/6, (width / 2)+((100-count2)*((width/2))/100), height/6 );
            g.setColor(new Color(125,125,1));
         g.drawString( "Health 1: "+count1 +"/100", width/99, height/6 );
         g.drawString("health 2: "+count2+"/100", 98*width/99, height/6);
   }
  public void actionPerformed(ActionEvent e){
    if(e.getSource() == butt){
      remove(butt);
      remove(butt2);
       Button butt3= new Button("click me ");
   Button butt4= new Button("click me too");
    butt3.addActionListener(this);
    butt4.addActionListener(this);
    add(butt3);
    add(butt4);
     count1--;
     System.out.println(count1);
     repaint();
     if(e.getSource()==butt3){
       System.out.println("you clicked me!");
     }
     else if (e.getSource()==butt4){
       System.out.println("You Clicked Me!!!!");
     }
      }
      
    
    else if(e.getSource() == butt2){
      if(count2>0){
     count2--;
     System.out.println(count2);
     repaint();
      }
      else{System.out.println("Player 2 is dead");}
    }
    repaint();
  }
  
}