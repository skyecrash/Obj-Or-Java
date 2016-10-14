import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Component.*;

/** A class that allows you to be the artist you've always dreamed of.
  * @author Lilith Freed.
  */
public class Painter extends JFrame implements MouseMotionListener {
  
  /** Space to store glorious work of art. */
  private Canvas canvas;
  
  /** Selection pane for color. */
  private JColorChooser colorChooser;
  
  /** Pen size selection. */
  private JSlider sizeSelection;
  
  public Painter() {
    canvas = new Canvas();
    canvas.setBackground(Color.WHITE);
    canvas.addMouseMotionListener(this);
    
    this.setSize(600, 500);
    
    colorChooser = new JColorChooser(Color.BLACK);
    colorChooser.setPreviewPanel(new JPanel());
    
    sizeSelection = new JSlider(1, 1, 101, 5);
    sizeSelection.setMajorTickSpacing(10);
    sizeSelection.setMinorTickSpacing(1);
    sizeSelection.setPaintTicks(true);
    sizeSelection.setPaintLabels(true);
    
    
    Container c = this.getContentPane();
    c.add(canvas, "Center");
    c.add(colorChooser, "North");
    
  }
  
  public void mouseDragged(MouseEvent e) {
    Graphics graphics = this.canvas.getGraphics();
    graphics.setColor(colorChooser.getColor());
    graphics.fillOval(e.getX() - sizeSelection.getValue() / 2, e.getY() - sizeSelection.getValue() / 2, 
                      sizeSelection.getValue(), sizeSelection.getValue());
  }
  
  public void mouseMoved(MouseEvent e) {
    ;
  }
}
    