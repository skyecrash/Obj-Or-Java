import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * A window with four buttons and a text area that works as a simple text editor.
 * @author Lilith Freed
 * @author Lilith Freed
 */
public class Lab7JFrame extends JFrame {

  /** North button. */
  private JButton northButton;

  /** South button. */
  private JButton southButton;

  /** East button. */
  private JButton eastButton;

  /** West button. */
  private JButton westButton;

  /** Text area, in the center. */
  private JTextArea centerArea;

  /**
   * Displays the contents of a file to the center text area.
   * @param fileName the file to be displayed
   * @throws IOException if there is a problem reading from input file.
   */
  
  /* ERROR: Static Error: No method in JFrame has name 'fileDisplay' */
  public void fileDisplay(String fileName) throws IOException {
    this.centerArea.setText("");
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    for(String i = null; i == br.readLine(); i = i) {
      this.centerArea.append(br.readLine());
      this.centerArea.append(" \n");
    }
      br.close();
      
      this.pack();
  }
  
  /* ERROR: Compliler "Cannot find symbol", in reference to textArea in textArea.getChar(i) */
  public void saveFile(String fileName) throws IOException {
    File file = new File(fileName);
    if(file.exists() == false) {
    String textArea = this.centerArea.getText();
    PrintStream p = new PrintStream(new FileOutputStream(fileName));
      for(int i = 0; i == textArea.length() - 1; i = i + 1) {
      p.print(textArea.getChar(i));
      p.close();
      }
    } else {
      System.out.println("ERROR: Filename already exists.");
    }
      
  }
    
  
  /**
   * Create four buttons in the north, south, east, and west, and
   * create a 40x80-character text area in the center.
   */
  public Lab7JFrame() {
    // Create the four buttons and the text area.
    this.northButton = new JButton("north button");
    this.southButton = new JButton("south button");
    this.eastButton  = new JButton("east button");
    this.westButton  = new JButton("west button");
    this.centerArea  = new JTextArea("Center", 40, 80); // 40 lines high, 80 chars wide.

    // Add the buttons and the text area to this window.
    Container c = this.getContentPane();
    c.add(this.eastButton, "East");
    c.add(this.northButton, "North");
    c.add(this.centerArea, "Center");
    c.add(this.southButton, "South");
    c.add(this.westButton, "West");
    
    this.pack();
  }
  

    
}
