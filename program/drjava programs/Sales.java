// ****************************************************************
// Sales.java
//
// Reads in and stores sales for each of 5 salespeople. Displays
// sales entered by salesperson id and total sales for all salespeople.
//
// ****************************************************************
import java.util.Scanner;
public class Sales
{
public static void main(String[] args)
{
final int SALESPEOPLE;
Scanner scansal= new Scanner(System.in);
System.out.println("Please input the number of sales people");
SALESPEOPLE =scansal.nextInt();
int[] sales = new int[SALESPEOPLE];
int sum;
int max=0;
int maxperson=0;
int min=1000000;
int minperson=0;
Scanner scan = new Scanner(System.in);
Scanner value = new Scanner(System.in);
int val;
int countsales=0;
for (int i=0; i<sales.length; i++)
{
System.out.print("Enter sales for salesperson " + i + ": ");
sales[i] = scan.nextInt();
}
System.out.println("\nSalesperson Sales");
System.out.println("--------------------");
sum = 0;
for (int i=0; i<sales.length; i++)
{
System.out.println(" " + i + " " + sales[i]);
sum += sales[i];
if(sales[i]>max){max=sales[i];maxperson=i+1;}
if(sales[i]<min){min=sales[i];minperson=i+1;}
}
System.out.println("\nTotal sales: " + sum);
System.out.println("\nAdverage sales: " + sum/sales.length);
System.out.println("Salesperson "+maxperson+" had the highest sale with $"+max+".");
System.out.println("Salesperson "+minperson+" had the lowest sale with $"+min+".");
System.out.println("please input a value");
  val=value.nextInt();
for (int i=0; i<sales.length; i++){
  if(sales[i]>val){System.out.println("id: "+(i+1)+"\tsales: "+sales[i]);countsales++;}
}
System.out.println("the number of sales above "+val+" is "+countsales);
}
}