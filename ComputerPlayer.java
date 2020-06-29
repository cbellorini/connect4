import java.util.concurrent.ThreadLocalRandom;

public class ComputerPlayer extends Player{
  // Constructor
  public  ComputerPlayer(String name, char color){
    this.name = name;
    this.color = color;
  }
  // Methods
  public String getName(){
    return this.name; // name getter
  }

  public char getColor(){
    return this.color; // color getter
  }

  public String getInput(){
    // Generates a random number between 1 and 8
    int randomNumber = ThreadLocalRandom.current().nextInt(1, 8);
    // returns string of randomNumber
    return Integer.toString(randomNumber);
  }
}
