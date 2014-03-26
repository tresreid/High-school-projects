
import java.util.Scanner;
public class LazyDays2{
  public static void main(String[] arg){
    int temp;
    Scanner scan = new Scanner(System.in);
    System.out.println("Please input a temperature: ");
    temp = scan.nextInt();
    if( temp >=90 || temp<=20){ System.out.println("Please Visit our Shop!");}
    if( temp >=80 && temp <90){System.out.println("Swimming");}
    if( temp >=60 && temp <80){System.out.println("Tennis");}
    if( temp >=40 && temp <60){System.out.println("Golf");}
    if( temp >=20 && temp <40){System.out.println("Skiing");}                                        
      
    
    
    
  }
}