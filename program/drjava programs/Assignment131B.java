import java.util.Random;
public class Assignment131B
{
  public static void main(String[] arg)
  {
Random generator = new Random();
int length= generator.nextInt(110000000);
int n= 25000;
int[] lolz = new int[length];
lolz= ArrayUtil.randomIntArray(length, n);
//ArrayUtil.print(lolz);
StopWatch watch;
watch=new StopWatch();
watch.start();
int max=lolz[0];
int min=lolz[0];
double average=0;
for(int i=0; i<lolz.length-1;i++){
  if(lolz[i]<min){ min=lolz[i];}
  if(lolz[i]>max){ max=lolz[i];}
  average+=lolz[i];
}
average=average/lolz.length;
System.out.println("The min is : "+min+"\nThe Max is : "+max+"\nThe average is : "+average);
watch.stop();
long time= watch.getElapsedTime();
System.out.println("The time is "+time);
  }
}