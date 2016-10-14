// EECS 132, 10/26

public class otherSquare extends Rectangle {
  
  public otherSquare(double size) {
    super(size, 0);
  }
  
  public double getWidth() {
    return this.getLength();
  }
  
  public void setWidth(double width) {
    super.setLength(width);
  }
  
}