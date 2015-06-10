/**
 * One object of this class represents a list of contacts 
 * each with their own information. //RS
 */
import java.util.*;
import java.io.*;
public class ContactList implements Serializable, Comparator<Contact>{
	private Scanner scanner = new Scanner(System.in); //RS
	private List<Contact> contactList = new ArrayList<Contact>(); //JJ
	/**
	 * Adds a contact to the array of contacts from user input.
	 */
	public void addContact() { //JJ and RS
		String firstName = "", lastName = "", street = "", 
				email = "", phone = "", notes = "";
		System.out.print("First name: ");
		firstName = scanner.nextLine();
		System.out.print("Last name: ");
		lastName = scanner.nextLine();
		System.out.print("Street address: ");
		street = scanner.nextLine();
		System.out.print("E-mail address: ");
		email = scanner.nextLine();
		System.out.print("Phone number: ");
		phone = scanner.nextLine();
		System.out.print("Notes: ");
		notes = scanner.nextLine();
		if (lastName.length() == 0) {
			System.out.println("Last name is needed, try again");
		}
		else {
			Contact contact = new Contact(firstName, lastName, street, email,
				phone, notes);
			contactList.add(contact);
			System.out.println("Contact added successfully!");
		}
	}
	/**
	 * Prints the entire array of contacts in alphabetical order
	 * according to last name.
	 */
	public void viewContacts() { //RS and JJ
		Collections.sort(contactList, new ContactList());
		if (contactList.size() == 0) {
			System.out.println("No contacts exist");
		}
		else {
			for (int index = 0; index < contactList.size(); index++) {
				System.out.print(contactList.get(index));
			}
		}	
	}
    /**
     * Compares contact objects from the array of contacts.
     */
	public int compare(Contact person1, Contact person2) { //WW
        return person1.getLastName().compareTo(person2.getLastName());
    }
	/**
	 * Prints the contacts with the specified last name 
	 * if they exist. 
	 */
	public void findContact(){ //WW, RS and JJ
		System.out.print("Last name: ");
		String search = scanner.nextLine();
		int noContact = 0;					
		if (contactList.size() != 0){
			for (Contact contact : contactList) {
				if(contact.getLastName() != null && 
						contact.getLastName().contains(search)) {
					System.out.print(contact);
					++noContact;
				}
			}
		}
		else{
			System.out.print("No contacts are listed on the file.");					
		}
		if(noContact<1){																
			System.out.println("\nNo contact was found with this last name.");
		}
	}
	/**
	 * Saves the contact list object to disk.
	 */
    public void saveToDisk(String fileName) throws IOException{ //JJ and RS
    	File outFile = new File(fileName);
    	FileOutputStream outFileStream;
    	ObjectOutputStream outObject;
    	try {
    		outFileStream = new FileOutputStream (outFile);
    		outObject = new ObjectOutputStream (outFileStream);
    		outObject.writeObject(contactList);
    		outFileStream.close();
    		outObject.close();
    		System.out.println("The list of contacts has been saved successfully!");
    	}
    	catch (IOException ioe) {
    		System.out.println ("Error writing objects to the file: "
    				+ ioe.getMessage());
    	}
    }  
    /**
     * Loads the contact list object from an existing file.
     */
	public void readFromDisk(String fileName) throws IOException{ //JJ and RS
		FileInputStream inFileStream;
    	ObjectInputStream inObject;
       	try {
    		File inFile = new File(fileName);
    		if(inFile.exists()){
    			System.out.println("The file " + fileName +
    					" has been found and loaded successfully!");
    			inFileStream = new FileInputStream (inFile);
    			inObject = new ObjectInputStream(inFileStream);
    			contactList = (List<Contact>) inObject.readObject();
    			inFileStream.close();
    			inObject.close();
       		}
    		else {
    			System.out.println("No file exists, please create a new contact list");
    		}
    	}
    	catch (ClassNotFoundException cnfe) {
    		System.out.println ("Error in casting to ContactList: "
    				+ cnfe);
    	}
	}
}
