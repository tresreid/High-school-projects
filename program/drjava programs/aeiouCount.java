import javax.swing.JOptionPane;
public class aeiouCount
{
public static void main(String[] args)
{
String str="";
str=JOptionPane.showInputDialog("Please input a sentence: ");
  int aCount=0;
  int eCount=0;
  int iCount=0;
  int oCount=0;
  int uCount=0;
  int nonCount=0;
  for(int i=0; i<str.length(); i++){
  if(str.substring(i,i+1).equals("a")||str.substring(i,i+1).equals("A")){ aCount++;}
  else if(str.substring(i,i+1).equals("e")||str.substring(i,i+1).equals("E")){  eCount++;}
  else if(str.substring(i,i+1).equals("i")||str.substring(i,i+1).equals("I")){  iCount++;}
  else if(str.substring(i,i+1).equals("o")||str.substring(i,i+1).equals("O")){  oCount++;}
  else if(str.substring(i,i+1).equals("u")||str.substring(i,i+1).equals("U")){  uCount++;}  
  else{nonCount++;}
}
JOptionPane.showMessageDialog(null,"there are: \n"+aCount+" letter a's \n"+eCount+" letter e's \n"+iCount+" letter i's \n"+oCount+" letter o's \n"+ uCount+" letter u's and\n"+nonCount+" other letters(including spaces)");
}
}