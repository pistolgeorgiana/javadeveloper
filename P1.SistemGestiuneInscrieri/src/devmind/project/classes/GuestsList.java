package devmind.project.classes;

import java.util.ArrayList;
import java.util.List;

public class GuestsList {
	private int availableSeats;
	private List<Guest> listParticipants;
	private List<Guest> waitingList;
	
	public GuestsList(int availableSeats) {
		this.availableSeats = availableSeats;
		this.listParticipants = new ArrayList<Guest>();
		this.waitingList = new ArrayList<Guest>();
	}

	public GuestsList(int availableSeats, List<Guest> listParticipants, List<Guest> waitingList) {
		this.availableSeats = availableSeats;
		this.listParticipants = listParticipants;
		this.waitingList = waitingList;
	}

	private boolean searchGuest(VerifyMode mode, String key) {
		for(Guest g : listParticipants) {
			if(g.checkGuest(mode, key)) {
				return true;
			}
		}
		
		for(Guest g : waitingList) {
			if(g.checkGuest(mode, key)) {
				return true;
			}
		}
		
		return false;
	}
	
	public int addPerson(VerifyMode mode, String lastName, String firstName, String email, String phoneNumber) {
		String key = "";
		System.out.print("[" + firstName + " " + lastName + "] ");
		
		if (mode == VerifyMode.NAME) {
			key = firstName + " " + lastName;
		} else if (mode == VerifyMode.EMAIL) {
			key = email;
		} else {
			key = phoneNumber;
		}
		
		if(searchGuest(mode, key)) {
			System.out.println("Esti deja inscris!");
			return -1;
		}
		
		Guest guest = new Guest(lastName, firstName, email, phoneNumber);
		if (availableSeats == listParticipants.size()) {
			waitingList.add(guest);
			System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine "  
					+ waitingList.size() + ". Te vom notifica daca un loc devine disponibil.");
			return waitingList.size() - 1;
		} else {
			listParticipants.add(guest);
			System.out.println("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
			return 1;
		}
	}
	
	public boolean isEnrolled(VerifyMode mode, String key) {
		return searchGuest(mode, key);
	}
	
	public boolean removeGuest(VerifyMode mode, String key) {
		boolean res = false;
		
		for(int i=0; i<waitingList.size(); i++) {
			if(waitingList.get(i).checkGuest(mode, key)) {
				waitingList.remove(i);
				res = true;
			}
		}
		
		for(int i=0; i<listParticipants.size(); i++) {
			if(listParticipants.get(i).checkGuest(mode, key)) {
				listParticipants.remove(i);
				if(waitingList.size() > 0) {
					System.out.println("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
					listParticipants.add(waitingList.remove(0));
				}
				res = true;
			}
		}
		
		return res;
	}
	
	public void updateGuest(VerifyMode mode, String key, VerifyMode change, String value) {
		for(int i=0; i<waitingList.size(); i++) {
			if(waitingList.get(i).checkGuest(mode, key)) {
				if (change == VerifyMode.NAME) {
					waitingList.get(i).setLastName(value);
				} else if (change == VerifyMode.EMAIL) {
					waitingList.get(i).setEmail(value);
				} else {
					waitingList.get(i).setPhoneNumber(value);
				}
				break;
			}
		}
		
		for(int i=0; i<listParticipants.size(); i++) {
			if(listParticipants.get(i).checkGuest(mode, key)) {
				if (change == VerifyMode.NAME) {
					listParticipants.get(i).setLastName(value);
				} else if (change == VerifyMode.EMAIL) {
					listParticipants.get(i).setEmail(value);
				} else {
					listParticipants.get(i).setPhoneNumber(value);
				}
				break;
			}
		}	
	}

	public int getAvailableSeats() {
		return availableSeats - this.listParticipants.size();
	}

	public List<Guest> getListParticipants() {
		return listParticipants;
	}

	public List<Guest> getWaitingList() {
		return waitingList;
	}
	
	public int getParticipantsNo() {
		return this.listParticipants.size();
	}
	
	public int getWaitingNo() {
		return this.waitingList.size();
	}
	
	public int getTotalNo() {
		return this.listParticipants.size() + this.waitingList.size();
	}
	
	public List<Guest> searchGuest(String key) {
		List<Guest> filtered = new ArrayList<Guest>();
		
		for(Guest g : listParticipants) {
			if(g.containsKey(key.toLowerCase())) {
				filtered.add(g);
			}
		}
		
		for(Guest g : waitingList) {
			if(g.containsKey(key.toLowerCase())) {
				filtered.add(g);
			}
		}
		
		return filtered;
	}	
	
}
