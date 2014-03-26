public class SlideShow
{
  /////////////// fields ///////////////
  private int waitTime = 2000; // wait 2 seconds
  private Picture[] pictureArray;

  //////////// constructors ///////////
  public SlideShow() {}
  
  public SlideShow(int theTime)
  {
    this.waitTime = theTime;
  }
  
  public SlideShow(Picture[] theArray)
  {
    this.pictureArray = theArray;
  }

  /////////// methods ///////////////
  
  public int getNumPicts()
  {
    // if no picture array then there are no pictures
    if (this.pictureArray == null)
    {
      return 0;
    }
    // else return the number of pictures in the array
    else
    {
      return pictureArray.length;
    }
  }
    
  public String toString()
  {
    return "SlideShow object with a wait time of: " + 
            this.waitTime + " and " +
            this.getNumPicts() + " pictures";
  }
  
  public static void main(String[] args)
  {
    Picture p1 = 
      new Picture(FileChooser.getMediaPath("beach.jpg"));
    Picture p2 = 
      new Picture(FileChooser.getMediaPath("church.jpg"));  
    Picture[] pictArray = {p1,p2};
    SlideShow show1 = new SlideShow(pictArray);
    System.out.println(show1);
  }
  
}
