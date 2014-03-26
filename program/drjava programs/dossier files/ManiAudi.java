import java.util.Random; 
import java.io.*;
public class ManiAudi
{
    private FileChooser testsound = new FileChooser();
    private String filename=testsound.pickAFile();
    private String keyname= filename + " key.txt";
    private String filenamex;
   //private Sound sound = new Sound(filename);
   //Sound.convert();
    public ManiAudi(){
   //Sound sound = new Sound(filename);
   Sound.convert(filename, filenamex);
    }
        private Sound sound = new Sound(filenamex);
    public void scramble(){
      sound.play();
      //SoundSample[] soundarray = sound.getSamples();
      int length = sound.getLength();
      int[] soundarray= new int[length];
      for(int i=0; i<length;i++){
        soundarray[i]=i;
      }
      Random gen= new Random();
      //loop through the samples.
      for(int index=0; index<length; index++){
        int temp;
        int temps;
        int ran=gen.nextInt(length);
       // sound.setSampleValueAt(ran, sound.getSampleValueAt(index));
        temps = sound.getSampleValueAt(index);
        sound.setSampleValueAt(index, sound.getSampleValueAt(ran));
        sound.setSampleValueAt(ran, sound.getSampleValueAt(temps));
        temp=soundarray[index];
        soundarray[index]=soundarray[ran];
        soundarray[ran]=temp;
      }
try{
      BufferedWriter writer = new BufferedWriter(new FileWriter(keyname));

      String key="";
      for(int i=0; i<soundarray.length;i++){
        key += soundarray[i];
        key += " ";
      }
      System.out.println(key);
      writer.write(key);
      writer.newLine();
      writer.close();
    }
    catch (Exception ex){
      System.out.println("Error writing to " +filename);
      }
    }
    //*******************************************************UN*********
    public void unscramble(){
      int length = sound.getLength();
      int[] soundarray= new int[length];
      String line = "";
  String data = "";
  try {
   FileReader fr = new FileReader(keyname);
   BufferedReader br = new BufferedReader(fr);
   while((line = br.readLine()) != null) {
     for(int i=0;i<line.length();i++){
    data+=line.charAt(i);
     }
   }

  }
  catch(FileNotFoundException fN) {
   fN.printStackTrace();
  }
  catch(IOException e) {
   System.out.println(e);
  }
  System.out.println(data.length());
    String[] pixelIndex1=data.split(" ");
        int[] pixelIndex= new int[pixelIndex1.length];
    for( int i=0; i<pixelIndex1.length; i++){
      soundarray[i]=Integer.parseInt( pixelIndex1[i] );
    }
    for( int i=1; i< soundarray.length;i++){
      int key =  soundarray[i];
      int position= i;
      int temps;
       while(position > 0 &&  soundarray[position-1] > key){
       soundarray[position] =  soundarray[position-1];
       //sound.setSampleValueAT(position-1, sound.getSampleValueAt(position));
        temps = sound.getSampleValueAt(position);
        sound.setSampleValueAt(position, sound.getSampleValueAt(position-1));
        sound.setSampleValueAt(position-1, sound.getSampleValueAt(temps));
         position--;
      }
      pixelIndex[position] = key;
       }
    }
}