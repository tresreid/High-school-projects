/**
 * Auto Generated Java Class.
 */
import java.util.ArrayList;
import java.util.Random; 
public class CreatureTemplate {
  
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
  String name="";
  int level;
  double height;
  int ranged;
  int totalHealth;
  int totalMana;
  int exp;
  String attackType= "";
  String defenseType= "";
  ArrayList<Item> drops = new ArrayList<Item>();
  int[] dropRate = new int[10];
  Random gen = new Random();
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
  public String getName(){
    return name;
  }
  public int getLevel(){
    return level;
  }
  public double getHeight(){
    return height; 
  }
  public int getRanged(){
    return ranged; 
  }
  public int getTotalHealth(){
    return totalHealth;
  }
  public int getTotalMana(){
    return totalMana;
  }
  public int getExp(){
    return exp;
  }
  public String getAttackType(){
    return attackType;
  }
  public String getDefenseType(){
    return defenseType;
  }
//SETTERS
  public void setAttack(int attack){
    this.attack=attack;
  }
  
  public void setHealth(int health){
    this.health=health;
  }
  public void setMana(int mana){
    this.mana=mana;
  }
  public void setDefense(int defense){
    this.defense=defense;
  }
  public void setMagicAttack(int magicAttack){
    this.magicAttack=magicAttack;
  }
  public void setMagicDefense(int magicDefense){
    this.magicDefense=magicDefense;
  }
  public void setRange(int range){
    this.range=range;
  }
  public void setSpecialGauge(int specialGauge){
    this.specialGauge=specialGauge;
  }
  public void setMovementSpeed(int movementSpeed){
    this.movementSpeed= movementSpeed; 
  }
  public void setAgility(int agility){
    this.agility=agility;
  }
  public void setHeight(double height){
    this.height=height; 
  }
  public void setRanged(int ranged){
    this.ranged=ranged; 
  }
  public void setTotalHealth(int totalHealth){
    this.totalHealth=totalHealth;
  }
  public void setTotalMana(int totalMana){
    this.totalMana=totalMana;
  }
  public void setLevel(int level){
    this.level=level;
  }
  public void setExp(int exp){
    this.exp=exp;
  }
  public void setAttackType(String attackType){
    this.attackType=attackType;
  }
  public void setDefenseType(String defenseType){
    this.defenseType=defenseType;
  }
//public class FightSystem 
  
  
  public int attack(CreatureTemplate attackingCreature, CreatureTemplate defendingCreature){
      double damage=0;
    double hit = 0.5* gen.nextDouble();
    damage=((attackingCreature.getAttack()*20*hit) / defendingCreature.getDefense());
      double typeDamage=0;
      int critical = gen.nextInt(100);
    if(critical<75){System.out.println("regular attack");}
    else{damage=2*damage;System.out.println("critical attack");}
    switch(attackingCreature.getAttackType()){
      case "fire":
        if(defendingCreature.getDefenseType().equals("ice")){typeDamage=damage*.3;}
        else{typeDamage=damage*.1;}
        break;
      case "ice":
        if(defendingCreature.getDefenseType().equals("fire")){typeDamage=damage*.3;}
        else{typeDamage=damage*.1;}
        break;
      case "holy":
        if(defendingCreature.getDefenseType().equals("unholy")){typeDamage=damage*.3;}
        else{typeDamage=damage*.1;}
        break;
      case "unholy":
        if(defendingCreature.getDefenseType().equals("holy")){typeDamage=damage*.3;}
        else{typeDamage=damage*.1;}
          break;
      case "water":
        if(defendingCreature.getDefenseType().equals("electric")){typeDamage=damage*.3;}
        else{typeDamage=damage*.1;}
          break;
      case "electric":
        if(defendingCreature.getDefenseType().equals("water")){typeDamage=damage*.3;}
        else{typeDamage=damage*.1;}
          break;
    }
    System.out.println("no jelly damage");
    return (int)(damage+typeDamage);
  }
//  public int magicAttack(CreatureTemplate attackingCreature, CreatureTemplate defendingCreature){
//    if(attackingCreature.getMana()>=10){
//   damage=((attackingCreature.getMagicAttack()*2) / defendingCreature.getMagicDefense()); 
//   attackingCreature.setMana(attackingCreature.getMana()-10);
//   return damage;
//    }
//    else{System.out.println("Out of Mana");return 0;}
//  }
  public int shoot(CreatureTemplate attackingCreature, CreatureTemplate defendingCreature, EquipmentTemplate equipment){
    int damage;
    System.out.println(attackingCreature.getRanged());
    if(attackingCreature.getRanged()>= 1){
      if(equipment.getAmmo()>=1){
        damage= attack(attackingCreature, defendingCreature);
        equipment.setAmmo(equipment.getAmmo()-1); 
        System.out.println(equipment.getAmmo());
        return damage;
      }
      else{equipment.setAmmo(0); System.out.println("You are out of ammo! :o"); return 0;}
    }
    else{return 0;}
  }
  
  public void defend(CreatureTemplate defendingCreature){
    setDefense(defendingCreature.getDefense()*2); 
  }
  public void magicDefense(CreatureTemplate defendingCreature){
    setMagicDefense(defendingCreature.getMagicDefense()*2);
  }
  public boolean dodge(CreatureTemplate defendingCreature){
    Random gen = new Random();
    int dodge=gen.nextInt(100);
    System.out.println(dodge);
    boolean success;
    if(dodge<=defendingCreature.getAgility()*2){
      success= true;
    }
    else{
      success= false;
    }
    System.out.println(success);
    return success;
  }
  public void flee(){
    
  }
  public void levelUp(CreatureTemplate creature1){
    creature1.setLevel(creature1.getLevel()+1);
    creature1.setTotalHealth(creature1.getTotalHealth()+10);
    creature1.setTotalMana(creature1.getTotalMana()+10);
    creature1.setHealth(creature1.getTotalHealth());
    creature1.setMana(creature1.getTotalMana());
    switch (level % 5){
      case 1: creature1.setAttack(creature1.getAttack()+1);break;
      case 2: creature1.setDefense(creature1.getDefense()+1);break;
      case 3: creature1.setMagicAttack(creature1.getMagicAttack()+1);break;
      case 4: creature1.setMagicDefense(creature1.getMagicDefense()+1);break;
      case 0: creature1.setMovementSpeed(creature1.getMovementSpeed()+1);creature1.setAgility(creature1.getAgility()+1);break;
    }
  }
  
  
  public void drop(CreatureTemplate creature2, ArrayList<Potion> potions, ArrayList<ThrowableItem> throwables){
    for(int i=0;i<creature2.drops.size();i++){
      Random gen = new Random();
    int dropped=gen.nextInt(1000);
    if(dropped < creature2.dropRate[i]){
      creature2.drops.get(i).addToInventory(potions, throwables);
      System.out.println(creature2.getName()+" has dropped "+creature2.drops.get(i).getName());
    }
    }
  }
  
}
/*
 * USED BY:
 * Hero
 * Blob
 * Boar
 * Flyingtemplate
 */