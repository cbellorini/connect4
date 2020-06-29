// This class manage all the display in console
public class Display {

  // Methods (here all method are static methods)
  static public void printGreeting(int n){ 
    System.out.println("\nWelcome to Connect "+n);
		System.out.println("There are 3 players red, yellow and blue.");
		System.out.println("You are Red and computers are blue and yellow.");
		System.out.println("To play the game, type in the number of the column you want to drop you counter in.") ;
		System.out.println("A player wins by connecting "+n+" counters in a row - vertically, horizontally or diagonally\n");
  }

  static public void printStartRound(Player player, char[][] board, int numberOfPlayer){
    if (numberOfPlayer == 2){
      printBoard(board);
    }
    System.out.println(player.getName() + ", it's your turn. Please enter a column number:\n");
  }

  // Print the board in a user-friendly format
  static public void printBoard(char[][] board){

    for(int i=0; i<board.length-1; i++){
			for(int j=0; j<board[i].length+1; j++){
  
				if(board[j][i] == 'r' || board[j][i] == 'y'|| board[j][i] == 'b'){
					System.out.print("| "+board[j][i]+" ");
				}
				else{
					System.out.print("|   ");
				}
			}
			System.out.println("|");
		}
		Display.printColumnNumbers(board.length);
  }


  static public void printWinnerName(Player player, Board board){
    printBoard(board.getBoard()); // print board
    System.out.println("Congratulations "+player.getName()+", you've won !");
  }


  static public void printIncorrectInput(){
    System.out.println("The input you've entered is incorrect, please use a number between 1 and 7. Try again:\n");
  }

 
  static public void printFullColumn(Player player){
    if (player instanceof HumanPlayer){
      System.out.println("Sorry this column is full! Enter another column number:");
    }
  }


  static public void printBoardIsFull(){
    System.out.println("The board is full, start another game.");
  }


  static private void printColumnNumbers(int n){
    for(int i = 1; i != n+1;i++){
      System.out.print("  "+i+" ");
    }
    System.out.println("\n");
  }

  static public void printPlayerNumber(){
    System.out.println("How many computer do you want to play with? Please enter 2 or 3:");
  }

  static public void printErrorPlayerNumber(){
    System.out.println("Incorrect Input. Please enter 2 or 3:");
  }
}
