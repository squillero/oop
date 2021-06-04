package rentacar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {
	private int id;
	
	private String name;
	private String city;
	
	private double points = 0.0;
	private List<Integer> rentals = new ArrayList<>();
	
	public void addRental(int days) {
		rentals.add(days);
	}
	
	public double getAvgRentDays() {
		return rentals.stream().collect(Collectors.averagingDouble(Double::valueOf));
	}

	public User(String name, String city) {
		this.id = -1;
		this.name = name;
		this.city = city;
	}
	public User(int id, String name, String city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}
	
	void earnPoints(double points) {
		this.points += points;
	}
	
	int getId() {
		return id;
	}
	void setId(int id) {
		this.id = id;
	}
	String getName() {
		return name;
	}
	String getCity() {
		return city;
	}
	double getPoints() {
		return points;
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User" + id + ": " + name + " from " + city;
	}	
}
