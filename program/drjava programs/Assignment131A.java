public class Assignment131A
{
  public static void main(String[] arg)
  {
int length= 20;
int n= 200;
int[] lolz = new int[20];
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