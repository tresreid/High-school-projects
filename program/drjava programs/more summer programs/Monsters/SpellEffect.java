/**
 * Auto Generated Java Class.
 */
public class SpellEffect extends EquipmentTemplate {
  
  public SpellEffect() { 
    super();
  }
  int revertTime;
  boolean standing;
  public int getRevertTime(){
    return revertTime; 
  }
  public boolean getStanding(){
    return standing;
  }
  public void setRevertTime(int revertTime){
    this.revertTime=revertTime; 
  }
  public void setStanding(boolean standing){
    this.standing=standing;
  }
  
    public void statusEffect( CreatureTemplate defendingCreature){
    defendingCreature.setAttack(defendingCreature.getAttack()+getAttack());
    defendingCreature.setDefense(defendingCreature.getDefense()+getDefense());
    defendingCreature.setMagicAttack(defendingCreature.getMagicAttack()+getMagicAttack());
    defendingCreature.setMagicDefense(defendingCreature.getMagicDefense()+getMagicDefense());
    defendingCreature.setRange(defendingCreature.getRange()+getRange());
    defendingCreature.setHealth(defendingCreature.getHealth()+getHealth());
    defendingCreature.setMana(defendingCreature.getMana()+getMana());
    defendingCreature.setSpecialGauge(defendingCreature.getSpecialGauge()+getSpecialGauge());
    defendingCreature.setMovementSpeed(defendingCreature.getMovementSpeed()+getMovementSpeed());
    defendingCreature.setAgility(defendingCreature.getAgility()+getAgility()); 
    defendingCreature.setHeight(defendingCreature.getHeight()+getHeight()); 
  }
  public void statusRevert( CreatureTemplate defendingCreature){
    defendingCreature.setAttack(defendingCreature.getAttack()-getAttack());
    defendingCreature.setDefense(defendingCreature.getDefense()-getDefense());
    defendingCreature.setMagicAttack(defendingCreature.getMagicAttack()-getMagicAttack());
    defendingCreature.setMagicDefense(defendingCreature.getMagicDefense()-getMagicDefense());
    defendingCreature.setRange(defendingCreature.getRange()-getRange());
    defendingCreature.setHealth(defendingCreature.getHealth()-getHealth());
    defendingCreature.setMana(defendingCreature.getMana()-getMana());
    defendingCreature.setSpecialGauge(defendingCreature.getSpecialGauge()-getSpecialGauge());
    defendingCreature.setMovementSpeed(defendingCreature.getMovementSpeed()-getMovementSpeed());
    defendingCreature.setAgility(defendingCreature.getAgility()-getAgility()); 
    defendingCreature.setHeight(defendingCreature.getHeight()-getHeight()); 
  }
  public void standingEffect( CreatureTemplate defendingCreature, SpellEffect spell){
    if(spell.getStanding()==true){
    defendingCreature.setHealth(defendingCreature.getHealth()+spell.getHealth());
    defendingCreature.setMana(defendingCreature.getMana()+spell.getMana());
    defendingCreature.setAttack(defendingCreature.getAttack()+spell.getAttack());
    defendingCreature.setDefense(defendingCreature.getDefense()+spell.getDefense());
    defendingCreature.setMagicAttack(defendingCreature.getMagicAttack()+spell.getMagicAttack());
    defendingCreature.setMagicDefense(defendingCreature.getMagicDefense()+spell.getMagicDefense());
    defendingCreature.setRange(defendingCreature.getRange()+spell.getRange());
    defendingCreature.setHealth(defendingCreature.getHealth()+spell.getHealth());
    defendingCreature.setMana(defendingCreature.getMana()+spell.getMana());
    defendingCreature.setSpecialGauge(defendingCreature.getSpecialGauge()+spell.getSpecialGauge());
    defendingCreature.setMovementSpeed(defendingCreature.getMovementSpeed()+spell.getMovementSpeed());
    defendingCreature.setAgility(defendingCreature.getAgility()+spell.getAgility()); 
    defendingCreature.setHeight(defendingCreature.getHeight()+spell.getHeight()); 
    }
  }
      
}
/*
 * USED BY
 * Frozen
 * Poison
 */