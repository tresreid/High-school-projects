import javax.swing.*;
import java.awt.event.*;

public class HelloFrame extends JFrame {
  
  public static void main(String[] args){
   new HelloFrame(); 
  }
  private JButton butt;
  private JButton butt2;
  public HelloFrame(){
   this.setSize(600, 300);
   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   this.setTitle("I'm Listening");
   
   JPanel panel = new JPanel();
   butt = new JButton("click me");
   butt2 = new JButton("Click me too!");
      ClickListener cl = new ClickListener();
   butt.addActionListener(cl);
   butt2.addActionListener(cl);
   panel.add(butt);
   panel.add(butt2);
   this.add(panel);
   
   this.setVisible(true);
  }
  
  public class ClickListener implements ActionListener{
      private int clickCount=0;
  private int clickCount2=0;
  public void actionPerformed(ActionEvent e){
    if(e.getSource() == butt){
     clickCount++;
     if(clickCount == 1){
      butt.setText("I've been clicked"); 
     }
     else{butt.setText("I've been clicked " + clickCount +" times!");}
    }
    else if(e.getSource() == butt2){
     clickCount2++;
     if(clickCount2 == 1){
      butt2.setText("I've been clicked"); 
     }
     else{butt2.setText("I've been clicked " + clickCount2 +" times!");}
    }
  }
  }
}