
// To start a game with a custom N (where 2 <= N <= 7), please use the open shell
// and type 'java Main "N"' (e.g 'java Main "6"')

class Main {
  public static void main(String[] args) {
  // if no arguments have been given, take 4 as value of N.
  if(args.length == 0){
      int winCondition = 4;
      Game game = new Game(winCondition);
      game.play();
    }
    else{
      // take input from open shell as winCondition
      int winCondition = Integer.parseInt(args[0]);
      Game game = new Game(winCondition);
      game.play();
    }
  }
}
