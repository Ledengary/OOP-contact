package Classes;

import MainFrames.AddressBookSelection;
import java.util.ArrayList;
import java.util.Random;

public class Contact {
	private static final Contact Contact = null;
	int ID;
	private String firstName;
	private String lastName;
	private String mobielNumber;
	private String birthDate;
	private String livingOhrt;
	private String sex;
	private String group;
	private String eMail;
	private String profilePictureAddress;
	public static int whichAddressBookContact = -1;
	public boolean isLocated = false;

	public static int count = 0;

	public Contact() {
		count++;
	}

	public static void setLocatedTrue(int id) {
		AddressBookSelection.addressBooks.get(whichAddressBookContact).getContacts().get(id - 1).setIsLocated(true);
	}

	public Contact(int iD, String firstName, String lastName, String mobielNumber, String birthDate, String livingOhrt,
			String sex, String group, String eMail) {
		ID = iD;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobielNumber = mobielNumber;
		this.birthDate = birthDate;
		this.livingOhrt = livingOhrt;
		this.sex = sex;
		this.group = group;
		this.eMail = eMail;
		Random rnd = new Random();
		profilePictureAddress = Integer.toString(rnd.nextInt(5) + 1) + ".png";
		count++;
	}

	public boolean getIsLocated() {
		return isLocated;
	}

	public void setIsLocated(boolean isLocated) {
		this.isLocated = isLocated;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobielNumber() {
		return mobielNumber;
	}

	public void setMobielNumber(String mobielNumber) {
		this.mobielNumber = mobielNumber;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getLivingOhrt() {
		return livingOhrt;
	}

	public void setLivingOhrt(String livingOhrt) {
		this.livingOhrt = livingOhrt;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getProfilePictureAddress() {
		return profilePictureAddress;
	}

	public void setProfilePictureAddress(String profilePictureAddress) {
		this.profilePictureAddress = profilePictureAddress;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Contact.count = count;
	}

	public static int getIsLocateds(int whichAddressBook) {
		int answer = 0;
		for (Contact cn : AddressBookSelection.addressBooks.get(whichAddressBook).getContacts()) {
			if (cn.getIsLocated()) {
				answer++;
			}
		}
		return answer;
	}

	public static String findNeighbourAll(int id, boolean byGroupOrNot, int forWhichIDamISearchingFor) {
		String answer = "";
		double latitudeCn = 0;
		double longitudeCn = 0;
		double radiusCn = 0;
		// too khat badi mirim soragh gereftan riz etelaat location id moshakhas shode
		for (Location ln : AddressBookSelection.addressBooks.get(whichAddressBookContact).locations) {
			if (ln.getLocationForID() == id) {
				latitudeCn = ln.getLatitude();
				longitudeCn = ln.getLongitude();
				radiusCn = ln.getRadius();
				break;
			}
		}
		double latitudeSearch;
		double longitudeSearch;
		double radiusSearch;
		// hala mirim soragh tamami location haye set shode va check mikonim ke aya
		// location eshoon too radar radius contact moshakhas shode hast ya na
		// HOW DO I DO IT???
		// az fisaghores raftam, yani inke zire ( radikal ==> majmooe ==? ekhtelaf x ha
		// va y ha be tavan 2 ) gharare kamtar ya mosavi radius dade shode bashe (Lines
		// 179 and 205)
		for (Location lnSearch : AddressBookSelection.addressBooks.get(whichAddressBookContact).locations) {
			if (!byGroupOrNot) {
				if (lnSearch.getLocationForID() != id) {
					latitudeSearch = lnSearch.getLatitude();
					longitudeSearch = lnSearch.getLongitude();
					radiusSearch = lnSearch.getRadius();
					if (Math.sqrt(Math.pow((latitudeCn - latitudeSearch), 2)
							+ Math.pow((longitudeCn - longitudeSearch), 2)) <= radiusCn) {
						for (Contact cn : AddressBookSelection.addressBooks.get(whichAddressBookContact)
								.getContacts()) {
							if (lnSearch.getLocationForID() == cn.getID()) {
								answer += "_" + lnSearch.getLocationForID();
							}
						}
					}
				}
			} else {
				if (byGroupOrNot) {
					if (lnSearch.getLocationForID() != id) {
						for (Contact cn : AddressBookSelection.addressBooks.get(whichAddressBookContact)
								.getContacts()) {
							// ta injaye kar ma az line 174 too for i hasti ke dare tak tak located shode
							// haro mikhoone, hala miyaym too contact ha migardim o oon contact i ke barash
							// location set shode, ro peida mikonim
							if (lnSearch.getLocationForID() == cn.getID()) {
								// hala group hayi ke contact moshakhas shode tooshoone (cnMainGroups) && group
								// hayi ke contact neighbour tooshoone (cnTargetGroups) ro peida mikonim
								String[] cnTargetGroups = AddressBookSelection.addressBooks.get(whichAddressBookContact)
										.getContacts().get(lnSearch.getLocationForID() - 1).getGroup().split("_");
								String[] cnMainGroups = AddressBookSelection.addressBooks.get(whichAddressBookContact)
										.getContacts().get(forWhichIDamISearchingFor - 1).getGroup().split("_");
								for (int i = 0; i < cnTargetGroups.length; i++) {
									for (int j = 0; j < cnMainGroups.length; j++) {
										if (cnTargetGroups[i].equals(cnMainGroups[j])) {
											// ta inja yani inke main contact va target contact ham group an, hala
											// bayesti bebinim hamsaye hastan ya na !
											latitudeSearch = lnSearch.getLatitude();
											longitudeSearch = lnSearch.getLongitude();
											radiusSearch = lnSearch.getRadius();
											if (Math.sqrt(Math.pow((latitudeCn - latitudeSearch), 2)
													+ Math.pow((longitudeCn - longitudeSearch), 2)) <= radiusCn) {
												for (Contact cn2 : AddressBookSelection.addressBooks
														.get(whichAddressBookContact).getContacts()) {
													if (lnSearch.getLocationForID() == cn2.getID()) {
														answer += "_" + lnSearch.getLocationForID();
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if (answer.length() != 0) {
			answer = answer.substring(1, answer.length());
		}
		return answer;
	}

}
