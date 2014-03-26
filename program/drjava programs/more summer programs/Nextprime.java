import javax.swing.*;
import java.math.*;
public class Nextprime
{
  public static void main (String[] args)
  {
    int bound=Integer.parseInt(JOptionPane.showInputDialog(null,"input the bound, motherfucka."));
    int[] primearray= new int[bound];
    int count=0;
    int prime=2;
    double sqrt;
    String pri="";
    for (int i=0; i<bound;i++)
    {
      
    sqrt=Math.sqrt(i);
    if (i % 2==0){
      if(i==2){prime=0;}
      else{prime=1;}
    }
    
    else{
      for(int j= i-1;j>=sqrt; j--){
        if (i% j==0){prime=1;break;}
        else{prime=0;}
      }
    }
    if (prime==0){count++;primearray[i]=i;}
    else if (prime==1){count=count+0;primearray[i]=0;}
    else {JOptionPane.showMessageDialog(null,"yo dawg, something fucked up.");}
    }
    for(int k=0;k<bound;k++)
    {
      if (primearray[k] != 0){pri = pri +","+ primearray[k];}
      else{pri=pri;}
    }
    JOptionPane.showMessageDialog(null,pri);
    JOptionPane.showMessageDialog(null,"there are "+ count+ " prime numbers up to the number "+bound +".");
  }
}