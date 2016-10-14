// EECS 132, 10/26

public abstract class Polygon extends Shape {
  
  private int numSides;
  
  public Polygon(int numSides) {
    this.numSides = numSides;
  }
  
  public int getNumSides() {
    return numSides;
  }
  
}