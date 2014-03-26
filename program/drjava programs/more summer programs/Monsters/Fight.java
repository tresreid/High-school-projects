import java.util.ArrayList;
import javax.swing.*;
import java.math.*;
import java.applet.Applet;
import java.awt.*;
public class Fight extends Applet{
  
  
  // public  void run() { 
  
  int landDistance=100;
  int turn=0;
  int width, height;
  Inventory bag = new Inventory();
//  EquipmentTemplate equipment= new EquipmentTemplate();
//  EquipmentTemplate equipment1=new EquipmentTemplate();//sword
//  EquipmentTemplate equipment2=new EquipmentTemplate();//bow
//  EquipmentTemplate equipment3=new EquipmentTemplate();//sheild
//  EquipmentTemplate equipment4=new EquipmentTemplate();//armour
//  EquipmentTemplate equipment5=new EquipmentTemplate();//extra
  
//  ArrayList<EquipmentTemplate> equiped = new ArrayList<EquipmentTemplate>();
  ArrayList<CreatureTemplate> creatures = new ArrayList<CreatureTemplate>();//not sure if needed...
  
  CreatureTemplate creature1= new Hero();
  CreatureTemplate creature2= new CreatureTemplate();
  CreatureTemplate attackingCreature;
  CreatureTemplate defendingCreature;
  
  SpellEffect sEffect= new SpellEffect();
    ArrayList<SpellEffect> spellEffects1 = new ArrayList<SpellEffect>();
    ArrayList<SpellEffect> spellEffects2 = new ArrayList<SpellEffect>();
//    ArrayList<Potion> potions = new ArrayList<Potion>();
//    Potion potion1 = new HealthPotion();
//    Potion potion2 = new ManaPotion();
//    Potion potion3 = new SpeedPotion();
    
//    ArrayList<ThrowableItem> throwables = new ArrayList<ThrowableItem>();
//    ThrowableItem bomb = new Bomb();
//    ThrowableItem shuriken = new Shuriken();
    
    int battle=-1;
    JFrame frame = new JFrame();
    
    public void run(){
      frame.setSize(600,500);
      width=600;
      height=500;
      frame.setVisible(true);
      
//      equiped.add(0,equipment);equiped.add(1,equipment);equiped.add(2,equipment);equiped.add(3,equipment);equiped.add(4,equipment);
//    //  spellEffects1.add(0,sEffect);spellEffects2.add(0,sEffect); NOT SURE IF NEEDED<<<<<<<<<
//      potions.add(0,potion1); potions.add(1,potion2);potions.add(2,potion3);
//      throwables.add(0,bomb);throwables.add(1,shuriken);
      
      //public void start(){
      battle++;
      while(creature1.getHealth()>0 && (battle%3!=2)){// Moves between battles- continues until dead
        if(battle%3==0){creature2= new Blob();}
        else if(battle%3==1){creature2= new Boar();}
        painter();
        while(creature1.getHealth()>0 && creature2.getHealth()>0){ //moves between turns in a single battle
          turn++;
          int distanceTemp=0;
          double distance = Math.hypot(landDistance, (creature1.getHeight()-creature2.getHeight()));
          boolean yourturn=true;
          if(distance<=creature1.getRange()){
            if(yourturn==true){attackingCreature= creature1; defendingCreature=creature2;}
            else{attackingCreature= creature2; defendingCreature= creature1;}
            attackScreen(attackingCreature, defendingCreature, bag.equipment, bag.equipment1,bag.equipment2,bag.equipment3,bag.equipment4,bag.equipment5, bag.equiped, spellEffects2, sEffect, bag.throwables, bag.potions);
            painter();
          }
          else{
            if(landDistance<=0){landDistance=0;}
            else{distanceTemp-= creature1.getMovementSpeed(); }
          }
          
          if(distance<=creature2.getRange()){
            yourturn=false;
            if(yourturn==true){attackingCreature= creature1; defendingCreature=creature2;}
            else{attackingCreature= creature2; defendingCreature= creature1;}
            defenseScreen(attackingCreature, defendingCreature);
            painter();
          }
          else{
            if(landDistance<=0){landDistance=0;}
            else{distanceTemp-=creature2.getMovementSpeed();}
            landDistance+=distanceTemp;
          }
          for(int i=0; i<spellEffects1.size();i++){
            int rev = spellEffects1.get(i).getRevertTime();
            if(rev != 0 ){
              spellEffects1.get(i).setRevertTime(spellEffects1.get(i).getRevertTime()-1);
              spellEffects1.get(i).standingEffect(creature1, spellEffects1.get(i));
              spellEffects1.get(i).setRevertTime(rev-1);
            }
            else{
              spellEffects1.get(i).statusRevert(creature1);
              spellEffects1.remove(i);
              i--;
            }
            painter();
          }
          for(int i=0; i<spellEffects2.size();i++){
            int rev = spellEffects2.get(i).getRevertTime();
            if(rev != 0 ){
              spellEffects2.get(i).setRevertTime(spellEffects2.get(i).getRevertTime()-1);
              spellEffects2.get(i).standingEffect(creature2, spellEffects2.get(i));
              spellEffects2.get(i).setRevertTime(rev-1);
            }
            else{
              spellEffects2.get(i).statusRevert(creature2);
              spellEffects2.remove(i);
              i--;
            }
            painter();
          }
          System.out.println("Health 1: "+creature1.getHealth());
          System.out.println("Mana 1: "+creature1.getMana());
          System.out.println("Health 2: "+creature2.getHealth());
          System.out.println("Mana 2 "+creature2.getMana());
          painter();
        }
        
        
        if (creature1.getHealth()<=0 && creature2.getHealth()<=0){System.out.println("Both "+ creature1.getName() +" and "+ creature2.getName()+ " have died");}
        else if (creature1.getHealth()<=0){System.out.println(creature1.getName() + " has died");}
        else if (creature2.getHealth()<=0){System.out.println(creature2.getName() + " has died. You have gained "+creature2.getExp()+" exp!");}
        else{System.out.println("idk what happened");}
        creature2.drop(creature2, bag.potions, bag.throwables);
        creature1.setExp(creature1.getExp()+creature2.getExp());
        if(creature1.getExp()>75*Math.pow(1.1,creature1.getLevel())){
          creature1.levelUp(creature1);
          System.out.println("You have leveled up!");
        }
        battle++;
      }
      frame.setVisible(false);
    }
    
    /*
     * METHODS
     * 
     */
    //ATTACK SCREEN
    public static void attackScreen(CreatureTemplate attackingCreature, CreatureTemplate defendingCreature, 
                                    EquipmentTemplate equipment, EquipmentTemplate equipment1,EquipmentTemplate equipment2,
                                    EquipmentTemplate equipment3,EquipmentTemplate equipment4,EquipmentTemplate equipment5,
                                    ArrayList<EquipmentTemplate> equiped, ArrayList<SpellEffect> spellEffects2, SpellEffect sEffect,
                                    ArrayList<ThrowableItem> throwables, ArrayList<Potion> potions)
    {
      
      String[] opts = {"Attack", "Shoot", "Magic Attack", "Item", "Flee","Equip"};
      int actionA = JOptionPane.showOptionDialog (null, "Choose an Action", "YOUR TURN!!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opts, opts[2]);
      
      if (actionA==0){defendingCreature.setHealth(defendingCreature.getHealth()- attackingCreature.attack(attackingCreature, defendingCreature));}
      else if (actionA==1){defendingCreature.setHealth(defendingCreature.getHealth()- attackingCreature.shoot(attackingCreature, defendingCreature, equiped.get(1)));}
      else if (actionA==2){
        MagicSpells spell;
        String[] spellList = {"Fireball", "Ice Breath","Snake Bite"};
        int sp = JOptionPane.showOptionDialog (null, "Choose a Spell!", "YOUR TURN!!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, spellList, spellList[0]);
        if(sp==0){
          spell = new Fireball();
          defendingCreature.setHealth(defendingCreature.getHealth()-spell.cast(attackingCreature, defendingCreature, spell));
        }
        else if(sp==1){
          spell = new IceBreath();
          defendingCreature.setHealth(defendingCreature.getHealth()-spell.cast(attackingCreature, defendingCreature, spell));
          sEffect= new Frozen();
          spellEffects2.add(sEffect);
          sEffect.statusEffect(defendingCreature);
        }
        else if(sp==2){
          spell = new SnakeBite();
          defendingCreature.setHealth(defendingCreature.getHealth()-spell.cast(attackingCreature, defendingCreature, spell));
          sEffect= new Poison();
          spellEffects2.add(sEffect);
          sEffect.statusEffect(defendingCreature);
        }
      }
      else if (actionA==3){
        String[] itemORthowableList = {"Potion", "Throwable Item"};
        int itemORthowable = JOptionPane.showOptionDialog (null, "Choose an Item", "Inventory!!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, itemORthowableList, itemORthowableList[0]);
        if(itemORthowable==0){
          String[] itemList = {"Health Potion", "Mana Potion", "Speed Potion"};
          int items = JOptionPane.showOptionDialog (null, "Choose an Item", "Inventory!!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, itemList, itemList[0]);
          if(items==0){
            potions.get(0).useHeal(attackingCreature);
          }
          else if (items==1){
            potions.get(1).useManaHeal(attackingCreature);
          }
          else if (items==2){
            potions.get(2).useSpeedBuff(attackingCreature);
          }
        }
        else if(itemORthowable==1){
          String[] itemList = {"Bomb", "Shuriken"};
          int items = JOptionPane.showOptionDialog (null, "Choose an Item to throw!", "Inventory!!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, itemList, itemList[0]);
          if(items==0){
            throwables.get(0).toss(defendingCreature);
          }
          else if(items==1){
            throwables.get(1).toss(defendingCreature);
          }
          
        }
      }
      else if (actionA==4){System.out.println("You have attempted to flee. There is no escape! :o");}
      
      else if(actionA==5){
        String[] equip = {"Equip", "Unequip"};
        int eq = JOptionPane.showOptionDialog (null, "Would you like to equip or unequip an item?", "Inventory!!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, equip, equip[0]);
        if(eq==0){    
          String[] equipmentList = {"Sword", "Bow", "Shield", "Armor"};
          int items = JOptionPane.showOptionDialog (null, "Choose an Item to equip", "Inventory!!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, equipmentList, equipmentList[0]);
          if(items==0){
            if(equiped.get(0).getEquipped()==false){
              equipment1= new WeaponTemplate();
              equiped.set(0, equipment1);
              equipment1.equip(attackingCreature);
              System.out.println(equiped.get(0).getName());
              equipment1.setEquipped(true);
            }
            else{System.out.println("this item is already equipped! :o");}
          }
          else if(items==1){
            if(equiped.get(1).getEquipped()==false){
              equipment2= new RangedWeapon(equipment);    
              equiped.set(1, equipment2);
              equipment2.equip(attackingCreature);
              equipment2.setEquipped(true);
            }
            else{System.out.println("this item is already equipped! :o");}
          }
          else if(items==2){
            if(equiped.get(2).getEquipped()==false){
              equipment3= new ShieldTemplate();
              equiped.set(2, equipment3);
              equipment3.equip(attackingCreature);
              equipment3.setEquipped(true);
            }
            else{System.out.println("this item is already equipped! :o");}
          }
          else if (items==3){
            if(equiped.get(3).getEquipped()==false){
              equipment4= new ArmorTemplate();
              equiped.set(3, equipment4);
              equipment4.equip(attackingCreature);
              equipment4.setEquipped(true);
            }
            else{System.out.println("this item is already equipped! :o");}
          }
        }
        else if(eq==1){
          String[] equipmentList = {"Sword", "Bow", "Shield", "Armor"};
          int items = JOptionPane.showOptionDialog (null, "Choose an Item to equip", "Inventory!!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, equipmentList, equipmentList[0]);
          if(items==0){
            if(equiped.get(0).getEquipped()==true){
              equipment1.unequip(attackingCreature, equiped.get(0));
              equiped.set(0, equipment);
              equipment1.setEquipped(false);
              System.out.println("You have unequipped " +equiped.get(0).getName());
            }
            else{System.out.println("There is nothing equipped! :o");}
          }
        else if(items==1){
          if(equiped.get(1).getEquipped()==true){
            equipment2.unequip(attackingCreature, equiped.get(1));
            equiped.set(1, equipment);
            equipment2.setEquipped(false);
            System.out.println("You have unequipped " +equiped.get(1).getName());
          }
          else{System.out.println("There is nothing equipped! :o");}
        }
        else if(items==2){
          if(equiped.get(2).getEquipped()==true){
            equipment3.unequip(attackingCreature,equiped.get(2));
            equiped.set(2, equipment);
            equipment3.setEquipped(false);
            System.out.println("You have unequipped " +equiped.get(2).getName());
          }
          else{System.out.println("There is nothing equipped! :o");}
        }
        else if (items==3){
          if(equiped.get(3).getEquipped()==true){
            equipment4.unequip(attackingCreature,equiped.get(3));
            equiped.set(3, equipment);
            equipment4.setEquipped(false);
            System.out.println("You have unequipped " +equiped.get(3).getName());
          }
          else{System.out.println("There is nothing equipped! :o");}
        }
        
        }
      }
      
    }//END ATTACK SCREEN
    // DEFENSE SCREEN
    
    public static void defenseScreen(CreatureTemplate attackingCreature, CreatureTemplate defendingCreature){
      String[] opts = {"Defend", "Magic Defend", "Dodge", "flee"};
      int actionA = JOptionPane.showOptionDialog (null, "Choose an Action", "THEIR TURN!!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opts, opts[2]);
      
      if (actionA==0){
        int defensetemp=defendingCreature.getDefense();
        defendingCreature.defend(defendingCreature);
        defendingCreature.setHealth(defendingCreature.getHealth()-attackingCreature.attack(attackingCreature, defendingCreature));
        defendingCreature.setDefense(defensetemp);
      }
      else if (actionA==1){
      int magicdefensetemp=defendingCreature.getMagicDefense();
      defendingCreature.magicDefense(defendingCreature);
      defendingCreature.setHealth(defendingCreature.getHealth()-((attackingCreature.attack(attackingCreature, defendingCreature))));
      defendingCreature.setMagicDefense(magicdefensetemp);}
      else if (actionA==2){
        if(defendingCreature.dodge(defendingCreature)==false){
          defendingCreature.setHealth(defendingCreature.getHealth()-((attackingCreature.attack(attackingCreature, defendingCreature))));
          System.out.println("You tried to dodge. You were too slow! :o");}
        else{      
          System.out.println("You have dodged! How nimble you are!!");}
      }
      else if (actionA==3){
        System.out.println("You have attempted to flee. There is no escape! :o");
      }
      
    }//END DEFENSE SCREEN
    
    //PAINT
    public void painter(){
      frame.add(new JPanel(){
        public void paintComponent( Graphics g ) {
          super.paintComponent(g);
          System.out.println("painter()");
          g.setColor(Color.black);
          g.drawLine( 0, 0, width, 0);
          g.drawLine( 0, 0, 0, height);
          g.drawLine( 0, height, width, height );
          g.drawLine( width , 0, width, height );
          
          g.setColor( Color.green );
          g.drawLine( 0, height/6, (width/2)-((creature1.getTotalHealth()-creature1.getHealth())*((width/2))/creature1.getTotalHealth()), height/6 );
          g.setColor(Color.red);
          g.drawLine( width, height/6, (width / 2)+((creature2.getTotalHealth()-creature2.getHealth())*((width/2))/creature2.getTotalHealth()), height/6 );
          g.setColor(Color.black);
          g.drawString( "Health 1: "+creature1.getHealth() +"/"+creature1.getTotalHealth(), width/99, height/6 );
          g.drawString("health 2: "+creature2.getHealth()+"/"+creature2.getTotalHealth(), 75*width/99, height/6);
          
          g.setColor( Color.blue );
          g.drawLine( 0, 5*height/24, (width/2)-((creature1.getTotalMana()-creature1.getMana())*((width/2))/creature1.getTotalMana()), 5*height/24 );
          g.setColor(Color.magenta);
          g.drawLine( width, 5*height/24, (width / 2)+((creature2.getTotalMana()-creature2.getMana())*((width/2))/creature2.getTotalMana()), 5*height/24 );
          g.setColor(Color.black);
          g.drawString( "Mana 1: "+creature1.getMana() +"/"+creature1.getTotalMana(), width/99, 5*height/24 );
          g.drawString("Mana 2: "+creature2.getMana()+"/"+creature2.getTotalMana(), 75*width/99, 5*height/24);
        } 
      });//end frame
      frame.setVisible(true);
    }
    
    
}//END OF MAIN METHOD
