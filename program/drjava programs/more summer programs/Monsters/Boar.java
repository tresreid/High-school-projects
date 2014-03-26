public class Boar extends CreatureTemplate {
  
  public Boar() { 
    super();
    this.attack=20;
    this.defense=15;
    this.magicAttack=0;
    this.magicDefense=1;
    this.range=5;
    this.health=150;
    this.mana=0;
    this.specialGauge=0;
    this.movementSpeed=10;
    this.agility=7;
    this.name="Boar";
    this.level=2;
    this.height=0;
    this.totalHealth=150;
    this.totalMana=1;
    this.exp=10;
    
    HealthPotion potion1 = new HealthPotion();
    ManaPotion potion2 = new ManaPotion();
    Bomb bomb = new Bomb();
    Shuriken shuriken= new Shuriken();
    this.drops.add(potion1);
    this.dropRate[0]=150;
    this.drops.add(potion2);
    this.dropRate[1]=75;
    this.drops.add(bomb);
    this.dropRate[2]=50;
    this.drops.add(shuriken);
    this.dropRate[3]=50;
    
  }
  /* ADD YOUR CODE HERE */
  
}