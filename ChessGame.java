/**
 * I'll fix this later.
 * @author Lilith Freed
 */
interface ChessGame {
  
  boolean legalPieceToPlay(ChessPiece piece);
  
  boolean makeMove(ChessPiece piece, int row, int column);
  
  public enum Side { NORTH, SOUTH };
  
}