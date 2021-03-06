/**
 * Performs various tasks with matrices.
 * @author Lilith Freed, laf70
 */
public class HW3 {

  /**
   * Removes the indicated row from the input matrix.
   * @param matrix The matrix that will have its row removed.
   * @param row The index of the row to be removed.
   * @return The input matrix with the row removed.
   */
  public static double[][] removeRow(double[][] matrix, int row) {
    double[][] result; // the matrix with the row removed
    if (row > matrix.length - 1 || row < 0) {
      return matrix;
    } else if (matrix.length == 1) {
      result = new double[][]{};
    } else {
      int nRows = matrix.length - 1; // to create the result matrix
      result = new double[nRows][];
      int j = 0; // separate counter for result index
      // Reads the necessary rows of matrix into result  
      for(int i = 0; i < matrix.length; i++) {
        if(i != row ) {
          result[j] = matrix[i];
          ++j;
        }
      }
    }
    return result;
      
  }

  /**
   * Removes the indicated row from the input sparse matrix.
   * @param matrix The sparse matrix that will have its row removed.
   */
    public static SparseMatrix removeRow(SparseMatrix matrix, int row) {
      int[] rowStarts = matrix.getRowStarts();
      int[] nonZeroValues = matrix.getNonZeroValues();
      valuesRemoved = rowStarts[row + 1] - rowStarts[row];
      // Populates the new arrays.
      
      

  
  }
}