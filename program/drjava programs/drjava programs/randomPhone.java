import java.util.Random;
public class randomPhone{
  public static void main(String[] arg){
    int first;
    int second;
    int third;
    int a;
    int b;
    int c;
    Random gen = new Random();
   
    a= gen.nextInt(8);
    b= gen.nextInt(8);
    c= gen.nextInt(8);
    first = (a*100) + (b*10) + c;
    second = gen.nextInt(643)+100;
    while ( second > 742){ second = gen.nextInt(1000);}
    third = gen.nextInt(10000); 
    if(first==0){System.out.print("000 ");}
    else if(first<10){System.out.print("00"+first+"-");}
    else if( first < 100){  System.out.print("0"+first + "-");}
      else {System.out.print(first + "-");}
      
    if(second==0){System.out.print("000-");}
    else if(second<10){System.out.print("00"+second);}
    else if( second < 100){  System.out.print("0"+second + "-");}
    else {System.out.print(second + "-");}
    
    if(third==0){System.out.println("0000");}
    else if(third<10){System.out.println("000"+third);}
    else if(third<100){System.out.println("00"+third);}
    else if( third < 1000){System.out.println("0"+third);} 
      else {System.out.println(third);} 
      
}
  
  }
