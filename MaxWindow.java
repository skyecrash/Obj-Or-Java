// Lilith Freed, laf70

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

public class MaxWindow extends JFrame {
  
  /* Places object flush with top of screen, 
     does not change x coordinate. */
  public void snapToTop() {
    setLocation(this.getX(), 0);
  }
  
  /* Places object flush with left of screen, 
     does not change y coordinate. */
  public void snapToLeft() {
    setLocation(0, this.getY());
  }
  
  /* Maximizes height of object
   * Places it at the top of screen */
  public void maximizeHeight() {
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension d = kit.getScreenSize();
    this.snapToTop();
    setSize(this.getWidth(), d.height);
  }
  
  /* Maximizes width of object
   * Places it to the left of the screen */
  public void maximizeWidth() {
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension d = kit.getScreenSize();
    this.snapToLeft();
    setSize(d.width, this.getHeight());
  }
  
  /* Maximizes height and width of object.
   * Places it in upper left hand corner of screen. */
  public void maximize() {
    this.maximizeHeight();
    this.maximizeWidth();
  }
  
}