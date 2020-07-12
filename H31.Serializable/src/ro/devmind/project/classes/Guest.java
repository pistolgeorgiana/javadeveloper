package ro.devmind.project.classes;

import java.io.Serializable;

public class Guest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String lastName;
	private String firstName;
	private String email;
	private String phoneNumber;
	
	public Guest(String lastName, String firstName, String email, String phoneNumber) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean equalsFirstAndLastName(String name) {
		if (this.firstName == null || this.lastName == null) {
			throw new IllegalArgumentException();
		}
		return ((this.firstName + " " + this.lastName).equalsIgnoreCase(name));
	}
	
	public boolean equalsEmail(String email) {
		if (this.email == null) {
			throw new IllegalArgumentException();
		} 

		return this.email.equalsIgnoreCase(email);
	}
	
	public boolean equalsPhoneNumber(String phoneNumber) {
		if (this.phoneNumber == null) {
			throw new IllegalArgumentException();
		} 
		
		return this.phoneNumber.equals(phoneNumber);
	}
	
	public boolean checkGuest(VerifyMode mode, String key) {
		switch(mode) {
			case NAME:
				return this.equalsFirstAndLastName(key);
			case EMAIL:
				return this.equalsEmail(key);
			case PHONE:
				return this.equalsPhoneNumber(key);
			default:
				return false;
		}
	}
	
	public boolean containsKey(String key) {
		if(this.firstName.toLowerCase().contains(key) || this.lastName.toLowerCase().contains(key)
				|| this.phoneNumber.toLowerCase().contains(key) || this.email.toLowerCase().contains(key)) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Guest other = (Guest) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[" + lastName + " " + firstName + ", " + email + ", "
				+ phoneNumber + "]";
	}	
}
