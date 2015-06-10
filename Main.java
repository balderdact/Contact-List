/**
 * Tests class ContactList by creating
 * an object for it and calls its methods
 * based on user selection. //RS 
 */
import java.util.Scanner;
import java.io.*;
public class Main{
	public static void main(String[] args) throws IOException{ //JJ
		int choose; //RS
		boolean programKeepGoing = true; //RS
		Scanner scanner = new Scanner(System.in); //RS
		ContactList list = new ContactList(); //RS
		String file = "ContactList.dat"; //JJ
		list.readFromDisk(file); //JJ
		while (programKeepGoing == true) { //RS and JJ
			System.out.println("\n"+"[1] Add contact");
			System.out.println("[2] View all contacts");
			System.out.println("[3] Find contact by last name");
			System.out.println("[4] Exit and Save");
			System.out.print("Choose: ");
			choose = scanner.nextInt();
        	switch (choose) { //JJ and RS
           		case 1: list.addContact();
           				break;
           		case 2: list.viewContacts();
           				break;
           		case 3: list.findContact();
           				break;
           		case 4: list.saveToDisk(file);
           				programKeepGoing = false;
           				break;
           		default: System.out.println("Error, choices must"
           				+ " be from 1-4");
        	}
        }
	}
}
