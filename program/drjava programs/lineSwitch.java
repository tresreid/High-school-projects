import javax.swing.JOptionPane;
public class lineSwitch {
  public static void main(String[] arg){
String output="";
String input;
input=JOptionPane.showInputDialog("please input a sentence: ");

for(int i=0;i<input.length(); i++){
  output=input.charAt(i)+output;
  }
JOptionPane.showMessageDialog(null,"your input is: "+input);
JOptionPane.showMessageDialog(null,"the reverse is: "+output);
}
}