// EECS 132, 10/26

public class Square extends Rectangle {
  
  public Square(double size) {
    super(size, size);
  }
  
  public void setWidth(double width) {
    super.setLength(width);
    super.setWidth(width);
  }
  
  public void setLength(double length) {
    this.setWidth(length);
  }
  
}