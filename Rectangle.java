// EECS 132, 10/26

public class Rectangle extends Quadrilateral {
  
  private double length;
  private double width;
  
  public Rectangle(double length, double width) {
    this.length = length;
    this.width = width;
  }
  
  public double getLength() {
    return this.length;
  }
  
  public double getWidth() {
    return this.width;
  }
  
  public double area() {
    return getLength() * getWidth();
  }
  
}