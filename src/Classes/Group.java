package Classes;
import MainFrames.AddressBookSelection;
import java.util.ArrayList;

public class Group {
	private int ID;
	private String groupName;

	public Group() {

	}

	public Group(int iD, String groupName) {
		ID = iD;
		this.groupName = groupName;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public static int getGroupCount(String gpNameToSearch, int whichAddressBook) {
		int answer = 0;
		for (Group gpToSearch : AddressBookSelection.addressBooks.get(whichAddressBook).getGroups()) {
			if (gpNameToSearch.equals(gpToSearch.getGroupName())) {
				answer++;
			}
		}
		return answer;
	}

}
