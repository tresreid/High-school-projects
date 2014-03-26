import java.util.Scanner;
public class PowersOf2
{
public static void main(String[] args)
{
  int power;
  int sum=1;
  Scanner scan= new Scanner(System.in);
  System.out.println("Please imput the power :");
  power=scan.nextInt();
  System.out.println("Here are the first "+power+" powers of 2: ");
  for(int i=0;i<power;i++){
    System.out.println("2^"+i+" = "+sum);
    sum*=2;}
}
}