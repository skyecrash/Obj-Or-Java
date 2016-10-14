/* Lilith Freed, laf70 */

import java.awt.Graphics;

/* Line Class */

public class Line{
  
  /* Set Fields */
  private Point p1;
  private Point p2;
  
  
  /* Initialize Constructors */
  public Line(Point p1, Point p2) {
    this.p1 = p1;
    this.p2 = p2;
  }
  
  public Line(int x1, int y1, int x2, int y2) {
    this(new Point(x1, y1), new Point(x2, y2));
  }
  
  
  /* Getter Methods */
  public Point getFirstPoint() {
    return this.p1;
  }
  
  public Point getSecondPoint() {
    return this.p2;
  }
  
  
  /* Setter Methods */
  public void setFirstPoint(Point p1) {
    this.p1 = p1;
  }
  
  public void setSecondPoint(Point p2) {
    this.p2 = p2;
  }
  
  
  /* Draws Line */
  public void draw(Graphics g1) {
    g1.drawLine(this.p1.getX(), this.p1.getY(), this.p2.getX(), this.p2.getY());
  }
}
                              