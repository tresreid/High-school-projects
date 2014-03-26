/*
 * Class: Lp (Lazy Programmer)
 * 
 * Here are some methods that supply short cuts to commonly performed
 * tasks
 */

public class Lp
{
  
  /////////////////////////
  // methods
  //
  static void sopl (Object someObject)
  {
    System.out.println(someObject);
  }
  
  static void sop (Object someObject)
  {
    System.out.print(someObject);
  }

  static void pda (double[] theArray)
  {
    String s = "";
    if (theArray != null) {
      for (double entry : theArray)
      {
        s = s + entry + " ";
      }
    }
    System.out.println(s);
  }
  
} // this is the end of the Lp class