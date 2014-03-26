/**
 * Auto Generated Java Class.
 */
public class MagicSpells extends EquipmentTemplate {
  
  public MagicSpells() { 
    super();
  }
  int potence;
  int manaCost;
//  int revertTime;
  // boolean effect;
  public int getPotence(){
    return potence; 
  }
  public int getManaCost(){
    return manaCost; 
  }
//  public int revertTime(){
//   return revertTime; 
//  }
//  
  public void setPotence(int potence){
    this.potence = potence;
  }
  public void setManaCost(int manaCost){
    this.manaCost=manaCost; 
  }
//  public void setRevertTime(int revertTime){
//   this.revertTime=revertTime; 
//  }
  public int cast(CreatureTemplate attackingCreature, CreatureTemplate defendingCreature, MagicSpells spell){
    int damage;
    if(attackingCreature.getMana()>=spell.getManaCost()){
      damage=((attackingCreature.getMagicAttack()* spell.getPotence()) / defendingCreature.getMagicDefense()); 
      attackingCreature.setMana(attackingCreature.getMana()-spell.getManaCost());
      //  statusEffect(defendingCreature);
      return damage;
    }
    else{System.out.println("Out of Mana");return 0;}
  }
  
  
}
/*
 * USED BY
 * FireBall
 * IceBreath
 * SnakeBite
 */