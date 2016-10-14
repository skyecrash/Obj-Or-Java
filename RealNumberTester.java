import org.junit.*;
import static org.junit.Assert.*;

/** Test the RealNumber class.
  * @author Lilith Freed */
public class RealNumberTester {
  
  /** 
   * Test the first constructor. 
   */
  @Test
  public void testRealNumber1() {
    RealNumber num = new RealNumber(0, false, new byte[]{});
    byte[] arrayTest = new byte[]{};
    
    /* Test zero */
    assertArrayEquals("Data array is empty", arrayTest, num.getData());
    assertEquals("Precision is zero", 0, num.getPrecision());
  }
  
}
