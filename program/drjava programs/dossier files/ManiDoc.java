import java.io.*;

public class ManiDoc
{
    private FileChooser testdoc = new FileChooser();
    private String filename=testdoc.pickAFile();
    public ManiDoc(){
    }
    // Start of Scramble method
  public void scramble()
  {
    System.out.println(filename);//prints the filename for varification. 
    String line = null;
    String morewords= "";
    try{
      BufferedReader reader = new BufferedReader(new FileReader(filename));//reads the text file
      while((line = reader.readLine()) != null)//continues reading each line, one at a time.
      {
        char[] words = new char[line.length()];// makes an empty array of characters the size of the length of the characters in the text file.
        for(int i=0;i<line.length(); i++)// this loop places every character in the text file into a postion in the array
        {
          words[i]= line.charAt(i);
        }
        System.out.println(words);// prints the contents of the array for varification purposes

        for(int j=0; j<line.length(); j++)
        {
          switch (words[j])// scrambles the contents by using simple replacement for each character. 
          {
            case ' ': morewords+=" "; break;
            case 'a': morewords+="asdfg";break; 
            case 'b': morewords+="bnmzx";break; 
            case 'c': morewords+="cvbnm";break; 
            case 'd': morewords+="dfghj";break; 
            case 'e': morewords+="ertyu";break; 
            case 'f': morewords+="fghjk";break; 
            case 'g': morewords+="ghjkl";break; 
            case 'h': morewords+="hjkla";break;
            case 'i': morewords+="iopqw";break; 
            case 'j': morewords+="jklas";break; 
            case 'k': morewords+="klasd";break; 
            case 'l': morewords+="lasdf";break; 
            case 'm': morewords+="mzxcv";break; 
            case 'n': morewords+="nmzxc";break; 
            case 'o': morewords+="opqwe";break; 
            case 'p': morewords+="pqwer";break; 
            case 'q': morewords+="qwert";break; 
            case 'r': morewords+="rtyui";break; 
            case 's': morewords+="sdfgh";break; 
            case 't': morewords+="tyuio";break; 
            case 'u': morewords+="uiopq";break; 
            case 'v': morewords+="vbnmz";break; 
            case 'w': morewords+="werty";break; 
            case 'x': morewords+="xcvbn";break; 
            case 'y': morewords+="yuiop";break; 
            case 'z': morewords+="zxcvb";break; 
            case 'A': morewords+="ASDFG";break; 
            case 'B': morewords+="BNMZX";break; 
            case 'C': morewords+="CVBNM";break;
            case 'D': morewords+="DFGHJ";break; 
            case 'E': morewords+="ERTYU";break; 
            case 'F': morewords+="FGHJK";break; 
            case 'G': morewords+="GHJKL";break; 
            case 'H': morewords+="HJKLA";break;
            case 'I': morewords+="IOPQW";break; 
            case 'J': morewords+="JKLAS";break; 
            case 'K': morewords+="KLASD";break; 
            case 'L': morewords+="LASDF";break; 
            case 'M': morewords+="MZXCV";break; 
            case 'N': morewords+="NMZXC";break; 
            case 'O': morewords+="OPQWE";break; 
            case 'P': morewords+="PQWER";break; 
            case 'Q': morewords+="QWERT";break; 
            case 'R': morewords+="RTYUI";break; 
            case 'S': morewords+="SDFGH";break; 
            case 'T': morewords+="TYUIO";break; 
            case 'U': morewords+="UIOPQ";break; 
            case 'V': morewords+="VBNMZ";break; 
            case 'W': morewords+="WERTY";break; 
            case 'X': morewords+="XCVBN";break; 
            case 'Y': morewords+="YUIOP";break;
            case 'Z': morewords+="ZXCVB";break; 
            case '.': morewords+="./,<>";break; 
            case ',': morewords+=",./<>";break;
            case '/': morewords+="/,.<>";break; 
            case '<': morewords+="<>?,.";break;
            case '>': morewords+=">?<,.";break;
            case '?': morewords+="?<>,.";break;
            case ';': morewords+=";':[]";break;
            case ':': morewords+=":;'[]";break;
            case '\'': morewords+="';:[]";break;
            case '[': morewords+="[]{}|";break;
            case ']': morewords+="][{}|";break;
            case '{': morewords+="{}|[]";break;
            case '}': morewords+="}|{[]";break;
            case '|': morewords+="|{}[]";break;
            case '!': morewords+="!@#$%";break;
            case '@': morewords+="@#$%^";break;
            case '#': morewords+="#$%^&";break;
            case '$': morewords+="$%^&*";break;
            case '%': morewords+="%^&*(";break;
            case '^': morewords+="^&*()";break;
            case '&': morewords+="&*()!";break;
            case '*': morewords+="*()!@";break;
            case '(': morewords+="()!@#";break;
            case ')': morewords+=")!@#$";break;
            
          } // ends switch
            morewords+= "\n";
        } // ends loop over words
      }//ends the while loop
      reader.close();
    }
    catch(Exception ex){//error handleing 
      SimpleOutput.showError("Error reading file "+ filename);
      ex.printStackTrace();
    }
    try{
      BufferedWriter writer = new BufferedWriter(new FileWriter(filename));// overwrites the file with the scrambled contents. 
      writer.write(morewords);
      writer.close();
      System.out.println(morewords);//prints the contents of morewords for varification 
    }
    catch (Exception ex){//error handleing
      System.out.println("Error writing to " +filename);
    }       
  }// ends the Scramble method.
  
  // START OF THE UNSCRAMBLE METHOD 
  public void unscramble()
  {
    System.out.println(filename);
    String line = null;
    String morewords= "";
    try{
      BufferedReader reader = new BufferedReader(new FileReader(filename));//reads the file
      while((line = reader.readLine()) != null)
      {
        char[] words = new char[line.length()];
        for(int i=0;i<line.length(); i++)// sets the positions in the array with the characters in the file. 
        {
          words[i]= line.charAt(i);
        }
        System.out.println(words);
        for(int j=0; j<line.length(); j+=5)
        {
          morewords+= String.valueOf(words[j]); //decodes the scrambled message using a secret pattern
        } // ends loop over words
      }
      reader.close();
    }
    catch(Exception ex){//error handleing
      SimpleOutput.showError("Error reading file "+ filename);
      ex.printStackTrace();
    }
    try{
      BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
      writer.write(morewords);
      writer.close();
      System.out.println(morewords);//prints morewords for varification
    }
    catch (Exception ex){
      System.out.println("Error writing to " +filename);
    }
  }//Ends the Unscramble method
}//ends the class