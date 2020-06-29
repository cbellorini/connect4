import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Game {
  // Fields
  private Board board;
  private HumanPlayer player;
  private ComputerPlayer computer1;
  private ComputerPlayer computer2;
  private boolean isOver; over
  private int playerCount; 
  private int numberN; // Win condition

  
  // Constructor
  public Game(int n){
    this.board = new Board();
    this.player = new HumanPlayer();
    this.computer1 = new ComputerPlayer("Computer 1",'y');
    this.computer2 = new ComputerPlayer("Computer 2",'b');
    this.playerCount = 1;
    this.numberN = n; 
  }

  // Methods

  //Wrapper function 
  public void play(){

    int totalRound = 42; // max number of rounds

    // Welcome message + get number of players
    Display.printGreeting(numberN); 
    Display.printBoard(board.getBoard());
    Player currentPlayer = player; 
    Display.printPlayerNumber();
    int nbOfPlayer= getNumberOfPlayer();

    // While game is has no winner and board is not full
    while (!isOver && totalRound != 0){
      // Get current_player
      currentPlayer = getCorrectPlayer(nbOfPlayer);
      if (currentPlayer instanceof HumanPlayer){
        Display.printStartRound(currentPlayer,board.getBoard(), nbOfPlayer); 
      }
      // Fet user input
      getUserInput(currentPlayer);
      // Check if game is over.
      isOver = win(numberN,board.getBoard(),currentPlayer);
      totalRound--; 
    }
    if (isOver){ 
      Display.printWinnerName(currentPlayer, board); 
    } else {
      Display.printBoardIsFull(); 
    }
  }

  //get the number of player by asking it to the user
  private int getNumberOfPlayer(){
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    String nb = "0";
    try {
      nb = input.readLine();
    }
		catch(Exception e){

		}
    int playerNumber = 0;
    try {
      playerNumber = Integer.parseInt(nb);
      // Handle wrong input
    } catch (NumberFormatException e){
      Display.printErrorPlayerNumber();
      getNumberOfPlayer();
    }
    if (playerNumber ==2 || playerNumber == 3){
      return playerNumber;
    } else {
      Display.printErrorPlayerNumber();
      getNumberOfPlayer();
    }
    return 2;
  }

  // Retrieve the Player object who should play
  private Player getCorrectPlayer(int numberOfPlayer){
    if (playerCount == 1){
      playerCount++;
      return player;
    } else if(playerCount == 2){
      playerCount++;
      return computer1;
    } else if (playerCount == 3 && numberOfPlayer == 3){
      playerCount = 1;
      return computer2;
    } else if(playerCount == 3 && numberOfPlayer == 2) {
      playerCount = 2;
      return player;
    } else {
      return player;
    }
  }

  // Get user Input from current_player (human or computer)
  private void getUserInput(Player currentPlayer){
    try {
        // Parse current_player inout in int
        int position = Integer.parseInt(currentPlayer.getInput());
        // Place counter on board according to input
        board.placeCounter(position,currentPlayer);
        // if player is the last computer then print board
        if (currentPlayer == computer2) {
          Display.printBoard(board.getBoard());
        }
    } catch (NumberFormatException e) {
        Display.printIncorrectInput();
        getUserInput(currentPlayer);

    } catch (ArrayIndexOutOfBoundsException e){
        Display.printFullColumn(currentPlayer);
        getUserInput(currentPlayer);
    }
  }

  // Check whether the game is won or not.
  private boolean win(int n, char[][] board, Player player){

    if(horizontalWin(n, board, player) || verticalWin(n, board, player) || ascendingWin(n, board, player) || descendingWin(n, board, player) ){
      return true;
    } else {
      return false;
    }
  }

  // check wether a user has a horizontal win (N counters in a row horizontally).
  private boolean horizontalWin(int n, char[][] board, Player player){
    int count = 0;
		for(int i=0; i<board[0].length; i++){
			for(int j=0; j<board.length; j++){
				if(board[j][i] == player.getColor()){
					count++;
        } else {
          count = 0;
        }
				if(count >= n){
          System.out.println("HW");
					return true;
        }
      }
    }
    return false;
  }

  // check wether a user has a vertical win (N counters in a row vertically or not.
  private boolean verticalWin(int n, char[][] board, Player player){
    int count = 0;
    for(int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){
				if(board[i][j] == player.getColor()){
					count++;
          
        } else {
          count = 0;
        }
				if(count >= n){
          System.out.println("VW");
					return true;
        }
			} 
    }
    return false;
  }

  // Check wether a user has a diagonal win with N counters in a row diagonally and asc or not .
  private boolean ascendingWin(int n, char[][] board, Player player){
    for (int i = 0; i<board.length; i++){
      for (int j = board[i].length-1; j > -1; j--){
        try {
          if (checkAscending(board, i, j, player, n)) {
            return true;
          }
        } catch (ArrayIndexOutOfBoundsException e){
          continue;
        }
      }
    }
    return false;
  }

  // Check wether a user has a diagonal win with N counters in a row diagonally and desc or not .
  private boolean descendingWin(int n, char[][] board, Player player){
    for (int i = 0; i<board.length; i++){
      for (int j = board[i].length-1; j > -1; j--){
        try {

          if (checkDescending(board, i, j, player, n)){
            return true;
          }
        } catch (ArrayIndexOutOfBoundsException e){
          continue;
        }
      }
    }

    return false;
  }

  // Check whether from a given index, there is ascending  diagonal win for a given player
  private boolean checkAscending(char[][] board, int i, int j, Player player, int numberN){
    int count = numberN; 
    for(int k=0; i < numberN; k++){

      if (board[i+k][j-k] == player.getColor()){
        count--; 
        if (count == 0){
          return true;
        }
      } else {
        return false;
      }
    }
    return false;
  }

  // Check whether from a given index, there is descending  diagonal win for a given player.
  private boolean checkDescending(char[][] board, int i, int j, Player player, int numberN){
    int count = numberN;  
    for(int k=0; k < numberN; k++){

      if (board[i+k][j+k] == player.getColor()){
        count--; 
        if (count == 0){
          return true;
        }
      } else {
        return false;
      }
    }
    return false;
  }

}
