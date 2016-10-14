 /** A class that represents an arbitrary number in decimal notation.
  * @author Lilith Freed
  */
public class RealNumber {
  
  /** Number of digits to right of decimal point. */
  private int precision;
  
  /** Boolean that indicates a negative value */
  private boolean isNegative;
  
  /** An array storing all the digits of the real number. */
  private byte[] data;
  
  /** A constructor that takes a byte[] array as the source of data.
    * @param precision The number of places to the right of the decimal.
    * @param isNegative A boolean that indicates whether or not the number is negative.
    * @param data The array of data that contains the number.
    */
  public RealNumber(int precision, boolean isNegative, byte[] data) {
    this.isNegative = isNegative;
    
    /* If precision is negative, make it positive. */
    if(precision < 0) {
      precision = -1 * precision;
    } 
    this.precision = precision;
    
    /* If the precision is longer than the data array,
     * make a new array of correct length and copy data. */
    if(precision > data.length) {
      this.data = transposeData(data, precision);
    } else {
      this.data = data;
    }
  
  }
  
  /** A constructor that takes a String object as the source of data.
    * @param precision The number of places to the right of the decimal.
    * @param value The number in String format.
    * @exception NumberFormatException Will throw this exception if user tries to input a non-number String.
    */
  public RealNumber(int precision, String value) throws NumberFormatException {
    /* Error handling to catch improper number format. */
    try {
      Double.parseDouble(value);
    }
    catch(NumberFormatException e) {
      throw e;
    }
    
    /* If precision is negative, make it positive. */
    if(precision < 0) {
      precision = -1 * precision;
    } 
    this.precision = precision;
    
    /* Checks string for negative value. */
    if(value.charAt(0) == '-') {
      this.isNegative = true;
    } else {
      this.isNegative = false;
    }
    
    this.data = transposeData(value, precision);

  }
  
  /** Transpose data with a byte[] array.
    * @param data The array to be transposed.
    * @param precision The precision of the array of data.
    * @return The new array with all data. 
    */
  private byte[] transposeData(byte[] data, int precision) {
    byte[] newData = new byte[precision];
    
    /* Copies the old data into new array. */
    for(int i = 0; i < data.length; i++) {
      newData[i] = data[i];
    }
    
    /* Copies in the zeros to the precision. */
    for(int i = data.length; i < precision; i++) {
      newData[i] = (byte)0;
    }
    
    return newData;
  }
  
  /** Transpose data with a String object.
    * @param value The String to be transposed.
    * @param precision The precision of the array of data
    * @return The new array with all data. 
    */
  private byte[] transposeData(String value, int precision) {
    byte[] data;
    
    int leftPlaces = 0; // stores number of places left of the decimal
    /* Detemining how many places are to the left of the decimal. */
    for(int i = 0; value.charAt(i) != '.' &&i < value.length(); i++) {
      if(Character.isDigit(value.charAt(i))) {
        leftPlaces++;
      }
    }
    
    data = new byte[leftPlaces + precision]; // array with correct length
    
    int arrayIndex = data.length - 1; // keeps track of what data has been entered into the array
    
    /* Parses the data from the String into the array. */
    for(int i = 0; i < value.length() && arrayIndex >= 0; i++) {
      /* If the string is not at its last character, but its the final digit in the array */
      if(i != value.length() - 1 && arrayIndex == 0) {
        /* All these ifs test for rounding in the case of truncating.*/
        if(Character.digit(value.charAt(i + 1), 10) < 5) {
          data[arrayIndex] = (byte)(Character.digit(value.charAt(i), 10));
        } else if(Character.digit(value.charAt(i + 1), 10) >= 5 && Character.digit(value.charAt(i), 10) == 9) {
          data[arrayIndex] = (byte)0;
          data[arrayIndex + 1] = (byte)(Character.digit(value.charAt(i-1) + 1, 10));
        } else {
          data[arrayIndex] = (byte)(Character.digit(value.charAt(i) + 1, 10));
        }
        arrayIndex--;
      } else if(Character.isDigit(value.charAt(i))) {
        data[arrayIndex] = (byte)Character.digit(value.charAt(i), 10);
        arrayIndex--;
      }
    }
    
    return data;
  }
  
  /** Traverses the data array until the "true" start point of the number and returns the index.
    * @param value The RealNumber representation of the value.
    * @return The index of where the number "actually" begins.
    */
  private static int getStartPoint(RealNumber value) {
    int arrayIndex = value.getData().length - 1;
    
    /* Checks for leading zeros. */
    while(value.getData()[arrayIndex] == 0 && arrayIndex > value.getPrecision() - 1) {
      arrayIndex--;
    }
    
    return arrayIndex;
  
  }
  
  /** Returns the precision of the number.
    * @return The precision of the RealNumber. 
    */
  public int getPrecision() {
    return this.precision;
  }
  
  /** Returns the data array of the number.
    * @return The data array associated with the RealNumber. */
  public byte[] getData() {
    return this.data;
  }
  
  /** Returns true if RealNumber is negative, and false otherwise.
    * @return The boolean that indicates whether RealNumber is true or false. */
  public boolean isNegative() {
    return this.isNegative;
  }
  
  /** Returns a String representation of the RealNumber.
    * @return The RealNumber in String form.
    */
  public String toString() {
    StringBuilder number = new StringBuilder();
    
    /* Appends hyphen if negative. */
    if(isNegative) {
      number.append('-');
    }
    
    if(precision < this.getData().length) {
      
      /* Begins appending at the start point. 
       * Stops once it reaches the precision point. */
      for(int i = this.getStartPoint(this); i > this.getPrecision() - 1; i--) {
        number.append(this.getData()[i]);
      }
    }
    
    number.append('.');
    /* Adds the numbers past the decimal place. 
     * Stops once it traverses the entire array. */
    for(int i = this.getPrecision() - 1; i >= 0; i--) {
      number.append(this.getData()[i]);
    }
    
    return number.toString();
  }
  
  /** Returns 1 if value1 > value2, -1 if value1 < value2, and 0 if they are equal.
    * @param value1 A RealNumber that will be compared to value1.
    * @param value2 A RealNumber that will be compared to value2.
    * @return The value corresponding to the result of the comparison.
    */
  public static int compare(RealNumber value1, RealNumber value2) {
    
    /* Check for negative/positive -- if they differ in sign,
     * then it is easy to tell which value is greater. */
    if(!value1.isNegative() && value2.isNegative()) {
      return 1;
    } else if(value1.isNegative() && !value2.isNegative()) {
      return -1;
    }
    
    int index1 = getStartPoint(value1);
    int index2 = getStartPoint(value2);
    
    /* All these conditionals are based on the "margin" 
     * between the current index and the beginning of the precision.
     * That is, if the margins are equal, then the numbers have the same amount of places,
     * and must be compared side by side.
     * Otherwise, it is obvious which one has a greater absolute value. */
    
    if(index1 - (value1.getData().length - value1.getPrecision()) // if the two margins are equal
         == index2 - (value2.getData().length - value2.getPrecision())) {
      
      /* Compares the two strings with equal number of left places.
       * Precond: Both values are either positive or negative. */
      while(index1 >= 0 && index2 >= 0) {
        if(value1.getData()[index1] > value2.getData()[index2]) {
          if(!value1.isNegative()) { 
            return 1;
          } else {     // if the values are negative, return the opposite
            return -1;
          }
        } else if(value1.getData()[index1] < value2.getData()[index2]) {
          if(!value1.isNegative()) {
            return -1;
          } else {
            return 1;
          }
        }
        index1--;
        index2--;
      }
    
    } else if(index1 - (value1.getData().length - value1.getPrecision()) // if the value1 margin is larger
                > index2 - (value2.getData().length - value2.getPrecision())) {
           
      if(!value1.isNegative()) {
        return 1;
      } else {
        return -1;
      }
      
    } else { // if the value2 margin is larger
      
      if(!value1.isNegative()) {
        return -1;
      } else {
        return 1;
      }
      
    }
    
    /* If there are still places to be read in the first value, read those places. */
    if(index1 >= 0) {
      for(int i = index1; i >= 0; i--) {
        if(value1.getData()[i] != 0) {
          if(!value1.isNegative()) {
            return 1;
          } else {
            return -1;
          }
        }
      }
    }
    
    /* If there are still places to be read in the second value, read those places. */
    if(index2 >= 0) {
      for(int i = index2; i >= 0; i--) {
        if(value2.getData()[i] != 0) {
          if(!value1.isNegative()) {
            return -1;
          } else {
            return 1;
          }
        }
      }
    }
    
    return 0; // if it goes through all comparisons without returning 1 or -1, they are equivalent
  }
  
  /** Returns 1 if this > value, -1 if this < value, and 0 if they are equal.
    * @param value A RealNumber that will be compared to this.
    * @return The value corresponding to the result of the comparison.
    */
  public int compareTo(RealNumber value) {
    return this.compare(this, value);
  }
  
  /** Returns true if o is a RealNumber instance that is numerically equal to this instance.
    * Else, returns false.
    * @param o An Object to be compared to RealNumber.
    * @return Whether or not o is numerically equal to RealNumber.
    */
  public boolean equals(Object o) {
    
    /* Checks for legal typecast. */
    if(!(o instanceof RealNumber)) {
      return false;
    }
    
    if(this.compareTo((RealNumber)o) == 0) {
      return true;
    }
    
    return false;
    
  }
  
  /** Returns a RealNumber that is the sum of value1 and value2.
    * @param value1 A RealNumber to be added.
    * @param value2 A RealNumber to be added.
    * @return A RealNumber that is the result of summing value1 and value 2.
    */
  public static RealNumber add(RealNumber value1, RealNumber value2) {
    int leftDigits;
    int largerPrecision;
    
    /* Get the number of left digits. */
    if(value1.getData().length - value1.getPrecision() > value2.getData().length - value2.getPrecision()) {
      leftDigits = value1.getData().length - value1.getPrecision();
    } else {
      leftDigits = value2.getData().length - value2.getPrecision();
    }
    
    /* Get the largest precision. */
    if(value1.getPrecision() > value2.getPrecision()) {
      largerPrecision = value1.getPrecision();
    } else {
      largerPrecision = value2.getPrecision();
    }
    
    byte[] data = new byte[leftDigits + largerPrecision];
    
    int index1 = 0;
    int index2 = 0;
    int dataIndex = 0;
    
    /* Conditional block handles if precisions don't match. */
    if(value1.getPrecision() > value2.getPrecision()) {
      while(index1 < value2.getPrecision() - 1) {
        data[dataIndex] = value1.getData()[index1];
        dataIndex++;
        index1++;
      }
    } else if(value1.getPrecision() < value2.getPrecision()) {
      while(index2 < value1.getPrecision() - 1) {
        data[dataIndex] = value2.getData()[index2];
        dataIndex++;
        index2++;
      }
    }
    
    int carry = 0;
    
    while(index1 < value1.getData().length && index2 < value2.getData().length) {
      if(value1.getData()[index1] + value2.getData()[index2] + carry >= 10) {
        data[dataIndex] = (byte)(10 - (value1.getData()[index1] + value2.getData()[index2] + carry));
        carry = 1;
      } else {
        data[dataIndex] = (byte)(value1.getData()[index1] + value2.getData()[index2] + carry);
        carry = 0;
      }
      dataIndex++;
      index1++;
      index2++;
    }
    
    if(index1 < value1.getData().length) {
      data[dataIndex] = value1.getData()[index1];
      dataIndex++;
      index1++;
    } else if(index2 < value2.getData().length) {
      data[dataIndex] = value2.getData()[index2];
      dataIndex++;
      index2++;
    }
    
    if(value1.isNegative() && value2.isNegative()) {
      return new RealNumber(largerPrecision, true, data);
    }
    
    return new RealNumber(largerPrecision, false, data);
    
  }
  
  /** Returns a RealNumber that is the sum of value1 and value2.
    * @param value1 A RealNumber value.
    * @param value2 A RealNumber to be subtracted from value1.
    * @return A RealNumber that is the result of subtracting value1 and value 2.
    */
  public static RealNumber subtract(RealNumber value1, RealNumber value2) {
    int leftDigits;
    int largerPrecision;
    
    /* Get the number of left digits. */
    if(value1.getData().length - value1.getPrecision() > value2.getData().length - value2.getPrecision()) {
      leftDigits = value1.getData().length - value1.getPrecision();
    } else {
      leftDigits = value2.getData().length - value2.getPrecision();
    }
    
    /* Get the largest precision. */
    if(value1.getPrecision() > value2.getPrecision()) {
      largerPrecision = value1.getPrecision();
    } else {
      largerPrecision = value2.getPrecision();
    }
    
    byte[] data = new byte[leftDigits + largerPrecision];
    
    int index1 = 0;
    int index2 = 0;
    int dataIndex = 0;
    int carry = 0;
    boolean isNegative = false;
    
    if(!value1.isNegative() && !value2.isNegative()) {
      
      if(RealNumber.compare(value1, value2) == 1) {
        isNegative = false;
        
        if(value2.getPrecision() > value1.getPrecision()) {
          while(index2 < value1.getPrecision() - 1) {
            data[dataIndex] = (byte)(10 - value2.getData()[index2] + carry);
            dataIndex++;
            index2++;
            carry = -1;
          }
        } else if(value1.getPrecision() > value2.getPrecision()) {
          while(index1 < value1.getPrecision() - 1) {
            data[dataIndex] = value1.getData()[index1];
            dataIndex++;
            index1++;
          }
        }
        
        while(index1 < value1.getData().length && index2 < value2.getData().length) {
          if(value1.getData()[index1] - value2.getData()[index2] + carry < 0) {
            data[dataIndex] = (byte)(10 - value2.getData()[index2] + carry);
            carry = -1;
          } else {
            data[dataIndex] = (byte)(value1.getData()[index1] - value2.getData()[index2] + carry);
            carry = 0;
          }
          dataIndex++;
          index1++;
          index2++;
        }
      
      } else if(RealNumber.compare(value1, value2) == -1) {
        isNegative = true;
        
        if(value1.getPrecision() > value2.getPrecision()) {
          while(index1 < value2.getPrecision() - 1) {
            data[dataIndex] = (byte)(10 - value1.getData()[index1] + carry);
            dataIndex++;
            index2++;
            carry = -1;
          }
        } else if(value2.getPrecision() > value1.getPrecision()) {
          data[dataIndex] = value2.getData()[index2];
          dataIndex++;
          index2++;
        }
        
        while(index1 < value1.getData().length && index2 < value2.getData().length) {
          if(value2.getData()[index1] - value1.getData()[index2] + carry < 0) {
            data[dataIndex] = (byte)(10 - value1.getData()[index2] + carry);
            carry = -1;
          } else {
            data[dataIndex] = (byte)(value2.getData()[index1] - value1.getData()[index2] + carry);
            carry = 0;
          }
          dataIndex++;
          index1++;
          index2++;
        }
      }
    }
    
    return new RealNumber(largerPrecision, isNegative, data);
  }
      
        
}