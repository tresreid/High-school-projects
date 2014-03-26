import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Animation extends JFrame {
  
  
  public static void main(String[] args) { 
    new Animation();
  }
  
  private JLabel sampleText;
  
  private JComboBox fontComboBox;
  private JComboBox sizeComboBox;
  private JComboBox boldCheck, italCheck;
  private String[] fonts;
  
  public Animation(){
   this.setSize(500,150);
   this.setTitle("fun with fonts");
   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   FontListener fl = new FontListener();
   
   sampleText = new JLabel(" The quick brown fox jumped over the lazy dog");
   this.add(sampleText, BorderLayout.NORTH);
   
   GraphicsEnvironment g;
   g = GraphicsEnvironment.getLocalGraphicsEnvironment();
   fonts = g.getAvailableFontFamilyNames();
   
   JPanel controlPanel = new JPanel();
   
   fontComboBox = new JComboBox(fonts);
   fontComboBox.addActionListener(fl);
   controlPanel.add(new JLabel("Family: "));
   controlPanel.add(fontComboBox);
   
   Integer[] sizes = {7, 8,9, 10, 11, 12, 14,18,20,22,24,36};
   sizeComboBox = new JComboBox(sizes);
   sizeComboBox.setSelectedIndex(5);
   sizeComboBox.addActionListener(fl);
   controlPanel.add(new JLabel("size: "));
   controlPanel.add(sizeComboBox);     
   
   boldCheck = new JCheckBox("Bold");
   boldCheck.addActionListener(fl);
   controlPanel.add(boldcheck);
   
   italCheck = new JCheckBox("ital");
   italCheck.addActionListener(fl);
   controlPanel.add(italCheck);
   
    this.add(controlPanel, BorderLayout.SOUTH);
    fl.updateText();
    
    this.setVisible(true);
   
  }
  
  private class FontListener implements ActionLister{
    public void actionPerformed(ActionEvent e){
     updateText(); 
    }
    
    public void updateText(){
     String name= (String) fontComboBox.getSelectedItem();
     Integer size = (Integer) sizeComboBox.getSelectedItem();
     
     int style;
     if(boldCheck.isSelected() && italCheck.isSelected()){
      style = Font.BOLD | Font.ITALIC; 
     }
     else if (boldCheck.isSelected()){
      style= Font.Bold; 
     }
     else if (italCheck.isSelected()){
      style= Font.ITALIC; 
     }
     else {style= Font.PLAIN;}
     
     Font f = new Font(name, style, size.intValue());
     sampleText.setFont(f);
    }
  }
  
}
