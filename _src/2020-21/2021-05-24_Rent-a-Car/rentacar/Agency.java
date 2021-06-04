package rentacar;

import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Agency {
	public static final int NO_VEHICLE = -1;

	private double[] points;
	private int vehicleGlobalCounter = 0;
	private int userGlobalCounter = 0;

	private List<Vehicle> vehicles = new ArrayList<>();
	private Map<Integer, User> users = new HashMap<>();
	
	public User debugGetUser(int uuid) {
		return users.get(uuid);
	}

	private Map<Integer, List<Vehicle>> reservations = new HashMap<>();

	// R1
	/**
	 * Define points for vehicle categories (A, B, C, etc.). Number of categories is
	 * equal to the number of points provided as arguments.
	 * 
	 * @param points
	 * @throws AgencyException is thrown in case points are not given in ascending
	 *                         order
	 */
	public void definePoints(double... points) throws AgencyException {
		this.points = points;
		double last = points[0];
		for (int t = 1; t < points.length; ++t) {
			if (points[t] < last)
				throw new AgencyException("Points not in ascending order");
			last = points[t];
		}
	}

	/**
	 * Retrieves the number of points for the given category.
	 * 
	 * @param category
	 * @return number of points for the given category
	 * @throws AgencyException thrown in case category has not been defined
	 */
	public double getPointsOfCategory(char category) throws AgencyException {
		int index = category - 'A';
		if (index < 0 || index >= points.length)
			throw new AgencyException("Undefined category");
		return points[index];
	}

	/**
	 * Registers a new car to the agency with the following attributes:
	 * 
	 * @param manufacturer
	 * @param model
	 * @param year
	 * @param gear
	 * @param color
	 * @param category
	 * @param seats
	 * @return a unique vehicle id, that is assigned progressively to each vehicle,
	 *         starting from 0
	 * @throws AgencyException thrown in case the category doesn't exist
	 */
	public int addCar(String manufacturer, String model, int year, String gear, String color, char category, int seats)
			throws AgencyException {
		return addVehicle(new Car(vehicleGlobalCounter, manufacturer, model, year, gear, color, category, seats));
	}

	/**
	 * Registers a new van to the agency with the following attributes:
	 * 
	 * @param manufacturer
	 * @param model
	 * @param year
	 * @param gear
	 * @param color
	 * @param category
	 * @param seats
	 * @param limit
	 * @return a unique vehicle id, that is assigned progressively to each vehicle,
	 *         starting from 0
	 * @throws AgencyException thrown in case the category doesn't exist
	 */
	public int addVan(String manufacturer, String model, int year, String gear, String color, char category, int seats,
			int limit) throws AgencyException {
		return addVehicle(
				new Van(vehicleGlobalCounter, manufacturer, model, year, gear, color, category, seats, limit));
	}

	int addVehicle(Vehicle vehicle) throws AgencyException {
		this.getPointsOfCategory(vehicle.getCategory());
		vehicle.setId(vehicleGlobalCounter++);
		vehicles.add(vehicle);
		return vehicle.getId();
	}

	/**
	 * Retrieves the vehicle information produced by the given manufacturer.
	 * 
	 * The list is sorted based on the vehicle id.
	 * 
	 * @param manufacturer
	 * @return the list of Strings in the format `[model]:[year]:[color]`. An empty
	 *         list is returned if for a given manufacturer no car has been defined.
	 */
	public List<String> getVehiclesOfAManufacturer(String manufacturer) {
		return getVehiclesOfAManufacturer_jcf(manufacturer);
	}

	List<String> getVehiclesOfAManufacturer_jcf(String manufacturer) {
		List<String> result = new ArrayList<>();
		for (Vehicle v : vehicles) {
			if (v.getManufacturer().equals(manufacturer)) {
				result.add(String.format("%s:%d:%s", v.getModel(), v.getYear(), v.getColor()));
			}
		}
		return result;
	}

	List<String> getVehiclesOfAManufacturer_stream(String manufacturer) {
		return vehicles.stream().filter(v -> v.getManufacturer().equals(manufacturer))
				.map(v -> v.getModel() + ":" + v.getYear() + ":" + v.getColor()).collect(Collectors.toList());
	}

	// R2
	/**
	 * Registers a user to the agency with its name and city
	 * 
	 * @param name
	 * @param city
	 * 
	 * @return unique id that each user is assigned to, progressively, starting from
	 *         0
	 * @throws AgencyException thrown when a user with both same name and city has
	 *                         already been defined
	 */
	public int registerUser(String name, String city) throws AgencyException {
		User user = new User(name, city);
		if (users.values().contains(user))
			throw new AgencyException("User already defined");

		user.setId(userGlobalCounter++);
		users.put(user.getId(), user);
		System.out.println(users);
		return user.getId();
	}

	/**
	 * 
	 * Retrieves the user information in the form of a map, associating cities with
	 * user names living in those cities.
	 * 
	 * Cities are sorted alphabetically, while user names in the list are sorted in
	 * reversed alphabetical order
	 * 
	 * @return the map associating cities with the users
	 */
	public Map<String, List<String>> getUserInfo() {
		return users.values().stream().sorted(Comparator.comparing(User::getName).reversed()).collect(Collectors
				.groupingBy(User::getCity, TreeMap::new, Collectors.mapping(User::getName, Collectors.toList())));
	}

	/**
	 * Counts registered users
	 * 
	 * @return the number of registered users
	 */
	public int countUsers() {
		return userGlobalCounter;
	}

	// R3
	/**
	 * Adds a vehicle reservation. The reservation is made for the first free
	 * vehicle that satisfies the criteria, belonging to the desired category and
	 * having the number of seats higher or equal to the given one. If such vehicle
	 * exists it is immediately set to occupied. If more vehicles satisfy such
	 * criteria, the one that has been registered first is taken. On the other hand,
	 * if no such vehicle is available, no reservation is made.
	 * 
	 * For each successful reservation, the user is given a number of points
	 * associated to the category of the rented vehicle.
	 * 
	 * Note: more than one rent can be associated with a user.
	 * 
	 * @param uid
	 * @param category
	 * @param seats
	 * @param duration
	 * @return the vehicle's unique id in case a vehicle satisfying the criteria is
	 *         found otherwise, NO_VEHICLE constant is returned.
	 * @throws AgencyException thrown if a user with the given id does not exist;
	 *                         additionally, if a category does not exist, an
	 *                         exception is thrown.
	 * 
	 */
	public int makeReservation(int uid, char category, int seats, int duration) throws AgencyException {
		// check if user exists
		if (!users.containsKey(uid))
			throw new AgencyException("Non existing user");

		// ignore the result, throws if non-existing category
		getPointsOfCategory(category);

		Optional<Vehicle> result = vehicles.stream().filter(v -> v.isCompatible(category, seats) && v.isAvailable())
				.findFirst();
		if (!result.isPresent())
			return NO_VEHICLE;

		Vehicle rentedVehicle = result.get();
		rentedVehicle.pickVehicle();

		if (!reservations.containsKey(uid))
			reservations.put(uid, new ArrayList<>());
		reservations.get(uid).add(rentedVehicle);
		users.get(uid).earnPoints(getPointsOfCategory(category));
		users.get(uid).addRental(duration);

		return rentedVehicle.getId();
	}

	/**
	 * Retrieves information about users that reserved cars of the given category.
	 * 
	 * The list is sorted alphabetically.
	 * 
	 * @param category
	 * @return a list of names of the users who booked cars of the given category
	 */
	public List<String> getUserNamesForTakenCars(char category) {
		Set<Integer> result = new HashSet<>();
		for (int uid : reservations.keySet()) {
			for (Vehicle v : reservations.get(uid)) {
				if (v.getCategory() == category)
					result.add(uid);
			}
		}
		return result.stream().map(uid -> users.get(uid).getName()).sorted().collect(Collectors.toList());
	}

	/**
	 * Retrieves information about vehicles that have number of seats higher or
	 * equal to the given one.
	 * 
	 * String format for each vehicle `### [category]:[manufacturer]:[model]`, where
	 * ### stands for vehicle id (printed on 3 characters).
	 * 
	 * List is sorted alphabetically based on the vehicle category and then based on
	 * vehicle id in ascending manner.
	 * 
	 * @param seats
	 * @return the list of Strings containing vehicle information
	 */
	public List<String> getAvailableVehicles(int seats) {
		return vehicles.stream().filter(v -> v.isAvailable() && v.getSeats() >= seats)
				.sorted(Comparator.comparing(Vehicle::getCategory)).map(
				v -> String.format("%3d %c:%s:%s", v.getId(), v.getCategory(), v.getManufacturer(), v.getModel()))
				.collect(Collectors.toList());
	}

	// R4

	/**
	 * Retrieves a map that associates number of points with the user names having
	 * that number of points.
	 * 
	 * Number of points for one user is equal to the sum of points for all of the
	 * reservations the user made. Users with zero points are discarded. Points are
	 * sorted in the descending manner.
	 * 
	 * @return a map associating points with user names.
	 */
	public Map<Double, List<String>> getUsersPerPoints() {
		return users.values().stream().filter(u -> u.getPoints() > 0)
				.collect(Collectors.groupingBy(User::getPoints,
						() -> new TreeMap<Double,List<String>>(Comparator.reverseOrder()),
						Collectors.mapping(User::getName, Collectors.toList())));
	}

	/**
	 * Retrieves a map that associates user id & name,`[id]: [name]` with with the
	 * average number of rent days for that user.
	 * 
	 * The map is sorted based on the average number of rent days in descending
	 * order and then based on the user names alphabetically.
	 * 
	 * @return a map that associates user info with the average number of rent days
	 *         for that user
	 */
	public Map<String, Double> evaluateUsers() {
		return users.values().stream()
				.sorted(Comparator.comparing(User::getAvgRentDays).reversed().thenComparing(User::getName))
				.collect(Collectors.toMap(u -> String.format("%d: %s", u.getId(), u.getName()), User::getAvgRentDays));
	}

	/**
	 * Retrieves a map associating a year and information for the cars manufactured
	 * in that year.
	 * 
	 * Car info is in the following format `[manufacturer]:[model]:[color]`.
	 * 
	 * The years are sorted in the descending order.
	 * 
	 * @return a map associating year of production with the car information
	 */
	public Map<Integer, List<String>> getCarInfoForYears() {
		System.out.println(vehicles.stream().collect(Collectors.groupingBy(Vehicle::getYear),
				() -> new TreeMap<Integer, List<String>>(),
				Collectors.mapping(v -> v.toString(), null)));
		return null;

	}

	/**
	 * Retrieves a map associating vehicle number with the categories of those
	 * vehicles.
	 * 
	 * The number of vehicles is sorted in ascending manner, while the categories
	 * are sorted alphabetically. The categories with 0 vehicles should also be
	 * considered.
	 * 
	 * @return a map associating number of vehicles with the vehicle categories
	 */
	public Map<Long, List<String>> getCategoriesForVehicleNumber() {
		return null;
	}

}