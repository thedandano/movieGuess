/**
 * 
 * @author Dan Sedano
 * @version 4/17/19
 * Movie Object
 *
 */
public class Movie {
	//Instance Variable
	private String movieName;
	
	/**
	 * Constructor
	 * @param movieName
	 */
	Movie(String movieName){
		this.movieName = movieName;
	}
	
	/**
	 * Used to get the name of the movie.
	 * @return the name of the movie.
	 */
	public String getName() {
		return movieName;
	}
}
