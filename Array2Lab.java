/**
 * A collection of methods related to multi-dimensional arrays.
 */
public class Array2Lab {

  /**
   * Return whether k is in list.
   * Precondition: the elements of list are not null.
   * @param list the array to be searched.
   * @param k the number to search for.
   * @throws IllegalArgumentException if the elements of the array are null.
   * @return  true if k is an element of list, and false otherwise.
   */
  public static boolean contains(Object[][] list, Object k) {
    if(list == null) {
      throw new IllegalArgumentException("Elements of array cannot be null.");
    } else {
      for(int i = 0; i < list.length; i++) {
        for(int j = 0; j < list[i].length; j++) {
          if(list[i][j].equals(k)) {
            return true;
          }
        }
      }
      return false;
    }
          
  }
  
  /**
   * Create a String that has the contents of list.   Each row of list should be on a separate line,
   * separated by spaces, and surrounded by { and }.
   * The first line of of the output should start with an additional {, each other line of the output
   * should start with a space, and the last line of the output should have an additional {.
   * For example: {{1, 2}, {3, 4}} should be formatted in the String as:
   *  {{1 2}
   *   {3 4}}
   * @param list the array to print.
   * @return  the elements of the array, separated by spaces, and surrounded by { and }, with each row on a separate line.
   */
  public static String arrayToString(int[][] list) {
    StringBuilder sb = new StringBuilder();
    if(list.length > 1) {
      for(int i = 0; i < list.length; i++) {
        if(list[i].length == 0) {
          sb.append(" {}\n");
        } else {
          for(int j = 0; j < list[i].length; j++) {
            if(i == 0 && j == 0) {
              sb.append("{{");
              sb.append(Integer.toString(list[i][j]));
              sb.append(' ');
            } else if(i == list.length - 1 && j == list[i].length - 1) {
              if(list[i].length == 1) {
                sb.append(" {");
              }
              sb.append(Integer.toString(list[i][j]));
              sb.append("}}");
            } else if(j == list[i].length - 1) {
              sb.append(Integer.toString(list[i][j]));
              sb.append("}\n");
            } else if(j == 0) {
              sb.append(" {");
              sb.append(Integer.toString(list[i][j]));
              sb.append(' ');
            } else {
              sb.append(Integer.toString(list[i][j]));
              sb.append(' ');
          } 
        }
        }
      }
    } else if(list.length == 0) {
      sb.append("{}");
    } else if(list.length == 1) {
      sb.append("{{");
      sb.append(Integer.toString(list[0][0]));
      sb.append("}}");
    } else {
      return null;
    }
    String result = sb.toString();
    return result;  
  }

  /**
   * Create a new array that "flips" a rectangular region of matrix about the diagonal.  So, each row of the output should be a column of the input.
   * Precondition: The region of matrix[rowStart...rowEnd][colStart...colEnd] exists.
   * @param matrix  the input two dimensional array.
   * @param rowStart  the index of the first row of the rectangular region to flip.
   * @param rowEnd    the index of the last row of the rectangular region to flip.
   * @param colStart  the index of the first column of the rectangular region to flip.
   * @param colEnd    the index of the last column of the rectangular region to flip.
   */
  public static int[][] transpose(int[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd) {
    int[][] array = new int[(rowEnd - rowStart) + 1][];
    if(matrix != null) {
    for(int j = colStart; j < colEnd + 1; j++) {
      int r = 0;
      for(int i = rowStart; i < rowEnd + 1; i++) {
        int k = 0;
        int[] rowArray = new int[(colEnd - colStart) + 1];
        rowArray[k] = matrix[i][j];
        ++k;
        array[r] = rowArray;
      }
      ++r;
    }
    return array;
    } else {
    return null;
    }
  }

  /**
   * Creates a new array that is a copy of the input matrix, except that one row and one column have been removed.
   * Precondition: the row index is between 0 (inclusive) and the number of rows of matrix (not inclusive)
   * @param matrix  the input two dimensional array
   * @param row   the index of the row to remove
   * @param col   the index of the column to remove
   */
  public static int[][] removeRowAndCol(int[][] matrix, int row, int col) {
    return null;
  }
}
