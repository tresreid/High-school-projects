import java.util.Random;
import javax.swing.JOptionPane;
public class keepGuessing
{
public static void main(String[] args)
{
  Random gen= new Random();
  int correct;
  int guess;
  String str="";
  int count=1;
  int high=0;
  int low=0;
  int again; 
  int gameNum=1;
  int off=0;
  String optstr;
  do{
  correct=gen.nextInt(101)+1;
  optstr=JOptionPane.showInputDialog("Please input your first guess between 1 and 100 inclusively: ");
  guess=Integer.parseInt(optstr);
  while(guess>100 || guess<1){
    optstr=JOptionPane.showInputDialog("I said between 1 and 100 inclusively. Try Again.");
    off++;count++;
    guess=Integer.parseInt(optstr);}
  while(guess!=correct){
    if (guess<correct){low++; str="Your guess is too low.";}
    if (guess>correct){high++; str="Your guess is too high.";}
    optstr=JOptionPane.showInputDialog(null,"Sorry, that is incorrect."+str+" Please try again");
    count++;
      guess=Integer.parseInt(optstr);
  while(guess>100 || guess<1){
    optstr=JOptionPane.showInputDialog("I said between 1 and 100 inclusively. Try Again.");
    off++;count++;
    guess=Integer.parseInt(optstr);}
  }
  JOptionPane.showMessageDialog(null,"That is correct! \n You have guessed "+count+" times \n "+off+" of those times were out of bounds " + high+" of those times were high. "+low+" of those times were low. And "+gameNum+" of those times were just right.");
  again= JOptionPane.showConfirmDialog(null,"Would you like to play again?");
  gameNum++; count++;
  }while(again==JOptionPane.YES_OPTION);
  JOptionPane.showMessageDialog(null,"Thank You for Playing.\n You have played "+(gameNum-1)+" games\n the average number of guesses per game is "+(double) (count-1)/(gameNum-1)+" guesses.");
}
}