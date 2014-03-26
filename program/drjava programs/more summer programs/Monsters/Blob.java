/**
 * Auto Generated Java Class.
 */
public class Blob extends CreatureTemplate {
  
  public Blob() { 
    super();
    this.attack=10;
    this.defense=10;
    this.magicAttack=5;
    this.magicDefense=5;
    this.range=10;
    this.health=100;
    this.mana=100;
    this.specialGauge=0;
    this.movementSpeed=5;
    this.agility=10;
    this.name="Slime blob";
    this.level=1;
    this.height=0;
    this.totalHealth=100;
    this.totalMana=100;
    this.exp=5;
    
    
    HealthPotion potion1 = new HealthPotion();
    ManaPotion potion2 = new ManaPotion();
    SpeedPotion potion3 = new SpeedPotion();
    this.drops.add(potion1);
    this.dropRate[0]=100;
    this.drops.add(potion2);
    this.dropRate[1]=50;
    this.drops.add(potion3);
    this.dropRate[2]=25;
  }
  /* ADD YOUR CODE HERE */
  public int attack(CreatureTemplate attackingCreature, CreatureTemplate defendingCreature){
    double damage=0;
    double hit = 0.5* gen.nextDouble();
    damage=((attackingCreature.getAttack()*20*hit) / defendingCreature.getDefense());
    double typeDamage=0;
    int critical = gen.nextInt(100);
    if(critical<75){System.out.println("regular attack");}
    else{damage=2*damage;System.out.println("critical attack");}
//    switch(attackingCreature.getAttackType()){
//      case "fire":
//        if(defendingCreature.getDefenseType().equals("ice")){typeDamage=damage*.3;}
//        else{typeDamage=damage*.1;}
//        break;
//      case "ice":
//        if(defendingCreature.getDefenseType().equals("fire")){typeDamage=damage*.3;}
//        else{typeDamage=damage*.1;}
//        break;
//      case "holy":
//        if(defendingCreature.getDefenseType().equals("unholy")){typeDamage=damage*.3;}
//        else{typeDamage=damage*.1;}
//        break;
//      case "unholy":
//        if(defendingCreature.getDefenseType().equals("holy")){typeDamage=damage*.3;}
//        else{typeDamage=damage*.1;}
//          break;
//      case "water":
//        if(defendingCreature.getDefenseType().equals("electric")){typeDamage=damage*.3;}
//        else{typeDamage=damage*.1;}
//          break;
//      case "electric":
//        if(defendingCreature.getDefenseType().equals("water")){typeDamage=damage*.3;}
//        else{typeDamage=damage*.1;}
//          break;
//    }
    System.out.println("jelly damage!!!");
    return (int)(damage+typeDamage);
  }
}
