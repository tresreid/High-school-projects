import java.util.Scanner;
public class idealWeight{
  public static void main(String[] arg){
    int feet;
    int inches;
    int height;
    double rangeTop;
    double rangeBot;
    Scanner scan = new Scanner(System.in);
    String gender;
    int x;
    
    System.out.println("Are you a Male (yes or no):");
    gender=scan.nextLine();
    System.out.println("What is your height in feet(without inches:");
     feet=scan.nextInt();
    System.out.println("Please add inches:");
      inches=scan.nextInt();
      
      height= feet*12 + inches;
      if(gender.equals("no")){
      x= 100+((height-60)*5);
      rangeTop = x+(double)x*.15;
      rangeBot = x-(double)x*.15;
    }
    else if (gender.equals("yes")){
      x= 106+((height-60)*6);
      rangeTop = x+(double)x*.15;
      rangeBot = x-(double)x*.15;
    }
    else {
      System.out.println("your gender is undefined");
      x= 00000;
      rangeTop = x+(double)x*.15;
      rangeBot = x-(double)x*.15;
    } 
    System.out.println("your ideal weight is "+x+" Pounds");
    System.out.println(" your ideal weight range is "+rangeBot+" to "+rangeTop+" pounds.");
  }
}