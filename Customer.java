package mediaRentalManager;
import java.util.ArrayList;


/**
 * This class represents a customer that has a name, address, rental plan,
 *  	and two lists (request and rented)
 *  
 *  @author JessicaLe
 */
public class Customer implements Comparable<Object>{


	private String name;
	private String address;
	private String plan;

	private ArrayList<String> request;
	private ArrayList<String> rented;

	/**
	 * Initializes a Customer name, address, and 
	 * 	plan with "". Requested media and rented media 
	 * 	are initialized with new ArrayList<>();
	 * 
	 * @param name
	 * @param address
	 * @param plan
	 * @param request
	 * @param rented
	 * @return
	 */
	public Customer() {
		this.name = "";
		this.address = "";
		this.plan = "";
		request = new ArrayList<String>();
		rented = new ArrayList<String>();
	}

	/**
	 * Constructor that initializes that Customer with the provided parameters
	 * 
	 * @param name
	 * @param address
	 * @param plan
	 * @return
	 */
	public Customer(String name, String address, String plan) {
		this.name = name;
		this.address = address;
		this.plan = plan;
		request = new ArrayList<String>();
		rented = new ArrayList<String>();
	}

	/**
	 * Constructor that initializes the name of the customer
	 * 
	 *  @param name
	 *  @return
	 */
	public Customer (String name) {
		this.name = name;
		request = new ArrayList<String>();
		rented = new ArrayList<String>();
	}

	/**
	 * Returns customer's name
	 * 
	 * @param name
	 * @return
	 */
	public String getName() {
		return name;

	}

	/**
	 * Returns customer's address
	 * 
	 * @param address
	 * @return
	 */
	public String getAddress() {
		return address;

	}

	/**
	 * Returns customer's plan (either LIMITED or UNLIMITED)
	 * 
	 * @param plan
	 * @return
	 */
	public String getPlan() {
		return plan;

	}

	/**
	 * Returns ArrayList of customer's media request
	 * 
	 * @return request
	 */
	public ArrayList<String> getRequest(){
		return request;
	}


	/**
	 * Returns ArrayList of customer's rented media
	 * @return rented
	 */
	public ArrayList<String> getRented(){
		return rented;
	}

	/**
	 * Returns String consisting of customer's name, address, 
	 * 	plan, rented media, and requested media
	 * 
	 * @param name
	 * @param address
	 * @param plan
	 * @param rented
	 * @param request
	 * @return
	 */

	public String toString() {

		return "Name: " + capitalize(name) + ", Address: " + address + ", Plan: " +
				plan + "\nRented: " + rented + "\nQueue: "
				+ request;

	}


	/**
	 * Returns a negative value if the current object is presents before
	 * 	the parameter in alphabetical order, 0 if the current object is equal 
	 * 	to the parameter, and a positive value otherwise. 
	 * 
	 * @param obj
	 * @return
	 */
	@Override
	public int compareTo(Object obj) {

		Customer cust = (Customer) obj;

		return this.getName().compareTo(cust.getName());
	}

	/**
	 * Returns capitalized String name
	 * 
	 * @param name
	 * @return
	 */
	private String capitalize(String str) {

		char [] string = str.toLowerCase().toCharArray();

		boolean com = true;

		for (int i = 0; i < string.length; i++) {

			if (Character.isLetter(string[i])) {
				if (com) {
					string[i] = Character.toUpperCase(string[i]);
					com = false;
				}
			} else {
				com = true;
			}
		}

		return String.valueOf(string);

	}


}
