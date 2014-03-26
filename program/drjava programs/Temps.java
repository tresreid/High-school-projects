// **********************************************************
//   Temps.java
//
//   This program reads in a sequence of hourly temperature 
//   readings (beginning with midnight) and prints the maximum
//   temperature (along with the hour, on a 24-hour clock, it 
//   occurred) and the minimum temperature (along with the hour
//   it occurred).  Remember: temperatures CAN be negative numbers
// **********************************************************

import java.util.Scanner;

public class Temps 
{
    //----------------------------------------------------
    //  Reads in a sequence of temperatures and finds the
    //  maximum and minimum read in.
    //----------------------------------------------------
    public static void main (String[] args)
    {
 final int HOURS_PER_DAY = 24;

 int temp;   // a temperature reading
 int maxTemp=-1000000;
 int minTemp=1000000;
 int sumTemp=0;
 int timeofMax=0;
 int timeofMin=0;
 Scanner scan = new Scanner(System.in);

 // print program heading
 System.out.println ();
 System.out.println ("Temperature Readings for 24 Hour Period");
 System.out.println ();

 for (int hour = 0; hour < HOURS_PER_DAY; hour++)
 {
     System.out.print ("Enter the temperature reading at " + hour +
    " hours: ");
     temp = scan.nextInt();
     if(temp>maxTemp){
       maxTemp=temp;
     timeofMax=hour;}
     if(temp<minTemp){
       minTemp=temp;
     timeofMin=hour;}
     sumTemp+=temp;
            // code for detecting and storing the maximum temperature
            //   should go below here

            // code for detecting and storing the minimum temperature
            //   should go below here

            // extra challenge: add code below here that would be needed
            // to help you compute the average temperature for the day

 }
System.out.println(" the maximun temperature is "+maxTemp+" and occurs at hour "+timeofMax);
System.out.println(" the minimun temperature is "+minTemp+" and occurs at hour "+timeofMin);
System.out.println(" the adverage temperature for the day is "+(sumTemp/24));
 // Print the results: maximum and minimum
        //  Extra challenge: also print the average temperature for the day

    }
}