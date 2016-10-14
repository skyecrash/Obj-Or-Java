// Lilith Freed, laf70

import javax.swing.*;

public class Lab4 {
  
  /** Prompt the user for two integers and return the sum. */
  public static int addIntegers() {
    return Integer.parseInt(JOptionPane.showInputDialog("Type the first integer.")) + Integer.parseInt(JOptionPane.showInputDialog("Type the second integer."));
  }
  
  /** Prompty the user for two doubles and return the larger of the two doubles. */
  public static double maxDouble() {
    double j = Double.parseDouble(JOptionPane.showInputDialog("Type the first double."));
    double k = Double.parseDouble(JOptionPane.showInputDialog("Type the second double."));
    if (j > k) {
      return j;
    } else {
      return k;
    }
  }
  
  /** Prompt the use for three doubles and return the middle value of the three. 
    * If all values are equal, it will return 0.0*/
  public static double middleValue() {
    double j = Double.parseDouble(JOptionPane.showInputDialog("Type the first double."));
    double k = Double.parseDouble(JOptionPane.showInputDialog("Type the second double."));
    double l = Double.parseDouble(JOptionPane.showInputDialog("Type the third double."));
    if (j > k && j < l) {
      return j;
    } else if (k > j && k < l) {
      return k;
    } else if (l > j && l < k) {
      return l;
    }
    return 0.0;
  }
  
  /** Prompt the user for a double and return the closest int. The int value should be rounded
    * so that if the fractional value is 0.5 or greater, it rounds up and if it is less than 0.5
    * it rounds down.
    */
  public static int roundDouble() {
    double j = Double.parseDouble(JOptionPane.showInputDialog("Type the double value."));
    if (j > 0 && (j - (int)j) >= .5) {
      return (int)j + 1;
    } else if (j < 0 && (j - (int)j) <= -0.5) {
      return (int)j - 1;
    } else {
      return (int)j;
    }
  }
  
   /** Prompt the user for a double and return the closest int. The int value should be rounded
    * down if the decomal balue is less than 0.5, rounded up it is greater than 0.5, and if it is
    * exactly 0.5, half the time it will be rounded down and half the time it will be rounded up.
    */
  public static int unbiasedRoundDouble() {
    double j = Double.parseDouble(JOptionPane.showInputDialog("Type the double value."));
    if (j > 0 && (j - (int)j) > .5) {
      return (int)j + 1;
    } else if (j < 0 && (j - (int)j) < -0.5) {
      return (int)j - 1;
    } else if (j > 0 && (j - (int)j) == .5) {
      if (Math.random() >= 0.5) {
        return (int)j + 1;
      } else {
        return (int)j;
      }
    } else if(j < 0 && (j - (int)j) == -0.5) {
      if (Math.random() >= 0.5) {
        return (int)j - 1;
      } else {
        return (int)j;
      }
    } else {
      return (int)j;
    }
  }
      

}