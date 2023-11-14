package mediaRentalManager;

/**
 * This class represents a Movie that extends the Media class with 
 * an addition of a rating.
 * 
 * @author JessicaLe
 */
public class Movie extends Media{

	private String rating;

	/**
	 * Constructor that initializes the title, number of copies available,
	 * and rating of a movie
	 * 
	 * @param title
	 * @param copiesAvailable
	 * @param rating
	 * @return
	 */
	public Movie(String title, int copiesAvailable, String rating) {

		super(title, copiesAvailable);
		this.rating = rating;

	}

	/**
	 * Returns rating
	 * 
	 * @param rating
	 * @return
	 */
	public String getRating() {
		return rating;

	}

	/**
	 * Returns String consisting of a title, copies available,
	 *  and rating of a movie
	 *  
	 * @param title
	 * @param copiesAvailable
	 * @param rating
	 * @return
	 */
	public String toString() {
		return "Title: " + getTitle() + ", Copies Available: " + 
				getCopiesAvailable() + ", Rating: " + rating;
	}

}
