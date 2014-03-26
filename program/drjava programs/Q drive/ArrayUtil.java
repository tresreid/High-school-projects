import java.util.Random;

/*
 * this class contains utility methods for array manipulation.
 */
public class ArrayUtil
{
  /*
   * the only instance field needed is a generator for random numbers
   */
  private static Random generator = new Random();
  
  /*
   * Creates an array filled with random values.
   * @param length the length of the array
   * @param n the number of possible random values
   * @return an array filled with "length" values between 0 and n-1
   */
  public static int[] randomIntArray(int length, int n)
  {
    int[] returnArray = new int[length];
    for (int i = 0; i < length; i++)
      returnArray[i] = generator.nextInt(n);
    
    return returnArray;
  }
  
  /*
   * prints all elements in an array of ints
   * @param array the integer array to print
   */
  public static void print(int[] array)
  {
    for (int i : array)
      System.out.print(i + " ");
    
    // new line (return) only at the very end
    System.out.println();
  }
}