import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import java.io.*;

public class Gridlock extends Applet {
  int width, height;
  int xPos=0;
  int yPos=0;
  boolean fight;
  Fight brawl = new Fight();
  final int gridsize=50;
  ArrayList<Wall> wallsv = new ArrayList<Wall>();
  ArrayList<Wall> wallsh = new ArrayList<Wall>();
  ArrayList<Portal> portals = new ArrayList<Portal>();
  ArrayList<Door> doorsh = new ArrayList<Door>();
  ArrayList<Door> doorsv = new ArrayList<Door>();
  ArrayList<Key> keys= new ArrayList<Key>();
  ArrayList<SavePoint> savePoints = new ArrayList<SavePoint>();
  ArrayList<Trap> traps = new ArrayList<Trap>();
  ArrayList<Floor> floortiles = new ArrayList<Floor>();
  ArrayList<Enemy> enemies = new ArrayList<Enemy>();
  int obtainedKeys = 0;
  int level=1;
  
  public void init(){
    brawl.bag.equiped.add(0,brawl.bag.equipment);brawl.bag.equiped.add(1,brawl.bag.equipment);brawl.bag.equiped.add(2,brawl.bag.equipment);brawl.bag.equiped.add(3,brawl.bag.equipment);brawl.bag.equiped.add(4,brawl.bag.equipment);
    brawl.bag.potions.add(0,brawl.bag.potion1); brawl.bag.potions.add(1,brawl.bag.potion2);brawl.bag.potions.add(2,brawl.bag.potion3);
    brawl.bag.throwables.add(0,brawl.bag.bomb);brawl.bag.throwables.add(1,brawl.bag.shuriken);
    setSize(600,500);
    width = getSize().width;
    height = getSize().height;
    addKeyListener(new MyKeyListener());
    loadLevel(level, wallsv, wallsh ,  portals ,doorsh ,doorsv ,keys, savePoints , traps );

  }
  public void start(){
  }
  public void stop(){
  }
  public void destroy(){
  }
  public void paint (Graphics g){
    for (int i=0; i<width; i= i+gridsize){
      g.drawLine( i, 0, i, height ) ;
    }
    for(int j=0;j<height; j=j+gridsize){
      g.drawLine(0, j,width, j); 
    }
    g.setColor(Color.red);
    g.drawOval (xPos,yPos,gridsize,gridsize);//draws the character
    for(Floor ft: floortiles){
      g.drawImage(ft.getImg(),ft.getXPos(),ft.getYPos(),ft.getXPos()+gridsize,ft.getYPos()+gridsize,0,0,ft.getImg().getWidth(),ft.getImg().getHeight(),null);
    }
    for(Wall wv: wallsv){
      g.setColor( Color.red);
      g.drawLine(wv.getXPos(),wv.getYPos(),wv.getXPos(),wv.getYPos()+gridsize);
    }
    for(Wall wh: wallsh){
      g.setColor( Color.red);
      g.drawLine(wh.getXPos(),wh.getYPos(),wh.getXPos()+gridsize,wh.getYPos());
    }
    for(Door d: doorsh){
      if(d.getLocked()==true){
      g.setColor( Color.green);
      g.drawLine(d.getXPos(),d.getYPos(),d.getXPos()+gridsize,d.getYPos());
      }
      if(d.getLocked()==false){
      g.setColor( Color.magenta);
      g.drawLine(d.getXPos(),d.getYPos(),d.getXPos()+gridsize,d.getYPos());
      }
    }
    for(Door d: doorsv){
      if(d.getLocked()==true){
      g.setColor( Color.green);
      g.drawLine(d.getXPos(),d.getYPos(),d.getXPos(),d.getYPos()+gridsize);
      }
      if(d.getLocked()==false){
      g.setColor( Color.magenta);
      g.drawLine(d.getXPos(),d.getYPos(),d.getXPos(),d.getYPos()+gridsize);
      }
    }
    for(Portal p: portals){
      g.drawImage(p.getImg(),p.getXPos(),p.getYPos(),p.getXPos()+gridsize,p.getYPos()+gridsize,0,0,p.getImg().getWidth(),p.getImg().getHeight(),null);
      if(xPos==p.getXPos() && yPos==p.getYPos()){
        xPos= p.getReleasex(); yPos=p.getReleasey(); 
        repaint();
      }
    }
    for(Key k: keys){
      if(k.getObtained()==false){
      g.drawImage(k.getImg(),k.getXPos(),k.getYPos(),k.getXPos()+gridsize,k.getYPos()+gridsize,0,0,k.getImg().getWidth(),k.getImg().getHeight(),null);
      if(xPos==k.getXPos() && yPos==k.getYPos()){
        k.setObtained(true);
        obtainedKeys++;
        System.out.println("You have obtained a key. you now have "+obtainedKeys+" keys");
      }
      }
    }
    for(Enemy e: enemies){
          if(xPos==e.getXPos() && yPos==e.getYPos()){
      System.out.println("Fight");
      brawl.run();
          }
    }
    for(Trap t: traps){
    if(xPos==t.getXPos() && yPos==t.getYPos()){
    System.out.println("You fell in a trap!"+t.getDamage()+" damage has been done! :o");  
    brawl.creature1.setHealth(brawl.creature1.getHealth()-t.getDamage());
    }
    }
    for(SavePoint sp: savePoints){
      g.setColor(Color.green);
      g.drawOval (sp.getXPos(),sp.getYPos(),gridsize,gridsize);//draws the character
          if(xPos==sp.getXPos() && yPos==sp.getYPos()){
      String[] saveop = {"save", "load","cancel"};
      int actionA = JOptionPane.showOptionDialog (null, "Choose an Action", "Save/ Load game?!?!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, saveop, saveop[0]);
      if (actionA==0){
        savefile(brawl.creature1, brawl.bag.equiped, brawl.bag.potions, brawl.bag.throwables);
      }
      else if (actionA==1){
        loadfile(brawl.creature1, brawl.bag.equiped, brawl.bag.potions, brawl.bag.throwables);
      }
      else if(actionA==2){
        
      }
        
      } 
    }
        if(brawl.creature1.getHealth()<=0){
     System.out.println("YOU HAVE DIED!!!!!"); 
    }
  }//end paint
  
  public class MyKeyListener extends KeyAdapter{
    public void keyPressed(KeyEvent e) {
      int keyCode = e.getKeyCode();
      int move=gridsize;
      switch( keyCode ) { 
        case KeyEvent.VK_UP:
        for(Wall wh: wallsh){
          if(yPos==wh.getYPos() && xPos==wh.getXPos()){
            move=0;System.out.println("break");break; 
          }
        }
        for(Door d: doorsh){
          if(d.getLocked()==true && yPos==d.getYPos() && xPos==d.getXPos()){
            if(obtainedKeys==0){move=0;System.out.println("This door is locked");break; }
            if(obtainedKeys>0){
              String[] opener = {"open", "don't open"};
              int open = JOptionPane.showOptionDialog (null, "Choose an Action", "Open the door?", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opener, opener[0]);
              if (open==0){
                d.setLocked(false);
                obtainedKeys--;
                System.out.println("the door has been unlocked");
                move=0;
              }
              else if (open==1){
                move=0;
              }
            }
          }
        }
        if(yPos==0){yPos=0;}
        else{ yPos = yPos-move;repaint();}
        break;
        case KeyEvent.VK_DOWN:
        for(Wall wh: wallsh){
          if(yPos==wh.getYPos()-gridsize && xPos==wh.getXPos()){
            move=0;System.out.println("break");break; 
          }
        }
        for(Door d: doorsh){
          if(d.getLocked()==true && (yPos==d.getYPos()-gridsize && xPos==d.getXPos())){
            if(obtainedKeys==0){move=0;System.out.println("This door is locked");break; }
            if(obtainedKeys>0){
              String[] opener = {"open", "don't open"};
              int open = JOptionPane.showOptionDialog (null, "Choose an Action", "YOUR TURN!!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opener, opener[0]);
              if (open==0){
                d.setLocked(false);
                obtainedKeys--;
                System.out.println("the door has been unlocked");
                move=0;
              }
              else if (open==1){
                move=0;
              }
            }
          }
        }
        if(yPos==height-gridsize){yPos=height-gridsize;}
        else{ yPos= yPos+move;repaint();}
        break;
        case KeyEvent.VK_LEFT:
        for(Wall wv: wallsv){
          if(yPos==wv.getYPos() && xPos==wv.getXPos()){
            move=0;System.out.println("break");break; 
          }
        }
        for(Door d: doorsv){
          if(d.getLocked()==true && yPos==d.getYPos() && xPos==d.getXPos()){
            if(obtainedKeys==0){move=0;System.out.println("This door is locked");break; }
            if(obtainedKeys>0){
              String[] opener = {"open", "don't open"};
              int open = JOptionPane.showOptionDialog (null, "Choose an Action", "YOUR TURN!!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opener, opener[0]);
              if (open==0){
                d.setLocked(false);
                obtainedKeys--;
                System.out.println("the door has been unlocked");
                move=0;
              }
              else if (open==1){
                move=0;
              }
            }
          }
        }
        if(xPos==0){xPos=0;}
        else{  xPos=xPos-move;repaint();}
        break;
        case KeyEvent.VK_RIGHT :
        for(Wall wv: wallsv){
          if(yPos==wv.getYPos() && xPos==wv.getXPos()-gridsize){
            move=0;System.out.println("break");break; 
          }
        }
        for(Door d: doorsv){
          if(d.getLocked()==true && yPos==d.getYPos() && xPos==d.getXPos()-gridsize){
            if(obtainedKeys==0){move=0;System.out.println("This door is locked");break; }
            if(obtainedKeys>0){
              String[] opener = {"open", "don't open"};
              int open = JOptionPane.showOptionDialog (null, "Choose an Action", "YOUR TURN!!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opener, opener[0]);
              if (open==0){
                d.setLocked(false);
                obtainedKeys--;
                System.out.println("the door has been unlocked");
                move=0;
              }
              else if (open==1){
                move=0;
              }
            }
          }
        }
        if(xPos==width-gridsize){xPos=width-gridsize;}
        else{ xPos=xPos+move;repaint();}
        break;
        
        case KeyEvent.VK_I :
                    System.out.println("open Bag");
          brawl.bag.run();
        break;
      }//end switch
    }//end keypressed
  }//end keylistener 
  
  public void savefile(CreatureTemplate creature1, ArrayList<EquipmentTemplate> equiped, ArrayList<Potion> potions, ArrayList<ThrowableItem> throwables ){
    try{
      // Create file 
      FileWriter fstream = new FileWriter("out.txt");
      BufferedWriter out = new BufferedWriter(fstream);
      out.write(creature1.getAttack()+","+creature1.getDefense()+","+creature1.getMagicAttack()+","+creature1.getMagicDefense()
                  +","+creature1.getRange()+","+creature1.getHealth()+","+creature1.getMana()+","+creature1.getSpecialGauge()
                  +","+creature1.getMovementSpeed()+","+creature1.getAgility()+","+creature1.getLevel()+","+creature1.getHeight()
                  +","+creature1.getRanged()+","+creature1.getTotalHealth()+","+creature1.getTotalMana()+","+creature1.getExp());
      out.newLine();// hero stats- attack,defense,magic attack, magic defense, range, health, mana, special gauge, movement speed, agility, level, height, ranged, total health, total mana, exp
      out.write(equiped.get(0).getEquipped()+","+equiped.get(1).getEquipped()+","+equiped.get(2).getEquipped()+","+equiped.get(3).getEquipped());
      out.newLine();//armour equiped- sword, bow, sheild, armour
      out.write(potions.get(0).getStock()+","+potions.get(1).getStock()+","+potions.get(2).getStock());
      out.newLine();//potions- health, mana, speed
      out.write(throwables.get(0).getAmmo()+","+throwables.get(1).getAmmo()+","+obtainedKeys);
      out.newLine();// throwable items- bomb, shuriken, keys
      //Close the output stream
      out.close();
    }
    catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e.getMessage());
    } 
  }
  
    public void loadfile(CreatureTemplate creature1, ArrayList<EquipmentTemplate> equiped, ArrayList<Potion> potions, ArrayList<ThrowableItem> throwables ){
    try{
      // Create file 
      FileReader fstream = new FileReader("out.txt");
      BufferedReader out = new BufferedReader(fstream);
      String line = out.readLine();
      String[] data;
        data= line.split(",");
        creature1.setAttack(Integer.parseInt(data[0]));
        creature1.setDefense(Integer.parseInt(data[1]));
        creature1.setMagicAttack(Integer.parseInt(data[2]));
        creature1.setMagicDefense(Integer.parseInt(data[3]));
        creature1.setRange(Integer.parseInt(data[4]));
        creature1.setHealth(Integer.parseInt(data[5]));
        creature1.setMana(Integer.parseInt(data[6]));
        creature1.setSpecialGauge(Integer.parseInt(data[7]));
        creature1.setMovementSpeed(Integer.parseInt(data[8]));
        creature1.setAgility(Integer.parseInt(data[9]));
        creature1.setLevel(Integer.parseInt(data[10]));
        creature1.setHeight(Double.parseDouble(data[11]));
        creature1.setRanged(Integer.parseInt(data[12]));
        creature1.setTotalHealth(Integer.parseInt(data[13]));
        creature1.setTotalMana(Integer.parseInt(data[14]));
        creature1.setExp(Integer.parseInt(data[15]));
        //out.newLine();
        String line2 = out.readLine();
        String[] data2;
        data2= line2.split(",");
       
        if(Boolean.parseBoolean(data2[0])==true){
          brawl.bag.equipment1= new WeaponTemplate();
          equiped.set(0, brawl.bag.equipment1);
          brawl.bag.equipment1.equip(brawl.creature1);
          brawl.bag.equipment1.setEquipped(true);
        }
        if(Boolean.parseBoolean(data2[1])==true){
          brawl.bag.equipment2= new RangedWeapon(brawl.bag.equipment);
          equiped.set(1, brawl.bag.equipment2);
          brawl.bag.equipment2.equip(brawl.creature1);
          brawl.bag.equipment2.setEquipped(true);
        }
        if(Boolean.parseBoolean(data2[2])==true){
          brawl.bag.equipment3= new ShieldTemplate();
          equiped.set(2, brawl.bag.equipment3);
          brawl.bag.equipment3.equip(brawl.creature1);
          brawl.bag.equipment3.setEquipped(true);
        }
        if(Boolean.parseBoolean(data2[3])==true){
          brawl.bag.equipment4= new ArmorTemplate();
          equiped.set(3, brawl.bag.equipment4);
          brawl.bag.equipment4.equip(brawl.creature1);
          brawl.bag.equipment4.setEquipped(true);
        }
        
        
        String line3 = out.readLine();
        String[] data3;
        data3= line3.split(",");
        potions.get(0).setStock(Integer.parseInt(data3[0]));
        potions.get(1).setStock(Integer.parseInt(data3[1]));
        potions.get(2).setStock(Integer.parseInt(data3[2]));
        
        String line4 = out.readLine();
        String[] data4;
        data4= line4.split(",");
        throwables.get(0).setAmmo(Integer.parseInt(data4[0]));
        throwables.get(1).setAmmo(Integer.parseInt(data4[1]));
        obtainedKeys = Integer.parseInt(data4[2]);
        //Close the output stream
        out.close();
    }
    catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e.getMessage());
    } 
  }//END LOAD FILE
    
    public void loadLevel(int level, ArrayList<Wall> wallsv,ArrayList<Wall> wallsh , ArrayList<Portal> portals ,ArrayList<Door> doorsh ,
                          ArrayList<Door> doorsv ,ArrayList<Key> keys,ArrayList<SavePoint> savePoints ,ArrayList<Trap> traps ){
    try{
      // Create file 
      FileReader fstream = new FileReader("levels/level"+level+".txt");
      BufferedReader out = new BufferedReader(fstream);
      String line;
      while((line=out.readLine()) != null){
        if(line.equals("wallsv:")){
          line=out.readLine();
          while(!(line.equals("wallsh:"))){
            String data[];
          data=line.split(",");
          wallsv.add(new Wall(Integer.parseInt(data[0]),Integer.parseInt(data[1])));
          line= out.readLine();
          }
        }
        
        if(line.equals("wallsh:")){
          line=out.readLine();
          while(!(line.equals("portals:"))){
            String data[];
          data=line.split(",");
          wallsh.add(new Wall(Integer.parseInt(data[0]),Integer.parseInt(data[1])));
          line= out.readLine();
          }
        }
        
        if(line.equals("portals:")){
          line=out.readLine();
          while(!(line.equals("doorsh:"))){
            String data[];
          data=line.split(",");
          portals.add(new Portal(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]),Integer.parseInt(data[3])));
          line= out.readLine();
          }
        }
        
        if(line.equals("doorsh:")){
          line=out.readLine();
          while(!(line.equals("doorsv:"))){
            String data[];
          data=line.split(",");
          doorsh.add(new Door(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Boolean.parseBoolean(data[2])));
          line= out.readLine();
          }
        }
        
        if(line.equals("doorsv:")){
          line=out.readLine();
          while(!(line.equals("keys:"))){
            String data[];
          data=line.split(",");
          doorsv.add(new Door(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Boolean.parseBoolean(data[2])));
          line= out.readLine();
          }
        }
        
        if(line.equals("keys:")){
          line=out.readLine();
          while(!(line.equals("savePoints:"))){
            String data[];
          data=line.split(",");
          keys.add(new Key(Integer.parseInt(data[0]),Integer.parseInt(data[1])));
          line= out.readLine();
          }
        }
        if(line.equals("savePoints:")){
          line=out.readLine();
          while(!(line.equals("traps:"))){
            String data[];
          data=line.split(",");
          savePoints.add(new SavePoint(Integer.parseInt(data[0]),Integer.parseInt(data[1])));
          line= out.readLine();
          }
        }
        if(line.equals("traps:")){
          line=out.readLine();
          while(!(line.equals("enemies:"))){
            String data[];
          data=line.split(",");
          traps.add(new Trap(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2])));
          line= out.readLine();
          }
        }
        
        if(line.equals("enemies:")){
          line=out.readLine();
          while(!(line.equals("endlevel:"))){
            String data[];
          data=line.split(",");
          enemies.add(new Enemy(Integer.parseInt(data[0]),Integer.parseInt(data[1])));
          line= out.readLine();
          }
        }
        System.out.println(line);
        
      }
      System.out.println("level loaded");
    }
    catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e.getMessage());
    } 
    }//end load level
  
}//end applet