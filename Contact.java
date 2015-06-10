/**
 * One object of this class represents
 * information on one Contact. This includes
 * first name, last name, street address, email,
 * phone number and notes. //WW
 */
import java.io.Serializable;
public class Contact implements Serializable{							
	private String firstName, lastName, street,
		    email, phone, notes; //WW
	/**
	 * Constructs contact info
	 */
	public Contact(String firstName, String lastName, String street, String email,
			String phone, String notes) { //WW
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = street;
		this.email = email;
		this.phone = phone;
		this.notes = notes;
	}
	/**
	 * Assigns constants in the firstName String to newFirstName
	 */
	public void setFirstName(String newFirstName){ //WW
		firstName = newFirstName;
	}
	/**
	 * Assigns constants in the lastName String to newLastName
	 */
	public void setLastName(String newLastName){ //WW
		lastName = newLastName;
	}
	/**
	 * Returns the contacts last name
	 */
	public String getLastName(){ //WW
		return lastName;
	}
	/**
	 * Assigns constants in the street String to newStreetAddress
	 */
	public void setStreetAddress(String newStreetAddress){ //WW
		street = newStreetAddress;
	}
	/**
	 * Assigns constants in the email String to newEmail
	 */
	public void setEmail(String newEmail){ //WW
		email = newEmail;
	}
	/**
	 * Assigns constants in the phone String to newPhoneNumber
	 */
	public void setPhoneNumber(String newPhoneNumber){ //WW
		phone = newPhoneNumber;
	}
	/**
	 * Assigns constants in the notes String to newNotes
	 */
	public void setNotes(String newNotes){ //WW
		notes = newNotes;
	}
	/**
	 * Returns a String representation of a contact's info
	 */
	public String toString(){ //WW and RS
		return "\n" + "First name: " + firstName + "\n" + "Last name: "
				+ lastName + "\n" + "Street address: " + street + "\n"
				+ "E-mail address: " + email + "\n" + "Phone number: "
				+ phone + "\n" + "Notes: " + notes + "\n";
	}    	    
}
