  import javax.swing.*;
    import java.awt.*;
    import java.awt.geom.*;
    public class X  {
        public static void main( String [] args ) {
             JFrame frame = new JFrame();
             final int width=250;
             final int height=350;
             final int creature1=70;
             final int creature2=35;
             final int creature1h=52;
             final int creature2h=34;
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
      g.drawLine( 0, height/6, (width/2)-((100 -creature1h )*((width/2))/100  ), height/6 );
      g.setColor(Color.red);
      g.drawLine( width, height/6, (width / 2)+((100 -creature1h )*((width/2))/100 ), height/6 );
      g.setColor(Color.black);
      g.drawString( "Health 1: "+creature1h  +"/"+100 , width/99, height/6 );
      g.drawString("health 2: "+creature1h +"/"+100 , 75*width/99, height/6);
      
       g.setColor( Color.blue );
      g.drawLine( 0, 5*height/24, (width/2)-((100 -creature1 )*((width/2))/100 ), 5*height/24 );
      g.setColor(Color.magenta);
      g.drawLine( width, 5*height/24, (width / 2)+((100 -creature2 )*((width/2))/100 ), 5*height/24 );
      g.setColor(Color.black);
      g.drawString( "Mana 1: "+creature1  +"/"+100 , width/99, 5*height/24 );
      g.drawString("Mana 2: "+creature2 +"/"+100 , 75*width/99, 5*height/24);
    } 
  });
            frame.setVisible( true );
        }
    }