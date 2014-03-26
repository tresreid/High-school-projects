import java.util.ArrayList;
public class Item{
  int itemNumber;
  String name="";
  
  public int getItemNumber(){
    return itemNumber;
  }
  public String getName(){
    return name;
  }
  
  public void addToInventory(ArrayList<Potion> potions, ArrayList<ThrowableItem> throwables){
    switch(getItemNumber())
    {
      case 1: potions.get(0).setStock(potions.get(0).getStock()+5);break;
      case 2: potions.get(1).setStock(potions.get(1).getStock()+5);break;
      case 3: potions.get(2).setStock(potions.get(2).getStock()+5);break;
      case 4: throwables.get(0).setAmmo(throwables.get(0).getAmmo()+10);break;
      case 5: throwables.get(1).setAmmo(throwables.get(1).getAmmo()+10);break;
    }
  }
  
}
