import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test class HW3
 */
public class HW3Tester {
  
  /**
   * Helper method to compare two dimensional arrays.
   */
  private void equals2Darrays(double[][] expected, double[][] received) {
    assertEquals(expected.length, received.length);
    for (int i = 0; i < expected.length; i++) {
      assertArrayEquals(expected[i], received[i], 1E-5);
    }
  }
  
  /**
   * Test the removeRow method.
   */
  @Test
  public void testRemoveRow() {
    
    double[][] inOne = new double[][]{{1, 2, 3}};
    double[][] outOne = new double[][]{};
    equals2Darrays(outOne, HW3.removeRow(inOne, 0));
    
    double[][] inTwo = new double[][]{{1, 2, 3}, {4, 5, 6}};
    double[][] outTwo = new double[][]{{1, 2, 3}};
    equals2Darrays(outTwo, HW3.removeRow(inTwo, 1));
    
    double[][] inMany = new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
    double[][] outMany = new double[][]{{1, 2, 3}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
    equals2Darrays(outMany, HW3.removeRow(inMany, 1));
    
    equals2Darrays(inMany, HW3.removeRow(inMany, 10));
    equals2Darrays(inMany, HW3.removeRow(inMany, -1));
  }
}
                   