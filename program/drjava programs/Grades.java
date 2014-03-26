import java.util.Scanner;
public class Grades
{
  public static void main(String[] arg)
  {
    int num;
    int nextGrade;
    int sum=0;
    int numpass=0;
    double avg;
    Scanner scan = new Scanner(System.in);
    System.out.println("Please input the number of grades to be processed");
    num=scan.nextInt();
    for(int i=0; i<num; i++){
      System.out.println("Please enter the next grade");
      nextGrade=scan.nextInt();
      numpass= nextGrade>=60? numpass+1: numpass+0;
      sum+=nextGrade;
    }
    avg= (double) sum/num;
    System.out.println("The average grade is "+ avg);
    System.out.println("The number of passing students is "+numpass);
    System.out.println("The number of failing students is "+(num-numpass));
  }
}