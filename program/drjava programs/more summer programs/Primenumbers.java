import javax.swing.*;
import java.math.*;
public class Primenumbers
{
  public static void main (String[] args)
  {
    int continueon;
    int prime=2;
    double sqrt;
    
    do
    {
      int num= Integer.parseInt(JOptionPane.showInputDialog(null,"please input a number."));
    sqrt=Math.sqrt(num);
    if (num % 2==0){
      if(num==2){prime=0;}
      else{prime=1;}
    }
    
    else{
      for(int i= num-1;i>=sqrt; i--){
        if (num% i==0){prime=1;break;}
        else{prime=0;}
      }
    }
    if (prime==0){JOptionPane.showMessageDialog(null,"the number is prime, yo");}
    else if (prime==1){JOptionPane.showMessageDialog(null,"the number is not prime, yo");}
    else {JOptionPane.showMessageDialog(null,"yo dawg, something fucked up.");}
    
    String[] stay= {"yes","no"};//options to continue the program
    int mc = JOptionPane.QUESTION_MESSAGE;
continueon = JOptionPane.showOptionDialog (null,"Would you like to continue?", "Title", JOptionPane.YES_NO_OPTION,mc, null,stay, stay[1]);
    }while(continueon==JOptionPane.YES_OPTION);
  }
}