import java.util.Scanner;
import java.lang.System;

public class SorterRunner
{
  
  /*
   * this class demonstrates the various Sorter classes;
   *  comment out the section for any sorter class you have not yet completed
   */
  public static void main(String[] args)
  {

    StopWatch timer = new StopWatch();
    int[] a;
    
    Scanner in = new Scanner(System.in);
    System.out.print("Do you want to print arrays? 1 = yes, 0 = no ");
    int printArray = in.nextInt();
    
    System.out.print("Enter an array size (enter 0 to stop): ");
    int length = in.nextInt();
    
    while (length > 0)
    {
      // construct random array; values in array between 0 and 199
      a = ArrayUtil.randomIntArray(length, 200);
      
      // print the array
      if (printArray == 1)
      {
        System.out.println("Orignal Array:");
        ArrayUtil.print(a);
        System.out.println("--------");
      }
      
      // make a copy of the array and let SelectionSorter sort the copy
      int[] c = new int[a.length];
      System.arraycopy(a, 0, c, 0, a.length);
      SelectionSorter s1 = new SelectionSorter(c);
      // use stopwatch to time sorting of the array
      timer.reset();
      timer.start();
      s1.sort();
      timer.stop();
      // print the array
      if (printArray == 1)
        ArrayUtil.print(c);
      System.out.println("Selection Sort - Elapsed time: " + timer.getElapsedTime() + " milliseconds");
      System.out.println("           No. of comparisons: " + s1.getComparisons());
      System.out.println("              No. of accesses: " + s1.getAccesses() + "\n");

      // make a new copy of the original array and let InsertionSorter sort the copy
      System.arraycopy(a, 0, c, 0, a.length);
      InsertionSorter i = new InsertionSorter(c);
      // use stopwatch to time sorting of the array
      timer.reset();
      timer.start();
      i.sort();
      timer.stop();
      // print the array
      if (printArray == 1)
        ArrayUtil.print(c);
      System.out.println("Insertion Sort - Elapsed time: " + timer.getElapsedTime() + " milliseconds");
      System.out.println("           No. of comparisons: " + i.getComparisons());
      System.out.println("              No. of accesses: " + i.getAccesses() + "\n");
      
      // make a new copy of the original array and let BubbleSorter sort the copy
      /*System.arraycopy(a, 0, c, 0, a.length);
      BubbleSorter b = new BubbleSorter(c);
      // use stopwatch to time sorting of the array
      timer.reset();
      timer.start();
      b.sort();
      timer.stop();
      // print the array
      if (printArray == 1)
        ArrayUtil.print(c);
      System.out.println("Bubble Sort - Elapsed time: " + timer.getElapsedTime() + " milliseconds");
      System.out.println("        No. of comparisons: " + b.getComparisons());
      System.out.println("           No. of accesses: " + b.getAccesses() + "\n");

      // make a new copy of the original array and let MergeSorter sort the copy
      System.arraycopy(a, 0, c, 0, a.length);
      MergeSorter m1 = new MergeSorter(c);
      // use stopwatch to time sorting of the array
      timer.reset();
      timer.start();
      m1.sort();
      timer.stop();
      // print the array
      if (printArray == 1)
        ArrayUtil.print(c);
      System.out.println("Merge Sort - Elapsed time: " + timer.getElapsedTime() + " milliseconds");
      System.out.println("       No. of comparisons: " + m1.getComparisons());
      System.out.println("          No. of accesses: " + m1.getAccesses() + "\n");

      // make a new copy of the original array and let MergeSorterInPlace sort the copy
      System.arraycopy(a, 0, c, 0, a.length);
      MergeSorterInPlace m2 = new MergeSorterInPlace(c);
      // use stopwatch to time sorting of the array
      timer.reset();
      timer.start();
      m2.sort();
      timer.stop();
      // print the array
      if (printArray == 1)
        ArrayUtil.print(c);
      System.out.println("Merge Sort IP - Elapsed time: " + timer.getElapsedTime() + " milliseconds");
      System.out.println("          No. of comparisons: " + m2.getComparisons());
      System.out.println("             No. of accesses: " + m2.getAccesses() + "\n");

      // make a copy of the array and let QuickSorter sort the copy
      c = new int[a.length];
      System.arraycopy(a, 0, c, 0, a.length);
      QuickSorter q1 = new QuickSorter(c);
      // use stopwatch to time sorting of the array
      timer.reset();
      timer.start();
      q1.sort();
      timer.stop();
      // print the array
      if (printArray == 1)
        ArrayUtil.print(c);
      System.out.println("Quick Sort - Elapsed time: " + timer.getElapsedTime() + " milliseconds");
      System.out.println("       No. of comparisons: " + q1.getComparisons());
      System.out.println("          No. of accesses: " + q1.getAccesses() + "\n");
*/
      // get a new array size
      System.out.print("Enter an array size (enter 0 to stop): ");
      length = in.nextInt();
      
    }
    
  }

}