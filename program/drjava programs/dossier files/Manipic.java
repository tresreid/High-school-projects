import java.util.Random; 
import javax.swing.*;
import java.io.*;

public class Manipic
{
  private FileChooser testpic = new FileChooser();
  private String filename=testpic.pickAFile();
  private Picture pictureObject= new Picture(filename);
  private String keyname= filename + " key.txt";
  
  public Manipic()
  {
    System.out.println(filename);//prints the filenamed for varification purposes
    pictureObject.show();//shows the file for varification purposes. 
  }
  //Scramble method
  public void scramble()
  {
    int height= pictureObject.getHeight();
    int width= pictureObject.getWidth();
    int hw= height*width;// "hm" stands for the height times the width. 
    Random gen= new Random();//makes a random generator 
    Pixel[] pixelArray = new Pixel[hw];//creates an array of pixels the size of "hw"- the total number of pixels in the file.
    pixelArray= pictureObject.getPixels();// fills the array with pixels
    int[] pixelIndex = new int[hw];//creates another file the size of the number of pixels.
    for(int i=0; i<pixelIndex.length; i++){//makes this array hold a value to repesent the starting postion of the pixles in "pixelArray"
      pixelIndex[i]= i;
    }
    
    // more varibles. these will temporarily hold the RGB values of two pixels in different places.indexTemp will temporarily hold one number value.
    int valueTempred= 0;
    int valueTempblue=0;
    int valueTempgreen=0;
    int valueTempred2= 0;
    int valueTempblue2=0;
    int valueTempgreen2=0;
    int indexTemp=0;
    
    for( int i=0; i<pixelArray.length; i++){
      int ran=gen.nextInt(hw);
      //temporarily holds the RGB values for the next pixel and the random pixel
      valueTempred=pixelArray[i].getRed();
      valueTempblue=pixelArray[i].getBlue();
      valueTempgreen=pixelArray[i].getGreen();
      valueTempred2=pixelArray[ran].getRed();
      valueTempblue2=pixelArray[ran].getBlue();
      valueTempgreen2=pixelArray[ran].getGreen();
      pixelArray[i].setRed(valueTempred2);
      pixelArray[i].setBlue(valueTempblue2);
      pixelArray[i].setGreen(valueTempgreen2);
      pixelArray[ran].setRed(valueTempred);
      pixelArray[ran].setBlue(valueTempblue);
      pixelArray[ran].setGreen(valueTempgreen);
      //now parallel array to change the index values in the same way that the pixels where changed. thus the number will still match it's pixel after it is rearranged
      indexTemp=pixelIndex[i];
      pixelIndex[i]=pixelIndex[ran];
      pixelIndex[ran]=indexTemp;
    }//ends the scrambling loop
    
    pictureObject.write(filename);//rewrites the file
    try{
      BufferedWriter writer = new BufferedWriter(new FileWriter(keyname));//creates a text file to hold the key that will be made
      String key=""; //makes a key for descrambling 
      for(int i=0; i<pixelIndex.length;i++){//puts the numbers in the pixelIndex into the key
        key += pixelIndex[i];
        key += " ";
      }
      writer.write(key);//writes the key to the new file
      writer.newLine();
      writer.close();
    }
    catch (Exception ex){//error handleing
      System.out.println("Error writing to " +filename);
    }
  }//Ends Scramble method
  
  //UNSCRAMBLE METHOD  
  public void unscramble()
  {
    int height= pictureObject.getHeight();
    int width= pictureObject.getWidth();
    int hw= height*width;
    Pixel[] pixelArray = new Pixel[hw];
    pixelArray= pictureObject.getPixels();//puts all the pixels into an array
    String line = "";
    String data = "";
    
    try {
      FileReader fr = new FileReader(keyname);//reads the key file
      BufferedReader br = new BufferedReader(fr);
      while((line = br.readLine()) != null) {
        for(int i=0;i<line.length();i++){
          data+=line.charAt(i);
        }
      }
    }
    catch(FileNotFoundException fN) {//error handleing
      fN.printStackTrace();
     JOptionPane.showMessageDialog(null,"there is no key, THERE IS NO GOD");
    }
    catch(IOException e) {//error handleing
      System.out.println(e);
    }
    
    System.out.println(data.length());//prints the length of the string "data" for varification 
    String[] pixelIndex1=data.split(" ");//separates the numbers 
    int[] pixelIndex= new int[pixelIndex1.length];
    for( int i=0; i<pixelIndex1.length; i++){
      pixelIndex[i]=Integer.parseInt( pixelIndex1[i] );//places the numbers into an array and converts it to an integer from a string
    }
    for( int i=1; i<pixelIndex.length;i++){//sorts the position of the pixels by using the key as a guide to the postions of the original pixels. 
      int key = pixelIndex[i];
      int position= i;
      int valueTempred= 0;
      int valueTempblue=0;
      int valueTempgreen=0;
      int valueTempred2 = 0;
      int valueTempblue2 = 0;
      int valueTempgreen2 = 0;
      //uses bubble sort algorithem 
      while(position > 0 && pixelIndex[position-1] > key){
        pixelIndex[position] = pixelIndex[position-1];
        valueTempred = pixelArray[position].getRed();
        valueTempblue = pixelArray[position].getBlue();
        valueTempgreen = pixelArray[position].getGreen();
        valueTempred2 = pixelArray[position-1].getRed();
        valueTempblue2 = pixelArray[position-1].getBlue();
        valueTempgreen2 = pixelArray[position-1].getGreen();
        pixelArray[position].setRed(valueTempred2);
        pixelArray[position].setBlue(valueTempblue2);
        pixelArray[position].setGreen(valueTempgreen2);
        pixelArray[position-1].setRed(valueTempred);
        pixelArray[position-1].setBlue(valueTempblue);
        pixelArray[position-1].setGreen(valueTempgreen);
        position--;
      }
      pixelIndex[position] = key;
    }
    pictureObject.show();//shows the unscrambled picture
    pictureObject.write(filename);//rewrites the picture to save the unscrambled file
    try{
      BufferedWriter writer = new BufferedWriter(new FileWriter(keyname));// rewrites the key to match the new postion
      String key="";
      for(int i=0; i<pixelIndex.length;i++){
        key += pixelIndex[i];
        key += " ";
      }
      System.out.println(key);
      writer.write(key);
      writer.newLine();
      writer.close();
    }
    catch (Exception ex){//error handleing
      System.out.println("Error writing to " +filename);
    }
  }//END OF METHOD 
}//END OF Class
