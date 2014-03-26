/**
 * Auto Generated Java Class.
 */
public class EquipmentTemplate extends Item{
  
  int attack;
  int defense;
  int magicAttack;
  int magicDefense;
  int range;
  int health;
  int mana;
  int specialGauge;
  int movementSpeed;
  int agility;
 // String name="";
  int level;
  double height;
  boolean equipped= false;
  int ranged;
  int ammo;
  String attackType ="";
  String defenseType= "";
  
  
//GETTERS
  public int getAttack(){
    return attack;
  }
  public int getDefense(){
    return defense;
  }
  public int getMagicAttack(){
    return magicAttack;
  }
  public int getMagicDefense(){
    return magicDefense;
  }
  public int getRange(){
    return range;
  }
  public int getHealth(){
    return health;
  }
  public int getMana(){
    return mana;
  }
  public int getSpecialGauge(){
    return specialGauge;
  }
  public int getMovementSpeed(){
    return movementSpeed;
  }
  public int getAgility(){
    return agility;
  }
//  public String getName(){
//    return name;
//  }
  public int getLevel(){
    return level;
  }
  public double getHeight(){
    return height; 
  }
  public int getRanged(){
    return ranged; 
  }
  public int getAmmo(){
    return ammo; 
  }
  public boolean getEquipped(){
    return equipped; 
  }
  public String getAttackType(){
    return attackType;
  }
  public String getDefenseType(){
    return defenseType;
  }
  //SETTERS
  public void setAmmo(int ammo){
    this.ammo=ammo; 
  }
  public void setRanged(int ranged){
    this.ranged=ranged; 
  }
  public void setEquipped(boolean equipped){
    this.equipped=equipped; 
  }
//Users
  public void equip(CreatureTemplate attackingCreature){
    if(attackingCreature.getLevel()< getLevel()){System.out.println("You are not experianced enough to Equip this item! :o");}
    else{
      attackingCreature.setAttack(attackingCreature.getAttack()+getAttack());
      attackingCreature.setDefense(attackingCreature.getDefense()+getDefense());
      attackingCreature.setMagicAttack(attackingCreature.getMagicAttack()+getMagicAttack());
      attackingCreature.setMagicDefense(attackingCreature.getMagicDefense()+getMagicDefense());
      attackingCreature.setRange(attackingCreature.getRange()+getRange());
      attackingCreature.setHealth(attackingCreature.getHealth()+getHealth());
      attackingCreature.setMana(attackingCreature.getMana()+getMana());
      attackingCreature.setSpecialGauge(attackingCreature.getSpecialGauge()+getSpecialGauge());
      attackingCreature.setMovementSpeed(attackingCreature.getMovementSpeed()+getMovementSpeed());
      attackingCreature.setAgility(attackingCreature.getAgility()+getAgility());
      attackingCreature.setHeight(attackingCreature.getHeight()+getHeight());
      attackingCreature.setRanged(attackingCreature.getRanged()+getRanged());
      attackingCreature.setAttackType(getAttackType());
      attackingCreature.setDefenseType(getDefenseType());
      System.out.println("You have equipped " +getName());
    }
  }
  
  public void unequip(CreatureTemplate attackingCreature, EquipmentTemplate equipment){
    if(equipment.getEquipped()==true){
      attackingCreature.setAttack(attackingCreature.getAttack()-equipment.getAttack());
      attackingCreature.setDefense(attackingCreature.getDefense()-equipment.getDefense());
      attackingCreature.setMagicAttack(attackingCreature.getMagicAttack()-equipment.getMagicAttack());
      attackingCreature.setMagicDefense(attackingCreature.getMagicDefense()-equipment.getMagicDefense());
      attackingCreature.setRange(attackingCreature.getRange()-equipment.getRange());
      attackingCreature.setHealth(attackingCreature.getHealth()-equipment.getHealth());
      attackingCreature.setMana(attackingCreature.getMana()-equipment.getMana());
      attackingCreature.setSpecialGauge(attackingCreature.getSpecialGauge()-equipment.getSpecialGauge());
      attackingCreature.setMovementSpeed(attackingCreature.getMovementSpeed()-equipment.getMovementSpeed());
      attackingCreature.setAgility(attackingCreature.getAgility()-equipment.getAgility());
      attackingCreature.setHeight(attackingCreature.getHeight()-equipment.getHeight());
      attackingCreature.setRanged(attackingCreature.getRanged()-equipment.getRanged());
      attackingCreature.setAttackType("");
      attackingCreature.setDefenseType("");
      System.out.println("You have unequipped " +equipment.getName());
    }
    else{System.out.println("This item is not equipped");}
  }
  
  
}
/*
 * USED BY:
 * ArmorTemplate
 * ShieldTemplate
 * WeaponTemplate
 * RangedWeapon
 * ThrowableItem
 * MagicSpells
 */ 