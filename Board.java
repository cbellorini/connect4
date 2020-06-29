//this class represents the board game.

public class Board {
  // Fields
  private char[][] boardGame;

  // Constructor
  public Board(){
    this.boardGame = new char[7][6];
  }

  // Methods

  // Place the counter on the board
  public void placeCounter(int position, Player player){ 
    if (position < 1|| position > 7) {
      throw new NumberFormatException();
    } else {
      int counter = 0;
      while( counter < 6 && (boardGame[position-1][counter] != 'r' && boardGame[position-1][counter] != 'y' && boardGame[position-1][counter] != 'b')){
        counter++;
      }
      boardGame[position-1][counter-1] = player.getColor();
    }
  }

  // Retrieve the board array
  public char[][] getBoard(){
    return this.boardGame;
  }
}
