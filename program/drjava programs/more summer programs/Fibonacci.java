import javax.swing.*;
public class Fibonacci
{
 public static void main (String[] args)
 {
   String fibby="1,1";
  int bound=Integer.parseInt(JOptionPane.showInputDialog(null,"Please input the bound.")); 
  long[] fibarray= new long[bound];
  fibarray[0]=0;
  fibarray[1]=1;
  for(int i=2;i<bound;i++)
  {
    fibarray[i]=fibarray[i-1] +fibarray[i-2];
    fibby= fibby + "," +fibarray[i];
  }
  JOptionPane.showMessageDialog(null,fibby);
 }
}