package mediaRentalManager;


/**
 * This class represents an Album that extends the Media class with 
 * an addition of an artist and songs.
 * 
 * @author JessicaLe
 */
public class Album extends Media{

	private String artist;
	private String songs;

	/**
	 * Constructor that initializes the title, number of 
	 * 	copies available, artist, and song of an album
	 * 
	 * @param title
	 * @param copiesAvailable
	 * @param artist
	 * @param songs 
	 * @return
	 */
	public Album(String title, int copiesAvailable, String artist, String songs) {

		super(title,copiesAvailable);
		this.artist = artist;
		this.songs = songs;
	}

	/**
	 * Returns artist
	 * 
	 * @param artist
	 * @return
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * Returns songs
	 * 
	 * @param songs
	 * @return
	 */
	public String getSongs() {
		return songs;
	}

	/**
	 * Returns String consisting of a title, copies available,
	 * 	artist, and songs in an album
	 * 
	 * @param title
	 * @param copiesAvailable
	 * @param artist
	 * @param songs
	 * @return
	 */
	public String toString() {

		return "Title: " + getTitle() + ", Copies Available: " + 
				getCopiesAvailable() + ", Artist: " + artist + ", Songs: "
				+ songs;

	}


}
