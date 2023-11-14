package mediaRentalManager;

import java.util.ArrayList;

/**
 * This class represents a Media that
 * has a title and number of copies available
 * 
 * @author JessicaLe
 */
public class Media implements Comparable<Object>{


	private String title;
	private int copiesAvailable;
	private ArrayList<String> request;
	private ArrayList<String> rented;

	/**
	 * Constructor that initializes the title, 
	 * 	number of copies available of a media
	 * 
	 * @param title
	 * @param copiesAvailable
	 * @return
	 * 
	 */
	public Media (String title, int copiesAvailable) {
		this.title = title;
		this.copiesAvailable = copiesAvailable;
		request = new ArrayList<String>();
		rented = new ArrayList<String>();
	}

	/**
	 * Returns a title
	 * 
	 * @param title
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Returns number of copies available
	 * 
	 * @param copiesAvailable
	 * @return
	 */
	public int getCopiesAvailable() {
		return copiesAvailable;
	}


	/**
	 * Returns true if copies available decrease
	 * 
	 * @param add
	 * @return
	 */
	public void changeCopiesAvailable(boolean add) {
		if (add) {
			this.copiesAvailable++;
		} else {
			this.copiesAvailable--;
		}
	}

	/**
	 * Returns a negative value if the current 
	 * 	object is presents before the parameter in alphabetical 
	 * 	order, 0 if the current object is equal 
	 * 	to the parameter, and a positive value otherwise 
	 * 
	 * @param obj
	 * @return
	 */
	@Override
	public int compareTo(Object obj) {
		Media med = (Media) obj;

		return this.getTitle().compareTo(med.getTitle());
	}

	/**
	 * Returns String consisting of a title and copies 
	 * 	available in a Media (either album or movie)
	 * 
	 * @param title
	 * @param copiesAvailable
	 * @return
	 */
	public String toString() {
		return "Title: " + title + ", Copies: " + 
				copiesAvailable;
	}

	/**
	 * Returns ArrayList of rented media
	 * 
	 * @return rented
	 */
	public ArrayList<String> getRented() {
		return rented;
	}


	/**
	 * Returns ArrayList of requested media
	 * 
	 * @return request
	 */
	public ArrayList<String> getRequest() {
		return request;
	}
}
