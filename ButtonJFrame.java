import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** A window with one button and one text area. 
 * @author Lilith Freed
 */
public class ButtonJFrame extends JFrame implements ActionListener {

  /** My button. */
  private JButton b1;
  
  /** Button grid. */
  private JButton[][] grid;
  
  /** Click counter. */
  private int clickCount;
  
  /** Text area for click count. */
  private JTextArea text1;

  /** Create one button at the top, a 3x3 grid of buttons in the middle, and a text area at the bottom. */
  public ButtonJFrame() {
    this.b1 = new JButton("Click me");
    b1.addActionListener(this);
    
    this.grid = new JButton[3][3];
    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[i].length; j++) {
        this.grid[i][j] = new JButton("Click me");
        grid[i][j].addActionListener(this);
      }
    }
    
    text1 = new JTextArea("Click count: 0\n");
    
    JPanel panel = new JPanel(new GridLayout(3, 3));
    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[i].length; j++) {
        panel.add(grid[i][j]);
      }
    }

    Container c = this.getContentPane();
    c.add(this.text1, "South");
    c.add(panel, "Center");
    c.add(this.b1, "North");

    this.pack();
  }
  
  /** React to a button click: append correct message to text area
    * @param e  information about the button click event that occurred
    */
  public void actionPerformed(ActionEvent e) {
    JButton b = (JButton)e.getSource(); // this points to what b1 points to!
    
    if(b == b1) {
      clickCount++;
      text1.append("Click count: " + clickCount + "\n"); // append message to text area
    } else {
      for(int i = 0; i < grid.length; i++) {
        for(int j = 0; j < grid[i].length; j++) {
          if(b == grid[i][j]) {
            text1.append("Button pressed at row " + (i + 1) + ", column " + (j + 1) + "\n");
          }
        }
      }
    }
    this.pack();
  }
}