import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * I came across this challenge in a Udacity course. At first I believed it was too difficult to even attempt. After a week or so the solution 
 * just came to me. I was able to code a working version within 2 hours and and fine tune it after another 3 hours, spread out through a couple of days.
 * The game essentially reads a list of movies from a file, and then randomly selects a movie. It will then create two char arrays, of the same size, one
 * for the String movieName (converted to a char array), and the second for the player to fill in with their guesses. As the player enters the correct guess the second array, 
 * movieGuess, will be filled in with the correct letters in the correct indexes. 
 * 
 * @author Dan Sedano
 * @version 4/18/19
 *
 */
public class Main {
	
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		//Variables
		String movieName = pickRandomMovieFromFile();
		//Objects
		Movie movie = new Movie(movieName);
		Game game = new Game(movie);
		char input = 0; 
		
		System.out.println("Guess the Movie's name!");
		game.printGuess();
		
		//Runs until the player runs out of chances.
		while(game.getChancesRemaining() != 0) {
			System.out.print("Enter a Letter: ");
			
			input = in.next().charAt(0);
			game.guess(input);
			game.printGuess();
			//If the player has guessed all the letters then the game calls the winLose method.
			if(game.isDone() == true) {
				game.winLose();
			}
		}
		//if the player has ran out of chances the game calls the winLose method.
		game.winLose();
	}
	/**
	 * This method reads from a file then adds the list of lines into an ArrayList and then randomly selects a movie name.
	 * @return a randomly read movie name.
	 */
	static String pickRandomMovieFromFile() throws Exception{
		
		//Variables
		String file = "C:\\Users\\dseda\\eclipse-workspace\\Movie Guessing\\src\\MovieNames.txt";
		String movieName;
		
		//Object to read from file
		BufferedReader fileReader = new BufferedReader(new FileReader(file));
		
		//A container for the movie names
		ArrayList<String> movieList = new ArrayList<String>();
		
		//A temp String to hold a line being read.
		String fileLine;
		
		//reads from a file, line by line, then adds each line to the ArrayList
		while((fileLine = fileReader.readLine()) != null) {
			//fileLine = fileReader.readLine();
			movieList.add(fileLine);
		}
		
		//Random object to randomly select an element in the ArrayList
		Random random = new Random();
		int randomIndex = movieList.size();
		
		//Selects a random element in the Array
		movieName = movieList.get(random.nextInt(randomIndex));

		return movieName;
	}
}
