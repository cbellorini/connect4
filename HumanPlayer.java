import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HumanPlayer extends Player{

  // input from stream
  private BufferedReader input;

  // Constructor 
  public HumanPlayer() {
    this.name = "Human";
    this.color = 'r';
  }

  // Methods
  public String getName(){
    return this.name; 
  }

  public char getColor(){ 
    return this.color;
  }

  // Get user input from System.in
  public String getInput(){
    input = new BufferedReader(new InputStreamReader(System.in));
		String toReturn = null;
		try{			
			toReturn = input.readLine();
		}
		catch(Exception e){
			
		}
		return toReturn;
	}
}
