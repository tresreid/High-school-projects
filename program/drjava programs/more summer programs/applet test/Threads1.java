import java.applet.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Threads1 extends Applet implements Runnable {

   int width, height;
   int i = 0;
   int count1 = 0;
   int count2 = 0;
   Thread t = null;
   boolean threadSuspended;
   JButton butt = new JButton("click me");
   JButton butt2 = new JButton("Click me too!");
   JPanel panel = new JPanel();



   // Executed when the applet is first created.
   public void init() {
      System.out.println("init(): begin");
      setSize(600,500);
      width = getSize().width;
      height = getSize().height;
     // setBackground( Color.black );
      butt.setBackground(Color.blue);
      butt2.setBackground(Color.blue);
      System.out.println("init(): end");
      this.add(butt);
      this.add(butt2);
   }

   // Executed when the applet is destroyed.
   public void destroy() {
      System.out.println("destroy()");
   }

   // Executed after the applet is created; and also whenever
   // the browser returns to the page containing the applet.
   public void start() {
      System.out.println("start(): begin");
      if ( t == null ) {
         System.out.println("start(): creating thread");
         t = new Thread( this );
         System.out.println("start(): starting thread");
         threadSuspended = false;
         t.start();
      }
      else {
         if ( threadSuspended ) {
            threadSuspended = false;
            System.out.println("start(): notifying thread");
            synchronized( this ) {
               notify();
            }
         }
      }
      System.out.println("start(): end");
   }

   // Executed whenever the browser leaves the page containing the applet.
   public void stop() {
      System.out.println("stop(): begin");
      threadSuspended = true;
   }

   // Executed within the thread that this applet created.
   public void run() {
      System.out.println("run(): begin");
      try {
         while (true) {
            System.out.println("run(): awake");
            showStatus( "i is " + i );

            // Now the thread checks to see if it should suspend itself
            if ( threadSuspended ) {
               synchronized( this ) {
                  while ( threadSuspended ) {
                     System.out.println("run(): waiting");
                     wait();
                  }
               }
            }
            System.out.println("run(): requesting repaint");
            ClickListener cl = new ClickListener();
            butt.addActionListener(cl);
            butt2.addActionListener(cl);
            System.out.println("run(): sleeping");
            t.sleep( 10000 );  // interval given in milliseconds
         }
      }
      catch (InterruptedException e) { }
      System.out.println("run(): end");
   }

   // Executed whenever the applet is asked to redraw itself.
   public void paint( Graphics g ) {
      System.out.println("paint()");
      g.setColor( Color.green );
      g.drawLine( 0, height/6, (width/2)-((100-count1)*((width/2))/100), height/6 );
      g.setColor(Color.red);
      g.drawLine( width, height/6, (width / 2)+((100-count2)*((width/2))/100), height/6 );
            g.setColor(new Color(125,125,1));
         g.drawString( "Health 1: "+count1 +"/100", width/99, height/6 );
         g.drawString("health 2: "+count2+"/100", 98*width/99, height/6);
   }
    
  public class ClickListener implements ActionListener{

  public void actionPerformed(ActionEvent e){
    if(e.getSource() == butt){
     count1++;
     System.out.println(count1);
     repaint();
    }
    else if(e.getSource() == butt2){
     count2++;
     repaint();
    }
  }
  }
}

