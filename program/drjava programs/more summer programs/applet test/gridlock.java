import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.applet.AppletStub;

public class gridlock extends Applet {
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
  public void init(){
    setSize(600,500);
    width = getSize().width;
    height = getSize().height;
    addKeyListener(new MyKeyListener());
    wallsv.add(new Wall(0,0));
    wallsv.add(new Wall(100,0));
    wallsv.add(new Wall(50,0));
    wallsv.add(new Wall(150,0));
    wallsv.add(new Wall(0,50));
    wallsv.add(new Wall(250,250));
    wallsh.add(new Wall(50,50));
    wallsh.add(new Wall(150,50));
    wallsh.add(new Wall(100,0));
    wallsh.add(new Wall(250,0));
    wallsh.add(new Wall(150,0));
    wallsh.add(new Wall(200,0));
    wallsh.add(new Wall(300,0));
    wallsh.add(new Wall(400,400));
    portals.add( new Portal(150,150,300,300));
//        for(int i=0; i<width;i=i+gridsize){
//          for(int j=0; j<height; j=j+gridsize){
//           wallsv.add(new Wallv(i,j));
//           wallsh.add(new Wallh(i,j));
//          }
//        }
    
    
    wallsv.add(new Wall(150,150));
    wallsv.add(new Wall(200,150));
    wallsh.add(new Wall(150,200));
    doorsh.add(new Door(150,150,false));
    
  }
  public void start(){
  }
  public void stop(){
  }
  public void destroy(){
  }
  public void paint (Graphics g){
    if(fight==false){
    for (int i=0; i<width; i= i+gridsize){
      g.drawLine( i, 0, i, height ) ;
    }
    for(int j=0;j<height; j=j+gridsize){
      g.drawLine(0, j,width, j); 
    }
    g.drawOval (xPos,yPos,gridsize,gridsize);
    
    for(Wall wv: wallsv){
      g.setColor( Color.red);
      g.drawLine(wv.getXPos(),wv.getYPos(),wv.getXPos(),wv.getYPos()+gridsize);
    }
    for(Wall wh: wallsh){
      g.setColor( Color.red);
      g.drawLine(wh.getXPos(),wh.getYPos(),wh.getXPos()+gridsize,wh.getYPos());
    }
    for(Door d: doorsh){
      g.setColor( Color.green);
      g.drawLine(d.getXPos(),d.getYPos(),d.getXPos()+gridsize,d.getYPos());
    }
    for(Door d: doorsv){
      g.setColor( Color.green);
      g.drawLine(d.getXPos(),d.getYPos(),d.getXPos(),d.getYPos()+gridsize);
    }
    for(Portal p: portals){
      g.setColor( Color.blue);
      g.drawOval(p.getXPos(),p.getYPos(),gridsize,gridsize);
      if(xPos==p.getXPos() && yPos==p.getYPos()){
        xPos= p.getReleasex(); yPos=p.getReleasey(); 
        repaint();
      }
    }
         if(xPos==150 && yPos==200){
       
//           Fight brawl = new Fight();
           System.out.println("Fight");
//           Panel container = new Panel();
//           container.setLayout(new GridLayout(1,0));
//           container.add(brawl); //Display Applet
//           add(container);
           fight=true;
           brawl.run();
           
           //brawl.start();
           //brawl.setVisible(true);
     }
         System.out.println(fight);
    }
    else if(fight==true){
      System.out.println("paint()");
      g.setColor(Color.black);
      g.drawLine( 0, 0, width, 0);
      g.drawLine( 0, 0, 0, height);
      g.drawLine( 0, height, width, height );
      g.drawLine( width , 0, width, height );
                              
      g.setColor( Color.green );
      g.drawLine( 0, height/6, (width/2)-((brawl.creature1.getTotalHealth()-brawl.creature1.getHealth())*((width/2))/brawl.creature1.getTotalHealth()), height/6 );
      g.setColor(Color.red);
      g.drawLine( width, height/6, (width / 2)+((brawl.creature2.getTotalHealth()-brawl.creature2.getHealth())*((width/2))/brawl.creature2.getTotalHealth()), height/6 );
      g.setColor(Color.black);
      g.drawString( "Health 1: "+brawl.creature1.getHealth() +"/"+brawl.creature1.getTotalHealth(), width/99, height/6 );
      g.drawString("health 2: "+brawl.creature2.getHealth()+"/"+brawl.creature2.getTotalHealth(), 75*width/99, height/6);
      
       g.setColor( Color.blue );
      g.drawLine( 0, 5*height/24, (width/2)-((brawl.creature1.getTotalMana()-brawl.creature1.getMana())*((width/2))/brawl.creature1.getTotalMana()), 5*height/24 );
      g.setColor(Color.magenta);
      g.drawLine( width, 5*height/24, (width / 2)+((brawl.creature2.getTotalMana()-brawl.creature2.getMana())*((width/2))/brawl.creature2.getTotalMana()), 5*height/24 );
      g.setColor(Color.black);
      g.drawString( "Mana 1: "+brawl.creature1.getMana() +"/"+brawl.creature1.getTotalMana(), width/99, 5*height/24 );
      g.drawString("Mana 2: "+brawl.creature2.getMana()+"/"+brawl.creature2.getTotalMana(), 75*width/99, 5*height/24);
   }
    
    }
//     if(xPos==150 && yPos==175){
//       
//    Fight brawl = new Fight();System.out.println("Fight");
//Panel container = new Panel();
//container.setLayout(new GridLayout(1,0));
//container.add(brawl); //Display Applet
//add(container);
//
//brawl.init();
//brawl.start();
//     brawl.setVisible(true);
//
////     Fight brawl = new Fight();System.out.println("Fight");
////     brawl.init();
////     brawl.start();
////     brawl.repaint();
//     }
  //}
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
            move=0;System.out.println("break");break; 
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
          if(d.getLocked()==true && yPos==d.getYPos()-gridsize && xPos==d.getXPos()){
            move=0;System.out.println("break");break; 
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
            move=0;System.out.println("break");break; 
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
            move=0;System.out.println("break");break; 
          }
        }
        if(xPos==width-gridsize){xPos=width-gridsize;}
        else{ xPos=xPos+move;repaint();}
        break;
      }
    }
  } 
}
  
  
//}
