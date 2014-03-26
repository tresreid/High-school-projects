import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Jpanetest extends JFrame{
  
  
  public static void main(String[] args) { 
    new Jpanetest();
  }
  
//private JButton butt;
//  private JButton butt2;
  private JLabel health1, health2;
  private int h1=0;
  private int h2=0;
  public Jpanetest(){
   this.setSize(600, 300);
   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   this.setTitle("click contest");
   
   JPanel panel = new JPanel();
   panel.setLayout(new GridBagLayout());
   GridBagConstraints c = new GridBagConstraints();

   health1 = new JLabel();   
   health2 = new JLabel();
   while(1==1){
   health1.setText(String.valueOf(h1));
   health2.setText(String.valueOf(h2));
   c.gridx=0;
   c.gridy=0;
   panel.add(health1,c);
   c.gridx=0;
   c.gridy=6;
   panel.add(health2,c);
   this.add(panel);
   String[] opts = {"Click 1","Click 2"};
    int actionA = JOptionPane.showOptionDialog (null, "Choose an Action", "YOUR TURN!!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opts, opts[0]);
    if(actionA == 0){ h1++;}
    else if (actionA == 1){ h2++;}
    
   this.setVisible(true);
   }
}
}
