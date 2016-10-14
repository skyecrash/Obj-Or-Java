/* Lilith Freed, laf70 */

import javax.swing.JFrame;

/* Point Class */
public class Point{
  
  /* Initialize x and y input variables. */
  private int x;
  private int y;
  
  /* Initialize the angle. */
  private double angle;
  
  /* Initialize this distance from origin variable. */
  private double r;
  
  /* Initialize the point object. */
  public Point(int a, int b) {
    this.x = a;
    this.y = b;
  }
  
  /* Change the x and y coordinates of the point. */
  public void setX(int x) {
    this.x = x;
  }
  
  public void setY(int y) {
    this.y = y;
  }
  
  /* Return x and y coordinates of the point. */
  public int getX() {
    return this.x;
  }
  
  public int getY() {
    return this.y;
  }
  
  /* Calculate distance from origin. 
   * Uses the polar coordinate theory. 
   * theta = arccos(x/r), r^2 = x^2 + y^2  */
    
  private double distanceFromOrigin() {
    r = Math.sqrt((this.x * this.x) + (this.y * this.y));
    return r;
  }
  
  /* Returns the angle from the positive x-axis. 
   * The code placed at the beginning*/
  public double getAngle() {
    r = this.distanceFromOrigin();
    if(this.x == 0 && this.y == 0) {
      this.angle = 0;
    } else {
      this.angle = Math.acos(this.x / r);
    }
    return this.angle;
  }
  
  /* Rotates point given an angle in radians. */
  public void rotate(double angle) {
    r = this.distanceFromOrigin();
    if(r != 0 && this.x != 0 && this.y != 0) {
      this.x = (int)(r * Math.cos(angle));
      this.y = (int)(r * Math.sin(angle));
    }
  }
        
    
    
    
      
      

      
  
}