package Classes;
import java.util.ArrayList;

public class Location {
	private int locationForID;
	private String country;
	private String state;
	private String city;
	private String hood;
	private String alley;
	private double latitude;
	private double longitude;
	private double radius;
	public static int locationCount = 0;

	public Location() {
		locationCount++;
	}

	public Location(int locationForID, String country, String state, String city, String hood, String alley,
			double latitude, double longitude, double radius) {
		this.locationForID = locationForID;
		this.country = country;
		this.state = state;
		this.city = city;
		this.hood = hood;
		this.alley = alley;
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
		locationCount++;
	}

	public int getLocationForID() {
		return locationForID;
	}

	public void setLocationForID(int locationForID) {
		this.locationForID = locationForID;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHood() {
		return hood;
	}

	public void setHood(String hood) {
		this.hood = hood;
	}

	public String getAlley() {
		return alley;
	}

	public void setAlley(String alley) {
		this.alley = alley;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public static int getLocationCount() {
		return locationCount;
	}

	public static void setLocationCount(int locationCount) {
		Location.locationCount = locationCount;
	}

}
