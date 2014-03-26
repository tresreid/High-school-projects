import javax.swing.*;
public class Dossier
{
  public static void main(String[] arg)// main method
  {
    int continueon;// for the dialog box to continue running the program
    do{
int mc = JOptionPane.QUESTION_MESSAGE;
String[] opts = {"Picture files", "Audio Files", "Document files"};//opts for options to choose from.
int ch = JOptionPane.showOptionDialog (null, "Choose", "Title", JOptionPane.YES_NO_CANCEL_OPTION, mc, null, opts, opts[2]);// gives a dialog box to choose an option from
// the three choices
if(ch==JOptionPane.YES_OPTION){
  Manipic picture = new Manipic();// makes a picture class to scramble or unscramble
 String[] opts1= {"Scramble", "UnScramble"};// two options
    int n = JOptionPane.showOptionDialog(null,"Would you like to Scamble or Unscramble a file? ",
    "Scramble choice", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opts1,opts1[1]);// dialog box to give a scramble/unscramble option for the user
    if(n==JOptionPane.YES_OPTION){ picture.scramble();}//scrambles the file
    else if(n==JOptionPane.NO_OPTION){ picture.unscramble();}//unscrambles the file
    else{ JOptionPane.showMessageDialog(null,"Woops, error");}// simple error handling
  }
if(ch==JOptionPane.NO_OPTION){   
  JOptionPane.showMessageDialog(null,"sorry this option is currently unavailible.");
  //this code has been commented out because it serves no purpose for the dossier as its success cannot be documented
//  ManiAudi audio = new ManiAudi();  
//   String[] opts1= {"Scramble", "UnScramble"};
//    int n = JOptionPane.showOptionDialog(null,"Would you like to Scamble or Unscramble a file? ",
//    "Scramble choice", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opts1,opts1[1]);
//    if(n==JOptionPane.YES_OPTION){ audio.scramble();}
//    else if(n==JOptionPane.NO_OPTION){ audio.unscramble();}
//    else{ JOptionPane.showMessageDialog(null,"Woops, error");}// simple error handling
}
if(ch==JOptionPane.CANCEL_OPTION){
   ManiDoc reader = new ManiDoc();// makes a document class to scramble or unscramble
   String[] opts1= {"Scramble", "UnScramble"};//two options
    int n = JOptionPane.showOptionDialog(null,"Would you like to Scamble or Unscramble a file? ",
    "Scramble choice", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,opts1,opts1[1]);//// dialog box to give a scramble/unscramble option for the user
    if(n==JOptionPane.YES_OPTION){ reader.scramble();}//scrambles the file
    else if(n==JOptionPane.NO_OPTION){ reader.unscramble();}// unscrambles the file
    else{ JOptionPane.showMessageDialog(null,"Woops, error");}// simple error handling
}
String[] stay= {"yes","no"};//options to continue the program
continueon = JOptionPane.showOptionDialog (null,"Would you like to continue?", "Title", JOptionPane.YES_NO_OPTION,mc, null,stay, stay[1]);//dialog boz to continue running the program
    }while(continueon==JOptionPane.YES_OPTION);//loops if needed.
}
}