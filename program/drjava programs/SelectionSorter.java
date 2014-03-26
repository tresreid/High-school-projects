public class SelectionSorter{
int[] a;
  private long access=0;
  private long compare=0;
public SelectionSorter(int[] a){
  this.a =a;
}
public void sort()
{
  int temp,min;
  for(int i = 0; i< (a.length-1);i++){
    min=i;
    for(int j=i+1; j<a.length; j++){
      compare++;
      if(a[j]<a[min]){
        temp=a[j];
         a[j]=a[min];
         a[min]=temp;
         access= access+3;
      }
    }
        
  }
}
    public long getComparisons(){
      return compare;
    }
      public long getAccesses(){
        return access;
      }
}