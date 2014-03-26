public class InsertionSorter{
int[] a;
  private long access=0;
  private long compare=0;
public InsertionSorter(int[] a){
  this.a =a;
}
public void sort()
{
 int i, j, temp;
 for (i=1;i< a.length;i++){
     temp = a[i];
      j = i;
      compare++;
 while (j > 0 && a[j - 1] > temp) {
      a[j] = a[j - 1];
      access=access+3;
      j--;
    }
    a
      [j] = temp;
  }
}    
    public long getComparisons(){
      return compare;
    }
      public long getAccesses(){
        return access;
      }
}