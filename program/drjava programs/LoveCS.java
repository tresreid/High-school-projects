import java.util.Scanner;
public class LoveCS
{
public static void main(String[] args)
{
  Scanner scan= new Scanner(System.in);
final int LIMIT;
int count = 1;
int sum=0;
 System.out.println("PLease input the limit: ");
 LIMIT= scan.nextInt();
while (count <= LIMIT){
System.out.println(count+" I love Computer Science!!");
sum+=count;
count++;
}
System.out.println("this message printed "+(count-1)+" times.");
System.out.println("the sum of the numbers from 1 to "+(count-1)+" is "+sum);
}
}