package mediaRentalManager;

import java.util.*;

public class MediaRentalManager implements MediaRentalManagerInt{


	private ArrayList<Customer> customerTrack;
	private ArrayList<Media> mediaTrack;

	private int limitedPlanMax;

	public MediaRentalManager() {
		this.limitedPlanMax = 2;
		this.customerTrack = new ArrayList<Customer>();
		this.mediaTrack = new ArrayList<Media>();
	}

	@Override
	public void addCustomer(String name, String address, String plan) {

		customerTrack.add(new Customer(name, address, plan));

	}

	@Override
	public void addMovie(String title, int copiesAvailable, String rating) {
		mediaTrack.add(new Movie (title, copiesAvailable, rating));

	}

	@Override
	public void addAlbum(String title, int copiesAvailable, String artist, String songs) {
		mediaTrack.add(new Album(title, copiesAvailable,artist,songs));

	}

	@Override
	public void setLimitedPlanLimit(int value) {
		this.limitedPlanMax = value;

	}

	@Override
	public String getAllCustomersInfo() {

		String allCustInfo = "***** Customers' Information *****\n";

		Collections.sort(customerTrack);

		for (int i = 0; i < customerTrack.size(); i++) {
			allCustInfo += customerTrack.get(i).toString() + "\n";
		}

		return allCustInfo;

	}

	@Override
	public String getAllMediaInfo() {

		String allMedInfo = "***** Media Information *****\n";

		Collections.sort(mediaTrack);

		for (int i = 0; i < mediaTrack.size(); i++) {
			allMedInfo += mediaTrack.get(i).toString() + "\n";
		}

		return allMedInfo;
	}

	@Override
	public boolean addToQueue(String customerName, String mediaTitle) {

		int idx = -1;

		for (int i = 0; i < customerTrack.size(); i++) {
			if (customerTrack.get(i).getName() == customerName) {
				idx = i;
			}
		}

		if (idx == -1) {
			return false;
		}

		for (int i = 0; i < customerTrack.get(idx).getRequest().size(); i++) {
			if (customerTrack.get(idx).getRequest().get(i) == mediaTitle) {
				return false;
			}
		}

		for (int i = 0; i < customerTrack.get(idx).getRented().size(); i++) {
			if (customerTrack.get(idx).getRented().get(i) == mediaTitle) {
				return false;
			}
		}

		for (int i = 0; i < mediaTrack.get(idx).getRequest().size(); i++) {
			if (mediaTrack.get(idx).getTitle() == mediaTitle) {
				return false;
			}
		}

		for (int i = 0; i < mediaTrack.get(idx).getRented().size(); i++) {
			if (mediaTrack.get(idx).getTitle() == mediaTitle) {
				return false;
			}
		}

		customerTrack.get(idx).getRequest().add(mediaTitle);
		return true;

	}

	@Override
	public boolean removeFromQueue(String customerName, String mediaTitle) {

		for (int i = 0; i < customerTrack.size(); i++) {
			if (customerTrack.get(i).getName() == customerName) {
				customerTrack.get(i).getRequest().remove(mediaTitle);
				return true;
			}
		}

		return false;
	}

	@Override
	public String processRequests() {

		String proReq = "";

		Collections.sort(customerTrack);
		


		for (int i = 0; i < customerTrack.size(); i++) {

			Customer cust = customerTrack.get(i);

			int size = cust.getRequest().size();
			int count = 0;
			
	
			if (cust.getPlan().equals("UNLIMITED")) { 

				for (int j = 0; j < size; j++) {

					for (int k = 0; k < mediaTrack.size(); k++) {

						Media med = mediaTrack.get(k);

						String mediaTitle = med.getTitle();


						if (mediaTitle.equals(cust.getRequest().get(count))) {
							if (med.getCopiesAvailable() > 0) {

								cust.getRequest().remove(count);
								cust.getRented().add(mediaTitle);

								med.changeCopiesAvailable(false);

								proReq += "Sending " + 
										mediaTitle + " to " + cust.getName() + "\n";

								size--; 
								j--;
								break;

							} else {
								count++;
							}
						}

					}

				}

			} else if (cust.getPlan().equals("LIMITED")) {

				for (int l = 0; l < size; l++) {

					for (int m = 0; m < mediaTrack.size(); m++) {

						Media med1 = mediaTrack.get(m);

						String mediaTitle1 = med1.getTitle();

						if (mediaTitle1.equals(cust.getRequest().get(count))) {

							if (med1.getCopiesAvailable() > 0) {

								if (cust.getRented().size() < limitedPlanMax) {

									cust.getRequest().remove(count);

									cust.getRented().add(mediaTitle1);

									med1.changeCopiesAvailable(false);

									proReq += "Sending " + 
											mediaTitle1 + " to " + cust.getName() + "\n";

									size--;
									l--;

								}
								break;
							} else {
								count++;
							}

						}
					}

				}

			}

		}

		return proReq;

	}

	@Override
	public boolean returnMedia(String customerName, String mediaTitle) {

		int index = -1;

		for (int i = 0; i < customerTrack.size(); i++) {
			if (customerTrack.get(i).getName().equals(customerName)) {
				index = i;
			}
		}


		if (index == -1) {
			return false;
		}

		Customer c = customerTrack.get(index);

		for (int i = 0; i < c.getRented().size(); i++) {
			if (c.getRented().get(i).equals(mediaTitle)) {

				c.getRented().remove(mediaTitle);

				for (int j = 0; j < mediaTrack.size(); j++) {
					if (mediaTrack.get(j).getTitle().equals(mediaTitle)) {

						mediaTrack.get(j).changeCopiesAvailable(true);
					}
				}

				return true;
			}
		}

		return false;

	}

	@Override
	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) { 

		ArrayList<String> arraySorted = new ArrayList<>();

		boolean checkTitle = false;
		boolean checkRating = false;
		boolean checkArtist = false;
		boolean checkSongs = false;

		for (Media med : mediaTrack) {


			checkTitle = (med.getTitle().equals(title) || title == null);

			if (med instanceof Album) {

				Album alb = (Album) med;

				checkRating = (rating == null);
				checkArtist = (alb.getArtist().equals(artist) || artist == null);
				checkSongs = (songs == null || (alb.getSongs().indexOf(songs) != -1));


			} else if (med instanceof Movie) {

				Movie mov  = (Movie) med;

				checkRating = (mov.getRating().equals(rating) || rating == null);
				checkArtist = (artist == null);
				checkSongs = (songs == null);

			}

			if (checkTitle && checkRating && checkArtist && checkSongs) {
				arraySorted.add(med.getTitle());
			}
		}

		Collections.sort(arraySorted);
		return arraySorted;

	}
}

