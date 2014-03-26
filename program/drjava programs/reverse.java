import javax.swing.JOptionPane;
public class reverse
{
public static void main(String[] args)
{
  int num;
  String optstr;
  optstr=JOptionPane.showInputDialog(null,"Please input the number of Strings: ");
  num=Integer.parseInt(optstr);
  String[] array= new String[num];
  String reverse="";
  String yours="";
  for(int i=0;i<num;i++){
    array[i]=JOptionPane.showInputDialog("Please input string number "+(i+1)+".");
  }
  for(int i=0;i<num;i++){
     yours+=array[i]+"; ";
  }
  JOptionPane.showMessageDialog(null,"your stings were: \n"+yours);
  for(int j=0;j<array.length/2;j++){
    String temp=array[0];
    temp=array[j];
    array[j]=array[array.length-1-j];
    array[array.length-1-j]=temp;
  }
  
  for(int i=0;i<num;i++){
     reverse+= array[i]+"; ";
  }
  JOptionPane.showMessageDialog(null,"The reverse is:\n" +reverse);
}
}