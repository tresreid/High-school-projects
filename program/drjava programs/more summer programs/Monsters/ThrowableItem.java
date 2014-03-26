/**
 * Auto Generated Java Class.
 */
public class ThrowableItem extends EquipmentTemplate {
  
  public ThrowableItem() { 
    super();
  }
  int ammo;
  public int getAmmo(){
    return ammo;
  }
  public void setAmmo (int ammo){
    this.ammo=ammo;
  }
  public void toss( CreatureTemplate defendingCreature){
    if(ammo>0){
      defendingCreature.setHealth(defendingCreature.getHealth()-((getAttack()*2) / defendingCreature.getDefense()));
      ammo--;
    }
    else{
      ammo=0; System.out.println("you are out of ammo! :o");
    }
  }
  
}
/*
 * USED BY
 * Bomb
 * Shuriken
 */