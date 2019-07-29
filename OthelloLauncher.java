import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.NoSuchElementException;
import java.util.*;
import java.lang.IllegalArgumentException;
/* Daniel Kessler
 * This is a class that allows you to play to board game Othello
 */
public class OthelloLauncher extends JFrame implements ActionListener{
  
  private JButton easy;
  
  private JButton hard;
  
  private JButton multiplayer;
  
  private JPanel options;
  
  private JFrame dialog = new JFrame();
  
  private static Color pColor;
  private static Color oColor;
  
  private String[] colors = new String[] {"Black", "White", "Green", "Blue", "Magenta", "Red", "Yellow", "Orange"};
  
  private HashMap<String,Color> colorSet1 = new HashMap<String,Color>(8);

  private HashMap<String,Color> colorSet2 = new HashMap<String,Color>(8);
  
  private JComboBox playerColors;
  
  private JComboBox oppColors;
    
  
  public OthelloLauncher() {
    super("OthelloLauncher");
    colorSet1.put("Black",Color.BLACK);
    colorSet1.put("White",Color.WHITE);
    colorSet1.put("Green",Color.GREEN);
    colorSet1.put("Blue",Color.BLUE);
    colorSet1.put("Magenta",Color.MAGENTA);
    colorSet1.put("Red",Color.RED);
    colorSet1.put("Yellow",Color.YELLOW);
    colorSet1.put("Orange",Color.ORANGE);
  
    colorSet2.put("Black",Color.BLACK);
    colorSet2.put("White",Color.WHITE);
    colorSet2.put("Green",Color.GREEN);
    colorSet2.put("Blue",Color.BLUE);
    colorSet2.put("Magenta",Color.MAGENTA);
    colorSet2.put("Red",Color.RED);
    colorSet2.put("Yellow",Color.YELLOW);
    colorSet2.put("Orange",Color.ORANGE);
  
    playerColors = new JComboBox(colors); 
    playerColors.addActionListener( new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ev) {
        String c = (String) playerColors.getSelectedItem();
        pColor = colorSet1.get(c);
      }
    });
    JLabel l1 = new JLabel("Player Color"); JLabel l2 = new JLabel("Opponent Color");
    oppColors = new JComboBox(colors);
    oppColors.setSelectedIndex(1);
    oppColors.addActionListener( new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ev) {
        String c = (String) oppColors.getSelectedItem();
        oColor = colorSet1.get(c);
      }
    });
    JPanel colorChoice = new JPanel(new GridLayout(1,4,1,1));
    colorChoice.add(l1); colorChoice.add(playerColors); colorChoice.add(l2); colorChoice.add(oppColors);
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setDefaultLookAndFeelDecorated(true);
    
    try {
   //   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
      e.printStackTrace();
    }
    setSize(400,500);
    //button adding
    options = new JPanel(new FlowLayout());
    Container c = this.getContentPane();
    easy = new JButton("easy");
    easy.addActionListener(this);
    hard = new JButton("hard");
    hard.addActionListener(this);
    multiplayer = new JButton("2-player");
    multiplayer.addActionListener(this);
    easy.setPreferredSize(new Dimension(100, 100));
    hard.setPreferredSize(new Dimension(100, 100));
    multiplayer.setPreferredSize(new Dimension(100, 100));
    options.add(easy);
    options.add(hard);
    options.add(multiplayer);
    c.add(options);
    c.add(colorChoice,BorderLayout.NORTH);
    pack();
    setVisible(true);
    
  }
  
  public static void main(String[] args) {
    new OthelloLauncher();
    
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    JButton b = (JButton) e.getSource();
    if(b==this.easy) {
      if(oColor.equals(pColor)) {

          JOptionPane.showMessageDialog(dialog, "You can't use the same color!");
          throw new IllegalArgumentException();
      }
      new Othello("easy");
      this.dispose();
    }
    
    if(b==this.hard) {
      String c1 = (String) playerColors.getSelectedItem();
      String c2 = (String) oppColors.getSelectedItem();
      if(c1.equals(c2)) {
          JOptionPane.showMessageDialog(dialog, "You can't use the same color!");
          throw new IllegalArgumentException();
      }
      Othello game = new Othello("hard",colorSet1.get(c1), colorSet2.get(c2));
      this.dispose(); 
    }
    
    if(b==this.multiplayer) {
      String c1 = (String) playerColors.getSelectedItem();
      String c2 = (String) oppColors.getSelectedItem();
      if(c1.equals(c2)) {
        JOptionPane.showMessageDialog(dialog, "You can't use the same color!");
          throw new IllegalArgumentException();
      }
      new Othello();
      this.dispose();
    }
  }
/**private class PlayerColorBox extends JComboBox implements ActionListener{
    private String[] colors = new String[] {"Black", "White", "Green", "Blue", "Magenta", "Red", "Yellow", "Orange"};
  
    private HashMap<String,Color> colorSet = new HashMap<String,Color>(8);
    
    public PlayerColorBox() {
      addActionListener(this);
      colorSet.put("Black",Color.BLACK);
      colorSet.put("White",Color.WHITE);
      colorSet.put("Green",Color.GREEN);
      colorSet.put("Blue",Color.BLUE);
      colorSet.put("Magenta",Color.MAGENTA);
      colorSet.put("Red",Color.RED);
      colorSet.put("Yellow",Color.YELLOW);
      colorSet.put("Orange",Color.ORANGE);
    }
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String c = (String)cb.getSelectedItem();
        Color c1 = colorSet.get(c);
        OthelloLauncher.pColor = c1;
    }
}*/
}

