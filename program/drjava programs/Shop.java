// ***************************************************************
// Shop.java
//
// Uses the Item class to create items and add them to a shopping
// cart stored in an ArrayList.
// ***************************************************************
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Shop
{
public static void main (String[] args)
{
Item item;
String itemName;
double itemPrice;
int quantity;
int total=0;
int again;
ArrayList<Item> cart=new ArrayList<Item>();
String optstr;
String contents="Item Name\tQuantity\tItem Price\tTotal\n";
do
{
itemName=JOptionPane.showInputDialog(null,"Enter the name of the item: ");

optstr=JOptionPane.showInputDialog(null,"Enter the unit price: ");
itemPrice=Double.parseDouble(optstr);
optstr=JOptionPane.showInputDialog(null,"Enter the quantity: ");
quantity=Integer.parseInt(optstr);
// *** create a new item and add it to the cart
item= new Item(itemName, itemPrice, quantity);
item.toString();
cart.add(item);
// *** print the contents of the cart object using println
again=JOptionPane.showConfirmDialog(null,"Continue shopping (y/n)? ");
}
while (again==JOptionPane.YES_OPTION);
for(int i=0;i<cart.size();i++){
  contents+=cart.get(i)+"\n";
  total+=item.getPrice()*item.getQuantity();
}
JOptionPane.showMessageDialog(null,contents);
JOptionPane.showMessageDialog(null,"The total is: "+total);
}
}