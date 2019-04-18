import java.util.HashSet;

/**
 * 
 * @author Dan Sedano
 * @version 4/17/19
 * This class handles most of the features of the game.
 *
 */
public class Game {
	//Instance Variable
	private char[] movieName; 
	private char[] movieGuess;
	//Variables
	//Used a HashSet because it will automatically sort the letters added, it's dynamic, and best of all does not allow duplicates.
	private HashSet<Character> wrongGuess = new HashSet<Character>();
	private int wrongAnswerCounter = 0; //Class "Global"
	private int chancesRemaining = 10;
	
	/**
	 * Constructor received a Movie object then converts the String name of a Movie object
	 * to an array of char. Then, initializes a second array, movieGuess, to the same size
	 * of the movieName array, and fills it with '_' chars.
	 * @param movie
	 */
	public Game(Movie movie) {
		
		movieName = movie.getName().toCharArray();
		//Sets the size of the movieGuess array to that of the movieName array.
		movieGuess = new char[movieName.length];
		
		//Accommodates space characters in a movies name. That is, if a movie name has spaces this will automatically fill in the movieGuess array
		//with the spaces at the appropriate index. Else, the indexes will be filled with '_' characters.
		for(int x = 0; x < movieGuess.length; x++) {
			if(movieName[x] == ' ')
				movieGuess[x] = ' ';
			else
				movieGuess[x] = '_';
		}
				
	}
	
	/**
	 * Prints out the movieGuess array with spaces between each element.
	 */
	public void printGuess() {
		//Regular for loop because I still have a hard time with for each loops :/
		for(int x = 0; x < movieGuess.length; x++) {
			System.out.print(movieGuess[x] + " ");		
			}
		System.out.println("\n");
	}
	
	/**
	 * Prints out the incorrect guesses.
	 */
	public void printWrongGuess() {
		
		System.out.print("Wrong Guesses: " + wrongGuess + "\n");
	}
	
	/**
	 * Handles the guess inputed by a player:
	 * Converts lower case input to upper case.
	 * Matches the input to each element in the movieName array.
	 * If it finds a match, it will add the match to the same position in the movieGuess array.
	 * @param input
	 */
	public void guess(char input) {
		
		Boolean correctGuess = false; //Checks for
		
		if(Character.isLowerCase(input)) {
			input = Character.toUpperCase(input);
		}
		
		for(int x = 0; x < movieName.length; x++) {
			if(input == movieName[x]) {
				movieGuess[x] = input;
				correctGuess = true;
			}
		}
		if(correctGuess == false) {
			wrongGuess.add(input);
			wrongAnswerCounter++;
			chancesRemaining--;
			System.out.println("Chances Remaining: " + chancesRemaining);
			printWrongGuess();
		}
	}
	
	/**
	 * Returns the chances remaining.
	 * @return the chances remaining.
	 */
	public int getChancesRemaining() {
		return chancesRemaining;
	}
	
	/**
	 * Used to determine if the player has finished guessing the movie's name.
	 * @return true or false
	 */
	public boolean isDone() {
		int count = 0;
		//Checks the movieGuess array for '_' characters. If there are none we can safely assume the player has finished.
		for(int x = 0; x < movieGuess.length; x++) {
			if(movieGuess[x] == '_')	{
				count++;
			}
		}
		//used a counter to avoid premature (i.e., before finishing the array traversal) true or false.
		if(count > 0)
			return false;	
		else
			return true;
	}
	
	/**
	 * Used to determine if the player has won or lost the game.
	 */
	public void winLose() {
		int count = 0;
		String stringMovieName = String.valueOf(movieName); // converts the array back to a string for the purpose of printing out the answer.
		
		for(int x = 0; x < movieName.length; x++) {
			if(movieGuess[x] == '_') {
				count++;
			}
		}
		if(count > 0) {
			System.out.println("You Lose!");
			System.out.println("Answer: "+ stringMovieName);
		}
		else
			System.out.println("You Win!");
		
		System.exit(0);
	}
}
