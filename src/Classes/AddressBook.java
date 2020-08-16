package Classes;
import java.util.ArrayList;

import MainFrames.AddressBookSelection;

public class AddressBook {
	//har AddressBook i az 
	int ID;
	String name;
	public static int count = 0;
	ArrayList<Contact> contacts = new ArrayList<Contact>();
	ArrayList<Group> groups = new ArrayList<Group>();
	ArrayList<Location> locations = new ArrayList<Location>();

	public AddressBook() {
		count++;
	}

	public AddressBook(int id, String name, ArrayList<Contact> contacts, ArrayList<Group> groups,
			ArrayList<Location> locations) {
		ID = id;
		this.name = name;
		this.contacts = contacts;
		this.groups = groups;
		this.locations = locations;
		count++;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ArrayList<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<Contact> contacts) {
		this.contacts = contacts;
	}

	public ArrayList<Group> getGroups() {
		return groups;
	}

	public void setGroups(ArrayList<Group> groups) {
		this.groups = groups;
	}

	public ArrayList<Location> getLocations() {
		return locations;
	}

	public void setLocations(ArrayList<Location> locations) {
		this.locations = locations;
	}

	public static void sortIDs(int AddressBookID) {
		int lastID;
		int newID;
		for (int i = 0; i < AddressBookSelection.addressBooks.get(AddressBookID).getContacts().size(); i++) {
			lastID = AddressBookSelection.addressBooks.get(AddressBookID).getContacts().get(i).getID();
			newID = i + 1;
			AddressBookSelection.addressBooks.get(AddressBookID).getContacts().get(i).setID(newID);
			for(Location ln : AddressBookSelection.addressBooks.get(AddressBookID).getLocations()) {
				if (ln.getLocationForID() == lastID) {
					ln.setLocationForID(newID);
				}
			}
		}
	}

}
