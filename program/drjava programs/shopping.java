import javax.swing.JOptionPane;
public class shopping
{
public static void main(String[] args)
{
  String thingy;
  String optstr;
  double gil;
  int qty;
  int again;
  int count;
  ShoppingCart tokiwa = new ShoppingCart();
  do{
  thingy=JOptionPane.showInputDialog(null,"Please place an item in the cart");
  optstr=JOptionPane.showInputDialog(null,"Please show the price of this item.");
  gil=Double.parseDouble(optstr);
  optstr=JOptionPane.showInputDialog(null,"Please show the quantity of this item.");
  qty=Integer.parseInt(optstr);
  tokiwa.addToCart(thingy,gil,qty);
  again=JOptionPane.showConfirmDialog(null,"Would you like to continue shopping?");
  }while(again==JOptionPane.YES_OPTION);
  JOptionPane.showMessageDialog(null,tokiwa);
  JOptionPane.showMessageDialog(null,"Thank You! Come Again.");
}
}