package rentacar;

public class Vehicle {

	public enum VehicleStatus {
		AVAILABLE, TAKEN
	}

	private int id;

	private String manufacturer;
	private String model;
	private int year;
	private String gear;
	private String color;
	private char category;
	private int seats;
	
	private VehicleStatus status;


	Vehicle(int id, String manufacturer, String model, int year, String gear, String color, char category, int seats) {
		this.id = id;

		this.manufacturer = manufacturer;
		this.model = model;
		this.year = year;
		this.gear = gear;
		this.color = color;
		this.category = category;
		this.seats = seats;
		
		this.status = VehicleStatus.AVAILABLE;
	}

	Vehicle(String manufacturer, String model, int year, String gear, String color, char category, int seats) {
		this.id = -1;

		this.manufacturer = manufacturer;
		this.model = model;
		this.year = year;
		this.gear = gear;
		this.color = color;
		this.category = category;
		this.seats = seats;

		this.status = VehicleStatus.AVAILABLE;
}

	String getManufacturer() {
		return manufacturer;
	}

	void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	String getModel() {
		return model;
	}

	void setModel(String model) {
		this.model = model;
	}

	int getYear() {
		return year;
	}

	void setYear(int year) {
		this.year = year;
	}

	String getGear() {
		return gear;
	}

	void setGear(String gear) {
		this.gear = gear;
	}

	String getColor() {
		return color;
	}

	void setColor(String color) {
		this.color = color;
	}

	char getCategory() {
		return category;
	}

	void setCategory(char category) {
		this.category = category;
	}

	int getSeats() {
		return seats;
	}

	void setSeats(int seats) {
		this.seats = seats;
	}

	int getId() {
		return id;
	}

	void setId(int id) {
		this.id = id;
	}
	
	boolean isCompatible(char category, int seats) {
		if(category != this.category)
			return false;
		return seats <= this.seats;
	}

	boolean isAvailable() {
		return status == VehicleStatus.AVAILABLE;
	}
	
	void pickVehicle() {
		status = VehicleStatus.TAKEN;
	}
	void returnVehicle() {
		status = VehicleStatus.AVAILABLE;
	}

	
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", manufacturer=" + manufacturer + ", model=" + model + ", year=" + year
				+ ", gear=" + gear + ", color=" + color + ", category=" + category + ", seats=" + seats + ", status="
				+ status + "]";
	}
	
	
}
