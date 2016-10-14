import java.lang.IllegalArgumentException;
import javax.swing.*;

/**
 * Class for the object SparseMatrix
 * @author Lilith Freed, laf70
 */
public class SparseMatrix {
  
  /** 
   * Initialize arrays for values (shortened to initials for names)
   */
  private double[] nZV;
  private int[] cP;
  private int[] rS;
  
  /** 
   * Constructor for Sparse Matrix (with array inputs)
   * @param nonZeroValues The double array of non zero values in the matrix.
   * @param columnPositions The column positions of those non zero values.
   * @param rowStarts The i to, but not including, i + 1 indices of the non zero values contained in each row.
   */
  public SparseMatrix(double[] nonZeroValues, int[] columnPositions, int[] rowStarts) throws IllegalArgumentException {
    if(nonZeroValues.length != columnPositions.length || rowStarts[0] != 0 || rowStarts.length == 0 || rowStarts[rowStarts.length - 1] != nonZeroValues.length) {
      throw new IllegalArgumentException();
    } else {
      // Check for negative indices
      for(int i = 0; i < columnPositions.length; i++) {
        if(columnPositions[i] < 0) {
          throw new IllegalArgumentException();
        }
      }
      // Check for negative or non-ascending row starts
      for(int i = 0; i < rowStarts.length; i++) {
        if(rowStarts[i] < 0) {
          throw new IllegalArgumentException();
        }
        if(i != 0){
          if(rowStarts[i] < rowStarts[i - 1]) {
            throw new IllegalArgumentException();
          }
        }
      }
    }
    this.nZV = nonZeroValues;
    this.cP = columnPositions;
    this.rS = rowStarts;
  }

  
  /** 
   * Constructor for Sparse Matrix (with double matrix input)
   * @param matrix The double matrix to be converted to sparse representation.
   */
  public SparseMatrix(double[][] matrix) {
    if(matrix.length == 0) {
      this.nZV = new double[]{};
      this.cP = new int[]{};
      this.rS = new int[]{};
    } else {
      int nzvCounter = 0;
      for(int i = 0; i < matrix.length; i++) {
        for(int j = 0; j < matrix[i].length; j++) {
          if(matrix[i][j] != 0) {
            ++nzvCounter;
          }
        }
      }
      double[] nonZeroValues = new double[nzvCounter];
      int[] columnPositions = new int[nzvCounter];
      int[] rowStarts = new int[matrix.length + 1];
      // Loop to fill arrays
      nzvCounter = 0;
      rowStarts[0] = 0;
      for(int i = 0; i < matrix.length; i++) {
        for(int j = 0; j < matrix[i].length; j++) {
          if(matrix[i][j] != 0) {
            nonZeroValues[nzvCounter] = matrix[i][j];
            columnPositions[nzvCounter] = j;
            ++nzvCounter;
          }
        }
      rowStarts[i+1] = nzvCounter; 
    }
      this.nZV = nonZeroValues;
      this.cP = columnPositions;
      this.rS = rowStarts;
  }
  }
  
  /**
   * Getter method for non-zero-values.
   * @return array The array of NZV.
   */
  public double[] getNonZeroValues() {
   return this.nZV;
  }


  /**
   * Getter method for column positions.
   * @return array The array of CP.
   */
  public int[] getColumnPositions() {
   return this.cP;
 }
 
  /**
   * Getter method for column positions.
   * @return array The array of RS.
   */
  public int[] getRowStarts() {
   return this.rS;
 }
  
  /**
   * Returns a full, non-truncated matrix based on the value arrays.
   * (Currently non-operational.)
   * @return matrix The full matrix with all zero values.
   */
  public double[][] getFullMatrix() {
    int columnLength = this.getMaxValue() + 1;
    double[][] matrix = new double[this.rS.length - 1][columnLength];
    // Populates matrix
    int rowCounter = 0;
    for(int i = 0; i < this.nZV.length; i++) {
      if(rowCounter != this.rS.length - 1) {
         for(int j = rowCounter; j <= (this.rS[rowCounter + 1] - this.rS[rowCounter]); j++) {
         matrix[i][this.cP[i]] = this.nZV[i];
        } else {
          for(int j = rowCounter; (this.rS[rowCounter + 1] - this.rS[rowCounter])
          
      
    return matrix;
  }
        
        
  /**
   * Helper method for determining max value of the cP array.
   * @return maxValue The max value of the cP array.
   */
   private int getMaxValue() {
   int maxValue = this.cP[0];
   // Determines max value of array
   for(int i = 1; i < this.cP.length; i++) {
     if(maxValue < this.cP[i]) {
        maxValue = this.cP[i];
     }
   }
   return maxValue;
  }
  

}

      
        
    
  
    

