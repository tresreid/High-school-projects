import java.util.ArrayList;
import javax.swing.*;
import java.math.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class Inventory extends Applet{
  int width, height;
  JFrame frame = new JFrame();
  
  ArrayList<Potion> potions = new ArrayList<Potion>();
  Potion potion1 = new HealthPotion();
  Potion potion2 = new ManaPotion();
  Potion potion3 = new SpeedPotion();
  
  ArrayList<ThrowableItem> throwables = new ArrayList<ThrowableItem>();
  ThrowableItem bomb = new Bomb();
  ThrowableItem shuriken = new Shuriken();
      
  ArrayList<EquipmentTemplate> equiped = new ArrayList<EquipmentTemplate>();
  EquipmentTemplate equipment= new EquipmentTemplate();
  EquipmentTemplate equipment1=new EquipmentTemplate();//sword
  EquipmentTemplate equipment2=new EquipmentTemplate();//bow
  EquipmentTemplate equipment3=new EquipmentTemplate();//shield
  EquipmentTemplate equipment4=new EquipmentTemplate();//armour
  EquipmentTemplate equipment5=new EquipmentTemplate();//extra
  public void init(){
  }
  public void run(){
    frame.setSize(250,250);
      width=250;
      height=250;
      frame.setVisible(true);
      addKeyListener(new MyKeyListener());
      painted();

  }
  
  public void destroy(){
  }
  public void painted(){
      frame.add(new JPanel(){
        public void paintComponent( Graphics g ) {
          super.paintComponent(g);
          System.out.println("inventory painter()");
          g.drawString("equiped items:", width/99, 5*height/24);
          g.drawString("Sword: "+equiped.get(0).getName(), width/99, 6*height/24);
          g.drawString("Bow: "+equiped.get(1).getName(), width/99, 7*height/24);
          g.drawString("Shield: "+equiped.get(2).getName(), width/99, 8*height/24);
          g.drawString("Armour: "+equiped.get(3).getName(), width/99, 9*height/24);
          g.drawString("Other: "+equiped.get(4).getName(), width/99, 10*height/24);
          
          g.setColor(Color.red);
          g.drawString("Health Potions: "+ potions.get(0).getStock(), width/99, 11*height/24);
          g.setColor(Color.blue);
          g.drawString("Mana Potions: "+ potions.get(1).getStock(), width/99, 12*height/24);
          g.setColor(Color.green);
          g.drawString("Speed Potions: "+potions.get(2).getStock(), width/99, 13*height/24);
          
          g.setColor(Color.black);
          g.drawString("Bombs: "+throwables.get(0).getAmmo(), width/99, 14*height/24);
          g.drawString("Shuriken: "+throwables.get(1).getAmmo(), width/99, 15*height/24);
          
          
          
          
        } 
      });//end frame
      frame.setVisible(true);
    }
  public class MyKeyListener extends KeyAdapter{
    public void keyPressed(KeyEvent e) {
      int keyCode = e.getKeyCode();
      switch( keyCode ) { 
        case KeyEvent.VK_I :
          System.out.println("in the bag");
          break;
  }
    }
  }
}