import java.util.Scanner;
import java.util.Random;
public class GuessDW
{
public static void main(String[] args)
{
  Scanner scan= new Scanner(System.in);
  Random gen= new Random();
  int correct=gen.nextInt(10)+1;
  int guess=0;
  String str="";
  int count=0;
  int high=0;
  int low=0;
  System.out.println("Please input your guess");
  do{
      guess=scan.nextInt();
      if(guess!=correct){
    if (guess<correct){low++; str="Your guess is too low.";}
    if (guess>correct){high++; str="Your guess is too high.";}
    System.out.println("Sorry, that is incorrect."+str+" Please try again");}
    count++;}
  while(guess!=correct);
  System.out.println("That is correct!");
  System.out.println("You have guessed "+count+" times"); 
  System.out.println(high+" of those times were too high and "+low+" of those times were too low. And 1 time was just right.");
}
}