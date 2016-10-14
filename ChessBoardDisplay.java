import javax.swing.*;
  
/** Get rekt nerd.
  * @author Lilith Freed.
  */
interface ChessBoardDisplay {
  
  void displayEmptySquare(JButton square, int row, int column);
  
  void displayFilledSquare(JButton square, int row, int column, ChessPiece piece);
  
  void highlightSquare(boolean highlightOn, JButton square, int row, int column, ChessPiece piece);

}
  