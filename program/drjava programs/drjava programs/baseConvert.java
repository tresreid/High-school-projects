import java.util.Scanner;
import java.math.*; 
public class baseConvert
{
  public static void main (String[] arg){
    int base;
    int remainder;
    int quotient;
    int original;
    String number = "";
    Scanner scan = new Scanner(System.in);
    double maxnum;
    
    System.out.println("Please input a number: ");
    original = scan.nextInt();
    quotient = original;
    System.out.println("Please input a base to convert to: ");
    base = scan.nextInt();
    maxnum = Math.pow(base, 4)-1;
    
    for (int i=0;i<=4;i++){
    if (quotient % base == 0){
      remainder = quotient % base;
      quotient = quotient / base;
      number = "0" + number;
    }
    if (quotient % base != 0){
      remainder = quotient % base;
      quotient = quotient / base;
      number = remainder + number;
    }
    }
      System.out.println(" the number " + original +" is equal to " + number.substring(number.length()-4) + " in base " + base);
      System.out.println(" the Max Value of this base in for digits is equal to " + maxnum); 
      
      if ( Math.abs(original - maxnum) < .1){
        System.out.println("That is the Maximum number in that base that will fit in 4 digit places");
      }
        else {
          System.out.println("That is not the Maximum number in that base that will fit in 4 digit places");
        }
    
    
    
  }
}